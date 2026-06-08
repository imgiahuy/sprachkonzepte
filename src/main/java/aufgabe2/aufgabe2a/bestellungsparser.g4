parser grammar bestellungsparser;

options {
    tokenVocab=bestellungslexer;
}

/* =========================
   ROOT
========================= */

bestellung
    : tischInfo KOMMA
      kind KOMMA
      bestellungsdetails (KOMMA bestellungsdetails)*
      KOMMA box
      (KOMMA abholung)?
      (KOMMA anmerkung)?
      PUNKT
    ;

/* =========================
   HEADER
========================= */

tischInfo
    : TISCH NUMMER
    ;

kind
    : KIND
    ;

/* =========================
   ORDER ITEMS
========================= */

bestellungsdetails
    : QUANTITY gericht (itemAnmerkung)?
    ;

gericht
    : sauce fleisch
    | gebraten fleisch
    | beilage
    ;

/* =========================
   FOOD PARTS
========================= */

sauce
    : SAUCE
    ;

gebraten
    : GEBRATEN
    ;

fleisch
    : FLEISCH
    ;

beilage
    : BEILAGE
    ;

/* =========================
   BOX
========================= */

box
    : QUANTITY? BOX
    ;

/* =========================
   TIME
========================= */

abholung
    : ABHOLUNG DOPPELPUNKT TIME UHR?
    ;

/* =========================
   ANMERKUNG (GLOBAL + INLINE)
========================= */

anmerkung
    : NOTE DOPPELPUNKT text
    ;

itemAnmerkung
    : NOTE DOPPELPUNKT text
    ;

/* =========================
   SAFE TEXT RULE (IMPORTANT FIX)
========================= */

text
    : WORD+
    ;