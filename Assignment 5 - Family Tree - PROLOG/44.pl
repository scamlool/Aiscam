
% Facts: Define relationships in the family tree
male(abhi).
male(krushna).
male(manik).
male(tukaram).
male(ravi).
male(vikas).
male(ganesh).
male(rajesh).
male(aayush).
male(shirish).
male(rushi).
male(ved).
male(arpit).
male(darshil).

female(vaishali).
female(suman).
female(jyoti).
female(kusum).
female(sneha).
female(vaidehi).
female(pradhnya).
female(riya).
female(priya).
female(vedika).
female(mansi).
female(vidhya).
female(priyanka).
female(gayatri).
female(harshita).

parent(abhi, krushna).
parent(abhi, manik).
parent(abhi,tukaram).
parent(vaishali,tukaram).
parent(vaishali, krushna).
parent(vaishali, manik).
parent(krushna, ravi).
parent(krushna, vikas).
parent(suman, ravi).
parent(suman, vikas).
parent(manik,aayush).
parent(manik,ganesh).
parent(manik,rajesh).
parent(kusum,ganesh).
parent(kusum,aayush).
parent(kusum,rajesh).
parent(ravi,rushi).
parent(jyoti,rushi).
parent(vikas,arpit).
parent(vikas,vedika).
parent(sneha,arpit).
parent(sneha,vedika).
parent(shirish,darshil).
parent(shirish,riya).
parent(pradhnya,darshil).
parent(pradhnya,riya).
parent(rajesh,harshita).
parent(mansi,harshita).
parent(ganesh,gayatri).
parent(ganesh,priyanka).
parent(ganesh,ved).
parent(vidhya,gayatri).
parent(vidhya,priyanka).
parent(vidhya,ved).
parent(vaidehi,shirish).
parent(tukaram,shirish).

father(X, Y) :- male(X), parent(X, Y).

mother(X, Y) :- female(X), parent(X, Y).

wife(X,Y) :- parent(X,Z),parent(Y,Z).

father_in_law(X, Y) :- male(X),female(Y),parent(Y,T),grandfather(X,T).

mother_in_law(X, Y) :- female(X),female(Y),parent(Y,T),grandmother(X,T).

son(X, Y) :- male(X), parent(Y, X).

daughter(X, Y) :- female(X), parent(Y, X).

grandfather(X, Z) :- father(X, Y), parent(Y, Z).

deer(X,Y) :- male(W),male(X),sibling(X,W),father(W,T),mother(Y,T).

deerani(X,Y) :- mother(X,W),cousin(W,T),mother(Y,T).

grandmother(X, Z) :- mother(X, Y), parent(Y, Z).

sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

cousin(X, Y) :- parent(Z, X), parent(W, Y), sibling(Z, W).

uncle(X, Y) :- parent(Z, Y), sibling(X, Z), male(X).

aunt(X, Y) :- cousin(Z, Y), mother(X, Z), female(X).

second_uncle(X, Y) :-male(X),grandfather(W, Y), sibling(W,Z),son(X,Z).

second_aunt(X, Y) :-female(X),grandfather(W, Y), sibling(W,Z),grandfather(Z,D),mother(X,D).

second_cousin(X, Y) :- grandfather(W, Y), sibling(W,Z),grandfather(Z,X).

second_grandfather(X,Y) :- grandfather(W,Y),sibling(W,X).

second_grandmother(X,Y) :- second_uncle(W,Y),mother(X,W).

great_grandfather(X, Z) :- father(X, Y), grandfather(Y, Z).

great_grandmother(X, Z) :- mother(X, Y), grandfather(Y, Z).

second_mother_in_law(Y, X) :- female(X), female(Y), wife(X,Z), father(A,Z), sibling(B,A), wife(Y,B).

second_father_in_law(Y, X) :- female(X), female(Y), husband(X,Z), mother(A,Z), sibling(B,A), husband(Y,B).



% Your family relationships and rules here
find_relationship(X, Y) :-
    father(X, Y), write(X), write(' is the father of '), write(Y), nl.

find_relationship(X, Y) :-
    wife(X, Y), write(X), write(' is the wife of '), write(Y), nl.

find_relationship(X, Y) :-
    mother(X, Y), write(X), write(' is the mother of '), write(Y), nl.

find_relationship(X, Y) :-
    son(X, Y), write(X), write(' is the son of '), write(Y), nl.

find_relationship(X, Y) :-
    daughter(X, Y), write(X), write(' is the daughter of '), write(Y), nl.

find_relationship(X, Y) :-
    grandfather(X, Y), write(X), write(' is the grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    sibling(X, Y), write(X), write(' is the sibling of '), write(Y), nl.

find_relationship(X, Y) :-
    father(Z, Y), mother(X, Z), write(X), write(' is the grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_grandmother(X,Y), write(X), write(' is the second grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_grandfather(X,Y), write(X), write(' is the second grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    second_uncle(X, Y), write(X), write(' is the second-uncle of '), write(Y), nl.

find_relationship(X, Y) :-
    second_aunt(X, Y), write(X), write(' is the second-aunt of '), write(Y), nl.

find_relationship(X, Y) :-
    uncle(X, Y), write(X), write(' is the uncle of '), write(Y), nl.

find_relationship(X, Y) :-
    aunt(X, Y), write(X), write(' is the aunt of '), write(Y), nl.

find_relationship(X, Y) :-
    cousin(X, Y), write(X), write(' is the cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    deerani(X, Y), write(X), write(' is the deerani of '), write(Y), nl.

find_relationship(X, Y) :-
    deer(X, Y), write(X), write(' is the deer of '), write(Y), nl.

find_relationship(X, Y) :-
    second_cousin(X, Y), write(X), write(' is the second cousin of '), write(Y), nl.

find_relationship(X, Y) :-
    father_in_law(X, Y), write(X), write(' is the father-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    mother_in_law(X, Y), write(X), write(' is the mother-in-law of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandfather(X, Y), write(X), write(' is the great-grandfather of '), write(Y), nl.

find_relationship(X, Y) :-
    great_grandmother(X, Y), write(X), write(' is the great-grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_mother_in_law(X, Y), write(X), write(' is the great-grandmother of '), write(Y), nl.

find_relationship(X, Y) :-
    second_father_in_law(X, Y), write(X), write(' is the great-grandmother of '), write(Y), nl.



find_relationship(X, Y) :- write('Relationship not defined between '), write(X), write(' and '), write(Y), nl.
