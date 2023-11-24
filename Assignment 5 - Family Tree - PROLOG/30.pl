% Facts: Define relationships in the family tree
male(vishnu).
male(shivaji).
male(tukaram).
male(nandu).
male(vicky).
male(ramesh).
male(jitendra).
male(rajendra).
male(sudhakar).
male(aditya).
male(ashish).
male(om).
male(sonu).
male(kapil).
male(amit).

female(mada).
female(suman).
female(jyoti).
female(prajakta).
female(lata).
female(swati).
female(hemlata).
female(mansi).
female(tanu).
female(sanu).

parent(vishnu, shivaji).
parent(vishnu, tukaram).
parent(mada, shivaji).
parent(mada, tukaram).
parent(shivaji, ramesh).
parent(shivaji, jitendra).
parent(shivaji, rajendra).
parent(shivaji, sudhakar).
parent(suman,ramesh).
parent(suman,jitendra).
parent(suman,rajendra).
parent(suman,sudhakar).
parent(jitendra,om).
parent(jitendra,tanu).
parent(prajakta,om).
parent(prajakta,tanu).
parent(sudhakar,sonu).
parent(sudhakar,sanu).
parent(swati,sonu).
parent(swati,sanu).
parent(rajendra,amit).
parent(rajendra,kapil).
parent(lata,amit).
parent(lata,kapil).
parent(ramesh,aditya).
parent(ramesh,ashish).
parent(jyoti,aditya).
parent(jyoti,ashish).
parent(tukaram,nandu).
parent(hemlata,nandu).
parent(nandu,vicky).
parent(mansi,vicky).


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

second_aunt(X, Y) :m-female(X),grandfather(W, Y), sibling(W,Z),grandfather(Z,D),mother(X,D).

second_cousin(X, Y) :- grandfather(W, Y), sibling(W,Z),grandfather(Z,X).

second_grandfather(X,Y) :- grandfather(W,Y),sibling(W,X).

second_grandmother(X,Y) :- second_uncle(W,Y),mother(X,W).

great_grandfather(X, Z) :- father(X, Y), grandfather(Y, Z).

great_grandmother(X, Z) :- mother(X, Y), grandfather(Y, Z).


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

find_relationship(X, Y) :- write('Relationship not defined between '), write(X), write(' and '), write(Y), nl.