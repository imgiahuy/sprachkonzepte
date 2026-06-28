DETAILLIERTE GRAMMATIK- UND AST-ANALYSE
================================================================================

A) LEXER-ANALYSE: bestellungslexer.g4
================================================================================

1. TOKEN-HIERARCHIE (nach Priorität):
   
   □ Ebene 1 - SYMBOLE (höchste Priorität):
     - KOMMA: ','
     - PUNKT: '.'
     - DOPPELPUNKT: ':'
     [Diese werden zuerst gesucht, um Konflikte zu vermeiden]
   
   □ Ebene 2 - KEYWORDS (müssen vor WORD kommen):
     - TISCH: 'Tisch'|'TISCH'|'tisch'
     - NOTE: 'Anmerkung'
     - ABHOLUNG: 'Abholung'
     - KIND: 'Ausser-Haus'|'Vor-Ort'
     - BOX: 'Pfandbox'|'Einweg'
     [Case-insensitive Matching für Benutzerfreundlichkeit]
   
   □ Ebene 3 - DOMÄNEN-TOKENS:
     - SAUCE: 'Erdnuss'|'Süß-Sauer'|'Curry'|'Hoisin'|'Soja'
     - GEBRATEN: 'Nasi-Goreng'|'Bami-Goreng'
     - BEILAGE: 'Reis'|'Nudeln'|'Soße'
     - FLEISCH: 'Hähnchen'|'Ente'|'Tofu'|'Gemüse'|'Rind'
     [Spezifische Mengen-Tokens für erkannte Werte]
   
   □ Ebene 4 - ZAHLEN UND ZEIT:
     - NUMMER: [0-9]+
     - QUANTITY: [0-9]+[xX]  (z.B. "2X", "3x")
     - TIME: ([0-1][0-9]|'2'[0-3])':'[0-5][0-9]  (HH:mm Format)
     - UHR: 'Uhr'|'uhr'
     [Regex für sichere Formatvalidierung]
   
   □ Ebene 5 - GENERISCHER TEXT:
     - WORD: [a-zA-ZäöüÄÖÜßéÉ]+('-'[a-zA-ZäöüÄÖÜßéÉ]+)*
     [Unterstützt deutsche Umlaute und Bindestrich]
   
   □ Ebene 6 - WHITESPACE (wird ignoriert):
     - WS: [ \t\r\n]+  -> skip
     [Automatisch geskippt, erzeugt keine Tokens]


2. ÜBERPRÜFUNG: Token-Konflikte
   ✓ Keine Überschneidungen zwischen SAUCE/GEBRATEN/BEILAGE/FLEISCH
   ✓ KEYWORDS haben Vorrang vor WORD (Lexer-Reihenfolge)
   ✓ TIME-Regex ist präzise (evitiert invalide Zeiten wie "25:99")
   ✓ QUANTITY benötigt Ziffer vor x/X (kein "x" allein)
   ✓ Problem gelöst: TISCH case-insensitive für Benutzerfreundlichkeit


B) PARSER-ANALYSE: bestellungsparser.g4
================================================================================

1. GRAMMATIK-STRUKTUR (Kontextfreie Grammatik - CFG):
   
   bestellung
       : tischInfo KOMMA kind KOMMA 
         bestellungsdetails (KOMMA bestellungsdetails)*
         KOMMA box
         (KOMMA abholung)?
         (KOMMA anmerkung)?
         PUNKT
       ;
   
   Struktur-Analyse:
   - Start-Symbol: bestellung
   - Pflicht-Komponenten: tischInfo, kind, ≥1 bestellungsdetails, box
   - Optionale Komponenten: abholung (*), anmerkung (?)
   
   
2. REGEL-DEFINITIONEN:
   
   tischInfo → TISCH NUMMER
              Beispiel: "Tisch 100"
   
   kind → KIND
          Beispiel: "Vor-Ort"
   
   bestellungsdetails → QUANTITY gericht (itemAnmerkung)?
                       Beispiel: "2X Erdnuss Hähnchen"
                       oder: "3X Curry Gemüse, Anmerkung: ohne Zwiebeln"
   
   gericht → sauce fleisch       # Alternative 1
           | gebraten fleisch    # Alternative 2
           | beilage             # Alternative 3
           
           Alternative 1: "Erdnuss Hähnchen"
           Alternative 2: "Nasi-Goreng Ente"
           Alternative 3: "Reis"
   
   sauce → SAUCE                 # Token-Wrapper
   gebraten → GEBRATEN           # Token-Wrapper
   fleisch → FLEISCH             # Token-Wrapper
   beilage → BEILAGE             # Token-Wrapper
   
   box → QUANTITY? BOX
         Beispiel: "2X Pfandbox" oder nur "Pfandbox"
   
   abholung → ABHOLUNG DOPPELPUNKT TIME UHR?
              Beispiel: "Abholung: 10:00 Uhr" oder "Abholung: 18:30"
   
   anmerkung → NOTE DOPPELPUNKT text
               Beispiel: "Anmerkung: Bitte ohne Zwiebeln"
   
   itemAnmerkung → NOTE DOPPELPUNKT text
                   Beispiel: (inline) "Anmerkung: extra scharf"
   
   text → WORD (WORD)*
          Beispiel: "ohne Zwiebeln" oder "Bitte sehr scharf"


