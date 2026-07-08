# Sprachkonzepte

Dieses Repository enthält die Übungsaufgaben aus dem Modul **Sprachkonzepte**. Die einzelnen Aufgaben sind unter `src/main/java/` als eigene Pakete organisiert und behandeln verschiedene Aspekte der Sprachdefinition, -verarbeitung und -vergleich.

## Projektaufbau

Das Projekt ist ein Maven-Projekt (`pom.xml`) für **Java 22** und nutzt vor allem **ANTLR4** sowie dessen Runtime.

- **Build-Tool:** Maven
- **Java-Version:** 22
- **Haupthängigkeiten:** ANTLR4 Runtime, ANTLR4, StringTemplate (über Maven lokal geladen)

## Aufgabenübersicht

### Aufgabe 1 – Lexer mit ANTLR4

- **Verzeichnis:** `src/main/java/aufgabe1/`
- Definiert in `rules.g4` einen Lexer für deutsche Öffnungszeit-Texte (z. B. für Gastronomie auf der Mainau).
- `tokenreader.java` liest eine Beispieldatei ein und gibt die erkannten Token aus.
- Beispieldateien:
  - `mainau-gatronomie.txt`
  - `gleiche-art.txt`

### Aufgabe 2 & Aufgabe 3 – Parser, AST und Semantik

- **Verzeichnis:** `src/main/java/aufgabe2/aufgabe2ab/`
- **Hinweis:** Aufgabe 3 ist als Fortsetzung von Aufgabe 2 im selben Verzeichnis realisiert.
- Definiert eine kleine Bestellungssprache für ein asiatisches Restaurant.
- Bestandteile:
  - Lexer/Grammatik (`bestellungsLexer.g4`, `bestellungsParser.g4`)
  - AST-Modell (`ast/`)
  - Parse-Tree-Konvertierung
  - Statische Semantik-Prüfung (`StaticSemanticsChecker.java`)
  - Dynamische Semantik: Preisberechnung und Quittungsgenerierung (`PriceCalculator.java`)
  - Demonstrationsklassen wie `Main.java` und `SemanticsDemo.java`
- Testbeispiele liegen unter `test_examples/`.

### Aufgabe 4 – Funktional vs. prozedural

- **Verzeichnis:** `src/main/java/aufgabe4/`
- Vergleicht funktionale und prozedurale Programmierung in Java anhand derselben Aufgabe:
  - `Funktional.java` löst das Problem mit Java-Streams.
  - `Procedural.java` löst es mit klassischen Schleifen und Hilfsmethoden.
- Beide Programme filtern leere und kurze Zeilen aus einer Datei und summieren die restlichen Zeilenlängen.
- Beispieldateien: `test.txt`, `1mb-examplefile-com.txt`, `20mb-examplefile-com.txt`

### Aufgabe 5 – Logikprogrammierung mit Prolog

- **Verzeichnis:** `src/main/java/aufgabe5/`
- Enthält mehrere kleine Prolog-Programme:
  - `helloWorld.pl`
  - `falkutat.pl`
  - `familyTree.pl`
  - `listOps.pl`
  - `trains.pl` – Zugverbindungen und direkte/indirekte Routen

### Aufgabe 6 – Code-Generierung mit StringTemplate

- **Verzeichnis:** `src/main/java/aufgabe6/`
- Liest per Java-Reflection die Interfaces und Methoden einer Klasse aus.
- Generiert daraus mit **StringTemplate** (`aufgabe6.stg`) eine HTML-Dokumentation.
- Hauptklasse: `Aufgabe6.java`
- Template: `aufgabe6.stg`
- Beispielausgabe: `output.html`

### Aufgabe 7 – Scriptsprachen: Python

- **Verzeichnis:** `src/main/java/aufgabe7/`
- `feiertage.py` zeigt typische Eigenschaften einer Scriptsprache am Beispiel Python.
- Ruft die Feiertage-API (`feiertage-api.de`) ab und kann Feiertage anzeigen, filtern, auf einen bestimmten Tag prüfen und den nächsten Feiertag ermitteln.

## Schneller Start

```bash
# Projekt bauen
mvn clean compile

# Aufgabe 2/3 Semantik-Demo ausführen (konfiguriert in pom.xml)
mvn exec:java

# Einzelne Klassen manuell ausführen (Beispiel)
mvn exec:java -Dexec.mainClass="aufgabe2.aufgabe2ab.Main"
```

## Hinweise

- Viele `.java`-Dateien mit `rules.java` oder `bestellungsLexer.java`/`bestellungsParser.java` sind **von ANTLR4 generiert** und werden beim Bauen neu erzeugt.
- Die Datei `cp.txt` enthält eine vorbereitete Classpath-Liste für manuelle Aufrufe.
- Die Datei `abfahrt-kn.txt` ist ein Beispieltext für Öffnungs-/Abfahrtszeiten im Kontext von Aufgabe 1.
