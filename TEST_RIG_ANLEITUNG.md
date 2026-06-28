# TestRig Anleitung - Parse Tree Visualisierung

## Überblick
TestRig ist ein ANTLR4-Tool zur Visualisierung von Parse Trees. Es ermöglicht grafische Darstellung der Ableitungsbäume für Ihre Eingaben.

## Voraussetzungen
1. Projekt ist kompiliert (`mvn clean compile`)
2. ANTLR Runtime ist im Classpath verfügbar
3. Java ist installiert

## Methode 1: Über Batch-Script (Windows - einfachste Methode)

### Schritt 1: Kompilieren
```powershell
cd C:\sem7\SPR\sprachkonzepte
mvn clean compile
```

### Schritt 2: TestRig ausführen
```powershell
# Beispiel 1 anzeigen
.\run_testrig.bat 1

# Beispiel 2 anzeigen
.\run_testrig.bat 2

# Beispiel 3 anzeigen
.\run_testrig.bat 3
```

Es öffnet sich ein GUI-Fenster mit dem Parse Tree!

---

## Methode 2: PowerShell Kommandozeile (direkt)

```powershell
$projectDir = "C:\sem7\SPR\sprachkonzepte"
$targetDir = "$projectDir\target\classes"
$inputFile = "$projectDir\test_examples\example1.txt"

cd $projectDir

# Text eingeben und TreeViewer starten
Get-Content $inputFile | java -cp $targetDir org.antlr.v4.gui.TestRig aufgabe2.aufgabe2ab.gen.bestellungsparser bestellung -gui
```

---

## Methode 3: Interaktive Eingabe

```powershell
cd C:\sem7\SPR\sprachkonzepte
java -cp target\classes org.antlr.v4.gui.TestRig aufgabe2.aufgabe2ab.gen.bestellungsparser bestellung -gui
```

Dann: Text direkt eingeben, ENTER drücken.

---

## Syntax für TestRig Kommandozeile

```
java -cp <CLASSPATH> org.antlr.v4.gui.TestRig <PARSER-KLASSE> <START-REGEL> [-OPTIONS] [INPUT]
```

### Parameter für unser Projekt:

| Parameter | Wert | Beschreibung |
|-----------|------|-------------|
| CLASSPATH | `target/classes` | Kompilierte Klassen |
| PARSER-KLASSE | `aufgabe2.aufgabe2ab.gen.bestellungsparser` | Voll qualifizierter Name |
| START-REGEL | `bestellung` | Root-Regel aus .g4 |
| `-gui` | (Flag) | Grafische Baumansicht |
| `-tree` | (Alternative) | Text-Baumansicht (Terminal) |

---

## Optionen:

- **`-gui`**: GUI TreeViewer öffnet sich (empfohlen)
- **`-tree`**: Text-Baum im Terminal anzeigen
- **`-tokens`**: Nur die Tokens anzeigen

---

## Beispiele:

### Beispiel 1: GUI TreeViewer (Best)
```powershell
java -cp target\classes org.antlr.v4.gui.TestRig aufgabe2.aufgabe2ab.gen.bestellungsparser bestellung -gui < test_examples\example1.txt
```

### Beispiel 2: Text Tree (Terminal)
```powershell
Get-Content test_examples\example1.txt | java -cp target\classes org.antlr.v4.gui.TestRig aufgabe2.aufgabe2ab.gen.bestellungsparser bestellung -tree
```

### Beispiel 3: Tokens anzeigen
```powershell
Get-Content test_examples\example1.txt | java -cp target\classes org.antlr.v4.gui.TestRig aufgabe2.aufgabe2ab.gen.bestellungsparser bestellung -tokens
```

---

## Testdateien

Es wurden folgende Beispieldateien erstellt:

### example1.txt
```
Tisch 5, Abendessen, 2X Hollandaise Rind, 1X Kräuterbutter Schwein Bratkartoffeln, Pfandbox, Abholung: 19:00, Notiz: Schwein nicht zu scharf.
```

### example2.txt
```
Tisch 12, Mittagessen, 1X Bernaise Rind, 3X Salat, Einweg.
```

### example3.txt
```
Tisch 3, Brunch, 1X Rarität Hähnchen Kartoffelsuppe Notiz: extra Sauce, 2X Marinara Fisch Risotto, 2X Pfandbox, Abholung: 12:30.
```

---

## GUI-Features

In der GUI-Ansicht können Sie:
- **Knoten expandieren/kollabieren** (Doppelklick)
- **Zoom** mit Mausrad
- **Pan** mit Mauszeiger
- **Knoten inspizieren** um Details zu sehen

---

## Troubleshooting

### Fehler: "Klasse nicht gefunden"
→ Stellen Sie sicher, dass Sie zuerst kompiliert haben: `mvn clean compile`

### Fehler: "StartRule nicht erkannt"
→ Überprüfen Sie, dass `bestellung` tatsächlich in Ihrer .g4 Datei definiert ist

### Fehler: "Parse Error"
→ Die Eingabe erfüllt nicht die Grammatik. Überprüfen Sie das Format.

### GUI öffnet sich nicht
→ Stellen Sie sicher, dass Sie X11/GUI-Unterstützung haben. Nutzen Sie stattdessen `-tree` Option.

---

## Tipps

1. **Größere Eingabetexte**: Speichern Sie in `.txt` Dateien, nicht als Kommandozeilenargumente
2. **Regex-Testing**: Nutzen Sie auch die Lexer-Regeln mit `-tokens`
3. **Fehleranalyse**: Nutzen Sie `-tree` um genaue Parse-Fehler zu sehen