3. ÜBERPRÜFUNG: Grammatik-Korrektheit
   ✓ Keine linksrekursive Regeln (würden den Parser aufhängen)
   ✓ Alle Nichtterminale sind definiert
   ✓ Keine mehrdeutigen Alternativen (gericht-Aliernative sind eindeutig)
   ✓ Optionale Elemente korrekt mit ? gekennzeichnet
   ✓ Wiederholungen mit * sind sicher
   ✓ tokenVocab=bestellungslexer korrekt referenziert


C) PARSE TREE vs. AST - DETAILLIERTER VERGLEICH
================================================================================

BEISPIEL-EINGABE:
─────────────────
"Tisch 5, Vor-Ort, 2X Erdnuss Hähnchen, 1X Pfandbox."


PARSE TREE (vom Parser erzeugt):
────────────────────────────────
bestellung
│
├─ tischInfo                         ← Nichterminal
│  ├─ TISCH: "Tisch"                ← Terminal (Token)
│  └─ NUMMER: "5"                   ← Terminal (Token)
│
├─ KOMMA: ","                        ← Terminal (wird später weggelassen!)
│
├─ kind                              ← Nichterminal
│  └─ KIND: "Vor-Ort"               ← Terminal (Token)
│
├─ KOMMA: ","                        ← Terminal (wird später weggelassen!)
│
├─ bestellungsdetails               ← Nichterminal
│  ├─ QUANTITY: "2X"                ← Terminal (wird zu int konvertiert)
│  └─ gericht                        ← Nichterminal (Wrapper!)
│     ├─ sauce                       ← Nichterminal (Wrapper!)
│     │  └─ SAUCE: "Erdnuss"        ← Terminal (Token)
│     └─ fleisch                     ← Nichterminal (Wrapper!)
│        └─ FLEISCH: "Hähnchen"     ← Terminal (Token)
│
├─ KOMMA: ","                        ← Terminal (wird später weggelassen!)
│
├─ box                               ← Nichterminal
│  ├─ QUANTITY: "1X"                ← Terminal (wird zu int konvertiert)
│  └─ BOX: "Pfandbox"               ← Terminal (Token)
│
└─ PUNKT: "."                        ← Terminal (wird später weggelassen!)


AST (abstrahiert und vereinfacht):
──────────────────────────────────
Bestellung {
  tischInfo: TischInfo { 5 }
  kind: Kind { "Vor-Ort" }
  details: [
    Bestellungsdetail {
      menge: 2
      gericht: Gericht.MitSauce {
        sauce: Sauce { "Erdnuss" }
        fleisch: Fleisch { "Hähnchen" }
      }
      itemAnmerkung: null
    }
  ]
  box: Box { 1, "Pfandbox" }
  abholung: null
  anmerkung: null
}


TRANSFORMATION: PARSE TREE → AST
────────────────────────────────

SCHRITT 1: TOKENS EXTRAHIEREN
  Parse Tree     →    AST
  TISCH: "Tisch"      (weggelassen! Nur Kontext)
  NUMMER: "5"    →    int 5
  KOMMA: ","     →    (weggelassen! Separator)
  KIND: "Vor-Ort" →   String "Vor-Ort"
  QUANTITY: "2X" →    int 2
  SAUCE: "Erdnuss" →  String "Erdnuss"
  FLEISCH: "Hähnchen" → String "Hähnchen"
  BOX: "Pfandbox" → String "Pfandbox"
  PUNKT: "."     →    (weggelassen! Terminator)


SCHRITT 2: NICHTTERMINALE VEREINFACHEN
  Parse Tree                   →    AST
  sauce-Nichterminal          →    (weggelassen)
  SAUCE-Token wird direkt     →    in Sauce-Klasse
  
  gericht-Nichterminal        →    Gericht.MitSauce
  (mit sauce + fleisch)       →    (merges beide)
  
  text: [WORD WORD]           →    string "wort1 wort2"
  (mehrere Tokens)            →    (concatenated)


SCHRITT 3: OPTIONALE KOMPONENTEN BEHANDELN
  Parse Tree:                 →    AST:
  (keine abholung)            →    abholung: null
  (keine anmerkung)           →    anmerkung: null
  

