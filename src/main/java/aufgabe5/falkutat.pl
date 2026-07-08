fak(0,1). % Basisfall
fak(N,K):- N > 0, N1 is N - 1,
fak(N1,K1), K is K1 * N.