male(mohammed).
male(ali).
male(ahmed).
male(omar).
male(hassan).
male(ismail).
male(khalid).
male(mustafa).
male(nasir).
male(karim).
male(salim).

female(fatima).
female(sana).
female(ayesha).
female(zahra).
female(safiya).
female(huda).
female(aisha).
female(laila).
female(nadia).
female(raheel).
female(sabina).

parent(mohammed, ali).
parent(mohammed, ahmed).
parent(mohammed,sana).
parent(fatima, ali).
parent(fatima, ahmed).
parent(fatima,sana).

parent(sana,salim).

parent(ali,azar).
parent(ali, omar).
parent(ali, zahra).
parent(ayesha, azar).
parent(ayesha, omar).
parent(ayesha, zahra).

parent(salim,karim).
parent(safiya,karim).

parent(ahmed, hassan).
parent(ahmed, safiya).
parent(huda, hassan).
parent(huda, safiya).

parent(omar, ismail).
parent(aisha, ismail).

parent(hassan, khalid).
parent(laila, khalid).

parent(ismail, nasir).
parent(sabina, nasir).

parent(nadia, mustafa).
parent(khalid, mustafa).

father(X,Y):- parent(X,Y),male(X).
mother(X,Y):-parent(X,Y),female(X).
grandfather(X, Y) :- parent(X,Z),parent(Z,Y),male(X).
grandmother(X, Y) :-parent(X,Z),parent(Z,Y),female(X).
greatgrandfather(X,Y):-grandfather(X,F),parent(F,Y).
sibling(X,Y):- parent(Z,X),parent(Z,Y),X\==Y.
uncle(X,Y):-parent(Z,Y),sibling(X,Z),male(X).
aunt(X,Y):- sibling(X,Z),parent(Z,Y),female(X).
husband(X,Y):-parent(X,Z),parent(Y,Z),male(X),female(Y).
wife(X,Y):-husband(Y,X).

find_relationship(X, Y) :-
    father(X, Y), write(X), write(' is the father of '), write(Y), nl.

find_relationship(X, Y) :-
    wife(X, Y), write(X), write(' is the wife of '), write(Y), nl.

find_relationship(X, Y) :-
    mother(X, Y), write(X), write(' is the mother of '), write(Y), nl.

find_relationship(X, Y) :-
    father(Y, X), write(X), write(' is the son of '), write(Y), nl.

find_relationship(X, Y) :-
    father(Y, X),female(X), write(X), write(' is the daughter of '), write(Y), nl.

find_relationship(X, Y) :-
    grandfather(X, Y), write(X), write(' is the grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    sibling(X, Y),female(X), write(X), write(' is the sister of '), write(Y), nl.
find_relationship(X, Y) :-
    sibling(X, Y),male(X), write(X), write(' is the brother of '), write(Y), nl.

find_relationship(X, Y) :-
    uncle(X, Y), write(X), write(' is uncle of '), write(Y), nl.

find_relationship(X, Y) :-
    aunt(X, Y), write(X), write(' is aunt of '), write(Y), nl.

find_relationship(X, Y) :-
    father(Z, Y), mother(X, Z), write(X), write(' is the grandmother of '), write(Y), nl.


