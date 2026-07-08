zug(konstanz, 08.39, offenburg, 10.59).
zug(konstanz, 08.45, offenburg, 11.15).
zug(konstanz, 08.39, karlsruhe, 11.49).
zug(konstanz, 09.06, singen, 09.31).
zug(singen, 09.36, stuttgart, 11.32).
zug(offenburg, 11.28, mannheim, 12.24).
zug(karlsruhe, 12.06, mainz, 13.47).
zug(stuttgart, 11.51, mannheim, 12.28).
zug(mannheim, 12.39, mainz, 13.18).

%direkte verbindung
verbindung(Start, Abfahrt, Ziel, [zug(Start, Ab, Ziel, An)]):-
zug(Start, Ab, Ziel, An),
Ab >= Abfahrt.

%indirekte verbindung
verbindung(Start, Abfahrt, Ziel, [zug(Start, Ab, Zwischen, An) | Rest]):-
zug(Start, Ab, Zwischen, An),
Zwischen \= Ziel,
Ab >= Abfahrt,
verbindung(Zwischen, An, Ziel, Rest).