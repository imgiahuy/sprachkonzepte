"""
Aufgabe 7 - Scriptsprachen: Abfrage der Feiertage-API
Demonstriert typische Eigenschaften einer Scriptsprache am Beispiel Python.

API: https://feiertage-api.de/api/?jahr=YYYY&nur_land=BY
"""

import urllib.request
import json
import sys


def lade_feiertage(jahr, bundesland="BY"):
    url = f"https://feiertage-api.de/api/?jahr={jahr}&nur_land={bundesland}"
    with urllib.request.urlopen(url) as response:
        rohdaten = response.read().decode("utf-8")
    return json.loads(rohdaten)


def zeige_feiertage(feiertage, bundesland, jahr, ab_datum=None):
    if ab_datum:
        feiertage = {n: i for n, i in feiertage.items() if i.get("datum", "") >= ab_datum}
        print(f"\nFeiertage {jahr} - Bundesland: {bundesland} (ab {ab_datum})")
    else:
        print(f"\nFeiertage {jahr} - Bundesland: {bundesland}")
    print("-" * 45)
    for name, info in feiertage.items():
        datum = info.get("datum", "?")
        print(f"  {datum}  {name}")
    print(f"\nGesamt: {len(feiertage)} Feiertage")
    return feiertage


def ist_feiertag(feiertage, datum):
    treffer = {name: info for name, info in feiertage.items() if info.get("datum") == datum}
    return treffer


def naechster_feiertag(feiertage):
    from datetime import date
    heute = date.today()
    zukuenftige = {
        name: info for name, info in feiertage.items()
        if info.get("datum", "") >= str(heute)
    }
    if not zukuenftige:
        return None, None
    naechster_name = min(zukuenftige, key=lambda n: zukuenftige[n]["datum"])
    return naechster_name, zukuenftige[naechster_name]["datum"]


def main():
    from datetime import date

    jahr = sys.argv[1] if len(sys.argv) > 1 else "2025"
    bundesland = sys.argv[2] if len(sys.argv) > 2 else "BY"
    pruef_datum = sys.argv[3] if len(sys.argv) > 3 else None

    if pruef_datum == "heute":
        pruef_datum = str(date.today())

    print(f"Rufe Feiertage-API ab: jahr={jahr}, bundesland={bundesland} ...")

    feiertage = lade_feiertage(jahr, bundesland)

    if pruef_datum:
        treffer = ist_feiertag(feiertage, pruef_datum)
        if treffer:
            for name in treffer:
                print(f"\nJa! {pruef_datum} ist ein Feiertag: {name}")
        else:
            print(f"\nNein, {pruef_datum} ist kein Feiertag in {bundesland}.")
        return

    gefiltert = zeige_feiertage(feiertage, bundesland, jahr)

    name, datum = naechster_feiertag(gefiltert)
    if name:
        print(f"\nNaechster Feiertag: {datum} - {name}")

    print("\n--- Typen-Demo (Duck Typing / dynamische Typisierung) ---")
    ergebnis = feiertage
    print(f"  type(feiertage)          = {type(ergebnis)}")
    erster_key = next(iter(ergebnis))
    erster_wert = ergebnis[erster_key]
    print(f"  type(erster Eintrag)     = {type(erster_wert)}")
    print(f"  Felder im Eintrag        = {list(erster_wert.keys())}")

    ergebnis = list(ergebnis.values())
    print(f"  type(nach list())        = {type(ergebnis)}")
    ergebnis = len(ergebnis)
    print(f"  type(nach len())         = {type(ergebnis)}")
    print(f"  Selbe Variable, 4 Typen: dict -> dict_values -> list -> int")


if __name__ == "__main__":
    main()
