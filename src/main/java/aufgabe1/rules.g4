lexer grammar rules;

/* ---------------- KEYWORDS ---------------- */

TAG
    : 'Montag' | 'Dienstag' | 'Mittwoch' | 'Donnerstag'
    | 'Freitag' | 'Samstag' | 'Sonntag'
    ;

RUHETAG : 'Ruhetag' ;

BIS : 'bis' ;
AN  : 'an' ;
AB  : 'ab' ;

FREQUENCY
    : 'täglich' | 'wöchentlich' | 'monatlich' | 'jährlich'
    ;

CLOSE : 'vorübergehend geschlossen' ;

WETTER : 'bei gutem Wetter' ;

UHR : 'Uhr' ;

/* ---------------- DATEN ---------------- */

/* z.B. 15. oder 1. */
DAY
    : [0-3]?[0-9] '.'
    ;

/* Monatsnamen (werden NICHT vom NAME überschrieben) */
MONTH
    : 'Januar' | 'Februar' | 'März' | 'April'
    | 'Mai' | 'Juni' | 'Juli' | 'August'
    | 'September' | 'Oktober' | 'November' | 'Dezember'
    ;

/* Uhrzeit 11.00 */
TIME
    : ([0-1][0-9] | '2'[0-3]) '.' [0-5][0-9]
    ;

/* ---------------- SYMBOLE ---------------- */

STRICH : '-' ;
KOMMA  : ',' ;
PUNKT  : '.' ;

/* ---------------- TEXTELEMENTE ---------------- */

/* Namen + zusammengesetzte Wörter */
NAME
    : [a-zA-ZäöüÄÖÜßéÉ]+ ('-' [a-zA-ZäöüÄÖÜßéÉ]+)*
    ;

/* ---------------- WHITESPACE ---------------- */

WS : [ \t\r\n]+ -> skip ;

/* ---------------- FALLBACK ---------------- */

ERROR_CHAR : . ;

/* ---------------- KOMMENTARE ---------------- */
// Terminalsymbolen