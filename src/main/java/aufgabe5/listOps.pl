%check x in list
member_of(X, [X|_]).
member_of(X, [_|Y]):- member(X, Y).

%length_of list
length_of([],0).
length_of([_|Y],N):- length_of(Y,N1), N is N1 + 1.

%sum_of list
sum_of([], 0).
sum_of([X|Y],N):- sum_of(Y,N1), N is N1 + X.