ERGEBNIS: 
Aus 16 Parse-Tree-Knoten
→ 8 AST-Knoten
(50% Vereinfachung)


D) GROßER VERGLEICH
================================================================================

MERKMAL                  PARSE TREE              AST
──────────────────────────────────────────────────────────────────────
Zweck                    Parsing                 Semantik
Abhängigkeit            Grammatik               Anwendungs-Domain
Größe                   Groß                    Klein
Lesbarkeit              Granular                Abstrahiert
Struktur-Elemente       Alle                    Nur wesentliche
Terminale               Alle (incl. KOMMA)      Selektive
Nichtterminale          Alle (incl. Wrapper)    Vereinfacht
Konvertierung           N/A                     Parser→Visitor
Nutzung                 Debugging, Visua-       Program Logic,
                        lisierung               Code Generation


E) WEGGELASSENE ELEMENTE - DETAIL
================================================================================

TERMINALE (Token) die WEGGELASSEN werden:
──────────────────────────────────────────

1. KOMMA ','
   Reason: Nur Separator zwischen Komponenten
           Im AST sehen wir bereits die Feldstruktur
   Parse Tree: <bestellungsdetails>, <bestellungsdetails>
   AST: details: [detail1, detail2]

2. PUNKT '.'
   Reason: Nur Satzende-Terminator
           Im AST ist die Bestellung ein In-Memory-Objekt, nicht Text
   Parse Tree: bestellung ... PUNKT
   AST: Bestellung { ... }

3. DOPPELPUNKT ':'
   Reason: Nur Separator zwischen Label und Wert
           Im AST wird der Wert bereits dem korrekten Feld zugeordnet
   Parse Tree: abholung DOPPELPUNKT TIME
   AST: abholung: Abholung { zeit }

4. UHR 'Uhr'
   Reason: Redundant - die Zeit ist selbsterklärend
   Parse Tree: TIME UHR
   AST: Abholung { "10:00" }  ← "Uhr" ist implicit

5. TISCH Token
   Reason: Nur Keywords - die Tischnummer ist das Wichtige
   Parse Tree: TISCH NUMMER
   AST: tischInfo: TischInfo { 5 }

6. NOTE Token
   Reason: Nur Keywords - der Text der Anmerkung ist wichtig
   Parse Tree: NOTE DOPPELPUNKT text
   AST: anmerkung: Anmerkung { "text" }


NICHTTERMINALE (Grammatik-Regeln) die VEREINFACHT werden:
─────────────────────────────────────────────────────────

1. sauce, gebraten, fleisch, beilage
   Reason: Diese sind nur "Token-Wrapper"
           Sie fügen keine logische Struktur hinzu
   Parse Tree:
      gericht
       ├─ sauce
       │  └─ SAUCE: "Erdnuss"
       └─ fleisch
          └─ FLEISCH: "Hähnchen"
   
   AST:
      gericht: Gericht.MitSauce {
        sauce: Sauce { "Erdnuss" }
        fleisch: Fleisch { "Hähnchen" }
      }
   
   Wrapper-Nichtterminale entfernt!

2. text
   Reason: Mehrere einzelne Wörter zu einem String vereinigen
   Parse Tree:
      text
       ├─ WORD: "Bitte"
       ├─ WORD: "sehr"
       ├─ WORD: "scharf"
   
   AST:
      Anmerkung { "Bitte sehr scharf" }
   
   Einzelne Wörter nicht mehr sichtbar!


F) FAZIT: WARUM DIESE VEREINFACHUNG?
================================================================================

1. RELEVANZ:
   - Struktursymbole (KOMMA, PUNKT) sind für den Parser wichtig
     aber für die Anwendungslogik irrelevant
   - Der AST ist eine DOMÄNEN-SPEZIFISCHE Repräsentation
   - Im AST interessiert uns: WAS wurde bestellt, nicht WIE die
     Syntax aussah

2. EFFIZIENZ:
   - Parse Tree ist ~2x größer (wusste: 16 vs 8 Knoten)
   - Navigation ist aufwendiger (mehr Knoten zu durchlaufen)
   - AST ist optimiert für die Anwendungslogik

3. TYPSICHERHEIT:
   - Parse Tree: ParseTree-Objekte (generisch)
   - AST: Typsichere Java-Klassen (Bestellung, TischInfo, etc.)
   - Compiler kann Fehler früher erkennen

4. WARTBARKEIT:
   - Parse Tree: Abhängig von Grammatik-Änderungen
   - AST: Abstrahiert von konkreter Grammatik
   - Algorithmen können stabil bleiben, auch wenn Syntax ändert

================================================================================

