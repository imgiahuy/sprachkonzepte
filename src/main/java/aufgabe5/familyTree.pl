parent(dave, john).
parent(john, mary).
parent(john, tim).
parent(micheal, tom).
grandparent(X,Y):-parent(X,Z),parent(Z,Y).
sibling(X,Y):-parent(Z,X), parent(Z,Y), X\=Y.
ancestor(X,Y):-parent(X,Y).
ancestor(X,Y):-parent(X,Z),ancestor(Z,Y).