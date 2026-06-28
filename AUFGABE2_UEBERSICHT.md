================================================================================
SPRACHKONZEPTE - AUFGABE 2: BESTELLUNGSSPRACHE
================================================================================

ÜBERSICHT DURCHFÜHRTER ARBEITEN
================================================================================

1. SPRACHE: Restaurant-Bestellungssprache
   - Domain-Spezifische Sprache (DSL) für Restaurant-Bestellungen
   - Enthält Tischnummer, Art (Vor-Ort/Außer-Haus), Speisen, Behältnis, Zeit
   - Unterstützt optionale Abhol- und Anmerkungszeiten

2. KOMPONENTEN

   A) LEXER (bestellungslexer.g4)
   =============================
   
   Definiert Tokens nach Priorität:
   
   - STRUKTUR-SYMBOLE: KOMMA',', PUNKT'.', DOPPELPUNKT':'
   - KEYWORDS: TISCH, NOTE, ABHOLUNG, KIND, BOX, UHR
   - SPEISEN-TOKENS:
     * SAUCE: Erdnuss, Süß-Sauer, Curry, Hoisin, Soja
     * GEBRATEN: Nasi-Goreng, Bami-Goreng
     * BEILAGE: Reis, Nudeln, Soße
     * FLEISCH: Hähnchen, Ente, Tofu, Gemüse, Rind
   - ZAHLEN UND ZEIT:
     * NUMMER: Ziffernfolge [0-9]+
     * QUANTITY: Menge mit x/X [0-9]+[xX]
     * TIME: Uhrzeit HH:mm Format
   - TEXT: WORD mit Umlauten und Bindestrich
   - WHITESPACE: wird ignoriert
   
   STATUS: ✓ KORREKT
   

   B) PARSER (bestellungsparser.g4)
   ================================
   
   Grammatik-Regeln:
   
   bestellung
       : tischInfo KOMMA kind KOMMA 
         bestellungsdetails (KOMMA bestellungsdetails)*
         KOMMA box
         (KOMMA abholung)?
         (KOMMA anmerkung)?
         PUNKT
       ;
   
   tischInfo : TISCH NUMMER ;
   kind : KIND ;
   
   bestellungsdetails
       : QUANTITY gericht (itemAnmerkung)?
       ;
   
   gericht
       : sauce fleisch
       | gebraten fleisch
       | beilage
       ;
   
   sauce : SAUCE ;
   gebraten : GEBRATEN ;
   fleisch : FLEISCH ;
   beilage : BEILAGE ;
   
   box : QUANTITY? BOX ;
   abholung : ABHOLUNG DOPPELPUNKT TIME UHR? ;
   anmerkung : NOTE DOPPELPUNKT text ;
   itemAnmerkung : NOTE DOPPELPUNKT text ;
   text : WORD (WORD)* ;
   
   STATUS: ✓ KORREKT
   

   C) ABSTRAKTE SYNTAX (AST)
   =========================
   
   Java-Klassen im Paket aufgabe2.aufgabe2a.ast:
   
   - Bestellung: Root-Knoten mit allen Komponenten
   - TischInfo: Tischnummer (int)
   - Kind: Bestellungstyp (String)
   - Bestellungsdetail: Menge + Gericht + optionale Anmerkung
   - Gericht: Abstrakte Klasse mit 3 Subtypen:
     * MitSauce(sauce, fleisch)
     * MitGebraten(gebraten, fleisch)
     * NurBeilage(beilage)
   - Basis-Komponenten: Sauce, Gebraten, Fleisch, Beilage (Wertelklassen)
   - Box: Menge + Typ
   - Abholung: Zeit (String)
   - Anmerkung: Text (String)
   
   Besonderheit: ParseTreeToASTConverter nutzt Reflection, um mit
   generierten Parser-Klassen kompatibel zu sein
   

3. ANALYSE: PARSE TREE vs. AST
   ============================
   
   WEGGELASSENE TERMINALE (Token) im AST:
   - KOMMA: nur Strukturtrennzeichen, keine semantische Bedeutung
   - PUNKT: nur Satzende-Terminator
   - DOPPELPUNKT: nur Separator zwischen Label und Wert
   - UHR: redundant, Zeit ist ausreichend
   - TISCH: Keyword wird weggelassen, nur Nummer ist relevant
   - NOTE: Keyword wird weggelassen, nur Text ist relevant
   - ABHOLUNG: Keyword wird weggelassen, nur Zeit ist relevant
   
   WEGGELASSENE NICHTTERMINALE (Grammatik-Regeln):
   - sauce, gebraten, fleisch, beilage: Diese sind Wrapper um
     Token und werden verflacht - nur die Token-Werte bleiben
   - text: Mehrere WORD-Token werden zu einem einfachen String
     zusammengefasst, statt eine Liste von Wörtern zu speichern
   
   RESULTAT:
   Parse Tree enthält ALLE grammatikalischen Details
   AST enthält nur SEMANTISCH RELEVANTE Informationen


