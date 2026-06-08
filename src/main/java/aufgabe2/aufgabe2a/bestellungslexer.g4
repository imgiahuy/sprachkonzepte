lexer grammar bestellungslexer;

/* =========================
   1. SYMBOLS
========================= */
KOMMA       : ',' ;
PUNKT       : '.' ;
DOPPELPUNKT : ':' ;

/* =========================
   2. STRUCTURE KEYWORDS (HIGHEST PRIORITY)
========================= */
TISCH    : 'Tisch' | 'TISCH' ;
NOTE     : 'Anmerkung' ;
ABHOLUNG : 'Abholung' ;
KIND     : 'Ausser-Haus' | 'Vor-Ort' ;
BOX      : 'Pfandbox' | 'Einweg' ;

/* =========================
   3. FOOD TOKENS
========================= */
SAUCE
    : 'Erdnuss' | 'Süß-Sauer' | 'Curry' | 'Hoisin' | 'Soja'
    ;

GEBRATEN
    : 'Nasi-Goreng' | 'Bami-Goreng'
    ;

BEILAGE
    : 'Reis' | 'Nudeln' | 'Soße'
    ;

FLEISCH
    : 'Hähnchen' | 'Ente' | 'Tofu' | 'Gemüse' | 'Rind'
    ;

/* =========================
   4. NUMBERS / TIME
========================= */
NUMMER   : [0-9]+ ;
QUANTITY : [0-9]+ [xX] ;

TIME
    : ([0-1][0-9] | '2'[0-3]) ':' [0-5][0-9]
    ;

UHR : 'Uhr' | 'uhr' ;

/* =========================
   5. WORD (SAFE BUILDING BLOCK)
   (NO GREEDY SENTENCES!)
========================= */
WORD
    : [a-zA-ZäöüÄÖÜßéÉ]+ ('-' [a-zA-ZäöüÄÖÜßéÉ]+)*
    ;

/* =========================
   6. WHITESPACE
========================= */
WS : [ \t\r\n]+ -> skip ;