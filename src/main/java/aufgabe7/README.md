# Aufgabe 7 — Scriptsprache: Python + Feiertage-API

## Aufgabenstellung

Implementierung einer kleinen Anwendung mit einer Scriptsprache und Analyse
der dabei genutzten typischen Skriptsprachen-Eigenschaften.

**Gewählte Umsetzung:** Python-Skript zur Abfrage der öffentlichen REST-API
[feiertage-api.de](https://feiertage-api.de), das Feiertage für ein
Bundesland und Jahr abruft, ausgibt und den nächsten Feiertag ermittelt.

---

## Ausführen

```bash
# Standardaufruf (Bayern 2025)
python feiertage.py

# Beliebiges Jahr und Bundesland
python feiertage.py 2026 NW
```

Kein Compile-Schritt. Keine externe Abhängigkeit außer der Python-Standardbibliothek.

### Beispiel-Ausgabe

```
Rufe Feiertage-API ab: jahr=2025, bundesland=BY ...

Feiertage 2025 - Bundesland: BY
---------------------------------------------
  2025-01-01  Neujahr
  2025-01-06  Heilige Drei Könige
  2025-04-18  Karfreitag
  ...

Gesamt: 13 Feiertage

Naechster Feiertag: 2025-08-15 - Mariä Himmelfahrt

--- Typen-Demo (Duck Typing / dynamische Typisierung) ---
  type(feiertage)          = <class 'dict'>
  type(erster Eintrag)     = <class 'dict'>
  Felder im Eintrag        = ['datum', 'hinweis']
  type(nach list())        = <class 'list'>
  type(nach len())         = <class 'int'>
  Selbe Variable, 4 Typen: dict -> dict_values -> list -> int
```

---

## Analyse: Genutzte Eigenschaften einer Scriptsprache

### 1. Kein Compile-Schritt — direkte Interpretation

```bash
python feiertage.py   # Sofortige Ausführung, kein mvn compile, kein .class
```

Python-Code wird vom Interpreter direkt gelesen und ausgeführt.
Im Vergleich zu Java: kein `javac`, kein Bytecode, kein JVM-Start-Overhead für
den Entwickler. Das macht Scriptsprachen ideal für Automatisierung, Glue-Code
und schnelle Entwicklungszyklen.

---

### 2. Dynamische Typisierung

```python
ergebnis = feiertage           # dict
ergebnis = list(ergebnis.values())  # list
ergebnis = len(ergebnis)       # int
```

Die Variable `ergebnis` wechselt ihren Typ zur Laufzeit — kein Cast, keine
Typdeklaration. In Java wäre dies nicht möglich ohne explizite Neudefinition
(`Object` + Casts). Die Typen werden erst zur Laufzeit geprüft.

---

### 3. Duck Typing

```python
for name, info in feiertage.items():   # feiertage ist ein dict
    datum = info.get("datum", "?")
```

`feiertage.items()` liefert Paare, über die iteriert wird — egal welcher
konkrete Typ zurückgegeben wird (`dict_items`, `list of tuples`, etc.).
Python prüft nur, ob das Objekt das nötige Protokoll unterstützt (`__iter__`,
`__next__`), nicht ob es von einer bestimmten Klasse erbt. Solange ein Objekt
sich wie ein Iterable "verhält", funktioniert der Code.

---

### 4. Eingebaute High-Level-Datenstrukturen

```python
feiertage = json.loads(rohdaten)   # → direkt ein dict[str, dict]
name = min(zukuenftige, key=lambda n: zukuenftige[n]["datum"])
```

JSON wird ohne eigene Model-Klassen direkt in native Python-Strukturen
(`dict`, `list`, `str`) umgewandelt. In Java (Aufgabe 6) wurden dafür
explizite Modellklassen (`ClassModel`, `MethodModel`) benötigt.
`min()` mit `key=lambda` zeigt First-Class-Functions — Funktionen als Werte.

---

### 5. First-Class Functions / Lambdas

```python
naechster_name = min(zukuenftige, key=lambda n: zukuenftige[n]["datum"])
```

Anonyme Funktionen (`lambda`) werden direkt als Argument übergeben, ohne
vorher eine Klasse oder eine benannte Methode zu definieren. In Java wäre
hierfür ein `Comparator`-Lambda oder eine anonyme Klasse nötig.

---

### 6. Automatisches Ressourcenmanagement (RAII / Context Manager)

```python
with urllib.request.urlopen(url) as response:
    rohdaten = response.read().decode("utf-8")
```

Der `with`-Block garantiert das Schließen der HTTP-Verbindung — ohne
explizites `try/finally` und ohne manuelles `close()`. Der Garbage Collector
und das Context-Manager-Protokoll übernehmen das Ressourcenmanagement.

---

### 7. Glue-Code / Interoperabilität

```python
import urllib.request
import json
import sys
```

Netzwerkzugriff, JSON-Parsing und Kommandozeilenargumente in 3 Imports aus
der Standardbibliothek. Keine zusätzlichen Abhängigkeiten, kein Dependency
Management (kein `pom.xml`). Scriptsprachen sind für solchen Glue-Code
zwischen Systemen/APIs entworfen.

---

### 8. Introspection zur Laufzeit

```python
print(f"  type(feiertage) = {type(ergebnis)}")
print(f"  Felder          = {list(erster_wert.keys())}")
```

Python erlaubt vollständige Selbstbeobachtung zur Laufzeit: `type()`, `dir()`,
`.keys()` auf beliebigen Objekten — ohne vorherige Typdeklaration. In Java
ist dafür die Reflection-API (`Class.forName`, `getMethods`) nötig, die in
Aufgabe 6 explizit eingesetzt wurde. In Python ist Introspection natürlicher
Bestandteil der Sprache.

---

## Zusammenfassung

| Eigenschaft | Wo im Code | Java-Vergleich |
|---|---|---|
| Kein Compile-Schritt | `python feiertage.py` | `mvn compile` + `java ...` |
| Dynamische Typisierung | Variable `ergebnis` | Explizite Typen nötig |
| Duck Typing | `for name, info in feiertage.items()` | Interface-Implementierung nötig |
| High-Level-Datenstrukturen | `json.loads()` → `dict` | Modellklassen nötig |
| First-Class Functions | `lambda` in `min()` | `Comparator`-Interface |
| Automatisches Ressourcenmanagement | `with urllib...` | `try/finally` + `close()` |
| Glue-Code / wenig Boilerplate | 3 Imports, kein pom.xml | Maven-Dependency nötig |
| Introspection | `type()`, `.keys()` | Reflection-API (Aufgabe 6) |

Python zeigt deutlich: Scriptsprachen sind für schnelle, flexible und
integrierende Aufgaben optimiert — auf Kosten von statischer Typsicherheit
und Kompilier-Zeit-Prüfungen.
