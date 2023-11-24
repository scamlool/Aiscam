% Facts about the family members
male(suresh).
male(janaklal).
male(omprakash).
male(sudhir).
male(vinod).
male(sandesh).
male(sandeep).
male(sumit).
male(varun).
male(rohan).
male(gaurav).
male(jp).
male(ved).
female(laxmi).
female(sushila).
female(seema).
female(sangita).
female(sadhna).
female(taruna).
female(sarita).
female(bhawana).
female(leena).
female(riya).
female(sakshee).
female(tanvi).
female(palak).
female(niddhi).
female(dhara).
female(pari).
female(anjali).

% Parent-child relationships
parent(suresh, sarita).
parent(suresh, sadhna).
parent(suresh, taruna).
parent(suresh, bhawana).
parent(suresh, leena).
parent(laxmi, sarita).
parent(laxmi, sadhna).
parent(laxmi, taruna).
parent(laxmi, bhawana).
parent(laxmi, leena).
parent(janaklal, sandeep).
parent(janaklal, seema).
parent(janaklal, sangita).
parent(sushila, sandeep).
parent(sushila, seema).
parent(sushila, sangita).
parent(sandeep, sakshee).
parent(sandeep, palak).
parent(leena, sakshee).
parent(leena, palak).
parent(sandesh, riya).
parent(sandesh, tanvi).
parent(bhawana, riya).
parent(bhawana, tanvi).
parent(vinod,varun).
parent(vinod,rohan).
parent(taruna,varun).
parent(taruna,rohan).
parent(sudhir,sumit).
parent(sarita,sumit).
parent(omprakash,niddhi).
parent(omprakash,gaurav).
parent(sangita,niddhi).
parent(sangita,gaurav).
parent(niddhi,dhara).
parent(niddhi,pari).
parent(jp,dhara).
parent(jp,pari).
parent(anjali,ved).
parent(varun,ved).

% Marriage relationships
married(suresh, laxmi).
married(janaklal,sushila).
married(sudhir, sarita).
married(vinod, taruna).
married(sandesh,bhawana).
married(sandeep,leena).
married(omprakash,sangita).
married(jp,niddhi).
married(varun,anjali).


% Rules to define relationships
maternal_grandmother(X,Y):- female(X),parent(X,Z),female(Z),parent(Z,Y).

maternal_grandfather(X,Y):- male(X),parent(X,Z),female(Z),parent(Z,Y).

paternal_grandmother(X,Y):- female(X),parent(X,Z),male(Z),parent(Z,Y).

paternal_grandfather(X,Y):- male(X),parent(X,Z),male(Z),parent(Z,Y).

mother(X,Y):- female(X),parent(X,Y).

father(X,Y):- male(X),parent(X,Y).

brother(X,Y):- male(X),parent(Z,X),parent(Z,Y),X\=Y.

sister(X,Y):- female(X),parent(Z,X),parent(Z,Y),X\=Y.

sibling(X,Y):-parent(Z,X),parent(Z,Y),X\=Y.

child(X,Y):- parent(Y,X).

husband(X,Y):- male(X),female(Y),married(X,Y).

wife(X,Y):- female(X),male(Y),married(Y,X).

grandson(X,Y):-male(X),parent(Y,Z),parent(Z,X).

granddaughter(X,Y):-female(X),parent(Y,Z),parent(Z,X).

daughter_in_law(X,Y):- female(X),married(Z,X),parent(Y,Z).

son_in_law(X,Y):-male(X),married(X,Z),parent(Y,Z).

maternal_aunt(X,Y):-
    female(X),female(Z),sister(X,Z),parent(Z,Y);
    female(X),married(Z,X),maternal_uncle(Z,Y).

paternal_aunt(X,Y):- 
    female(X),male(Z),sister(X,Z),parent(Z,Y);
    female(X),married(Z,X),paternal_uncle(Z,Y).

maternal_uncle(X,Y):-
    male(X),female(Z),brother(X,Z),parent(Z,Y);
    male(X),married(X,Z),maternal_aunt(Z,Y).

paternal_uncle(X,Y):-
    male(X),male(Z),brother(X,Z),parent(Z,Y);
    male(X),married(X,Z),paternal_aunt(Z,Y).

cousin(X,Y):- parent(A,X),parent(B,Y),sibling(A,B).

niece(X,Y):-female(X),parent(A,X),sibling(A,Y).
    
nephew(X,Y):-male(X),parent(A,X),sibling(A,Y).


/** <examples>
?- grandson(sumit,laxmi)
?- daughter_in_law(leena,janaklal)
?- granddaughter(sakshee,janaklal)
?- nephew(sumit,leena)
?- niece(sakshee,taruna)
?- sister(sakshee,palak)
?- maternal_grandmother(laxmi,sakshee)
?- maternal_grandmother(laxmi,sumit)
?- brother(sandeep,seema)
?- maternal_aunt(taruna,sakshee)
?- paternal_aunt(seema,sakshee)
?- son_in_law(omprakash,janaklal)
?- son_in_law(sandeep,suresh)
*/