4. BEISPIELE
   ==========
   
   EINGABE:
   "Tisch 5, Vor-Ort, 1X Erdnuss Hähnchen, 1X Pfandbox."
   
   PARSE TREE (vereinfacht):
   bestellung
     tischInfo: TISCH[Tisch] NUMMER[5]
     kind: KIND[Vor-Ort]
     bestellungsdetails:
       QUANTITY[1X]
       gericht:
         sauce: SAUCE[Erdnuss]
         fleisch: FLEISCH[Hähnchen]
     box: BOX[Pfandbox]
     PUNKT[.]
   
   AST:
   Bestellung{
     TischInfo{5}
     Kind{Vor-Ort}
     Details: [Detail{1x Erdnuss Hähnchen}]
     Box{1x Pfandbox}
   }
   
   Beobachtung: Im Parse Tree sind ALLE Strukturen sichtbar
   (tischInfo Rule, sauce Rule, etc.), im AST sind nur die
   semantischen Werte vorhanden.


5. AUTOMATISCHE PARSE TREE VISUALISIERUNG
   ========================================
   
   Mit org.antlr.v4.gui.TestRig können Parse Trees grafisch
   visualisiert werden:
   
   Methode 1 (mit ANTLR installierten Tools):
   > grun bestellungsparser bestellung -gui
   [Dann Eingabe in stdin eingeben]
   
   Methode 2 (mit Java-Programm):
   Die TestRig-Klasse wird direkt aus Java aufgerufen
   
   Der Main.java in aufgabe2a zeigt Beispiele mit
   Parse Tree String-Ausgabe


6. ÜBERPRÜFUNG LEXER UND PARSER
   =============================
   
   ✓ LEXER bestellungslexer.g4:
     - Alle Tokens sind definiert
     - Prioritäten sind sinnvoll (KEYWORDS vor WORD)
     - Whitespace wird korrekt ignoriert
     - Unterstützung für Umlaute und Sonderzeichen
     - Quantity-Pattern ist korrekt
     - Time-Pattern ist korrekt formatiert
   
   ✓ PARSER bestellungsparser.g4:
     - Alle Regeln sind konsistent
     - Grammatik ist recursive-descent-kompatibel
     - Optionale Elemente sind mit ? richtig gekennzeichnet
     - Wiederholungen mit * sind richtig
     - Alternationen mit | sind richtig
     - Text-Regel unterstützt mehrere Wörter
   
   ✓ FEHLERFREIE GRAMMATIK:
     - Keine Konflikte zwischen Tokens
     - Keine mehrdeutigen Regeln
     - Alle Nichtterminale sind definiert


7. BESONDERE FEATURES
   ==================
   
   - Case-Insensitivity für TISCH und UHR
   - Flexible Fleisch-Kombinationen (Sauce+Fleisch oder Gebraten+Fleisch)
   - Optionale Abholung und Anmerkungen
   - Unterstützung für deutsche Umlaute
   - Bindestrich in Speisennamen (z.B. "Nasi-Goreng", "Süß-Sauer", "Ausser-Haus")


8. DATEIEN ÜBERSICHT
   ==================
   
   Lexer:
   - src/main/java/aufgabe2/aufgabe2a/bestellungslexer.g4
   - src/main/java/aufgabe2/aufgabe2a/bestellungslexer.java (generiert)
   
   Parser:
   - src/main/java/aufgabe2/aufgabe2a/bestellungsparser.g4
   - src/main/java/aufgabe2/aufgabe2a/gen/bestellungsparser.java (generiert)
   - src/main/java/aufgabe2/aufgabe2a/gen/bestellungsparser*Listener.java (generiert)
   - src/main/java/aufgabe2/aufgabe2a/gen/bestellungsparser*Visitor.java (generiert)
   
   AST Klassen:
   - src/main/java/aufgabe2/aufgabe2a/ast/*.java
   
   Konverter:
   - src/main/java/aufgabe2/aufgabe2a/ast/ParseTreeToASTConverter.java
   
   Main-Programm:
   - src/main/java/aufgabe2/aufgabe2a/Main.java


9. KOMPILIERUNG UND AUSFÜHRUNG
   ============================
   
   Mit Maven:
   $ mvn clean compile exec:java -Dexec.mainClass="aufgabe2.aufgabe2a.Main"
   
   Mit Java direkt (falls kompiliert):
   $ javac -cp path/to/antlr-4.13.1-complete.jar src/main/java/...
   $ java -cp path/to/antlr-4.13.1-complete.jar:target/classes aufgabe2.aufgabe2a.Main


10. ZUSAMMENFASSUNG
    ================
    
    Diese Aufgabe demonstriert den vollständigen ANTLR4-Workflow:
    
    1. Lexer-Grammatik schreiben (Tokens definieren)
    2. Parser-Grammatik schreiben (Regeln definieren)
    3. ANTLR Tools ausführen (Code generieren)
    4. AST-Klassen definieren (semantische Struktur)
    5. Parser Tree zu AST konvertieren (Abstraktion)
    6. Beispiele testen und visualisieren
    
    Verstehen Sie den Unterschied:
    - Parse Tree: Alle grammatikalischen Details (vom Parser)
    - AST: Nur semantisch relevante Information (app-spezifisch)


================================================================================

