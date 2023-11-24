%facts
male(bhimarao).
male(shridhar).
male(sagar).
male(krishn).
male(suraj).
male(om).
male(malhar).
male(bramhadev).
male(sanket).
male(ganesh).
male(vaibhav).
male(bhavesh).
male(vicky).
male(swapnil).
male(sudhir).
male(sumit).
male(arnav).
male(madan).
male(shri).
male(pradip).

female(kamal).
female(vijayalaxmi).
female(vrushali).
female(sayali).
female(jui).
female(kiran).
female(sheela).
female(akshata).
female(sanchita).
female(pranali).
female(pranvi).
female(sandhya).
female(pallavi).
female(shraddha).
female(lata).
female(snehal).
female(shubhangi).
female(sanika).
female(samu).
female(laxmi).
female(prajakta).
female(shobha).
female(sukanya).
female(janvi).

couple(bhimarao,kamal).
couple(kamal,bhimarao).
couple(shridhar,vijayalaxmi).
couple(vijayalaxmi,shridhar).
couple(sagar,vrushali).
couple(vrushali,sagar).
couple(suraj,kiran).
couple(kiran,suraj).
couple(bramhadev,sheela).
couple(sheela,bramhadev).
couple(sanket, akshata).
couple(akshata, sanket).
couple(ganesh,pranali).
couple(pranali,ganesh).
couple(bhavesh,sandhya).
couple(sandhya,bhavesh).
couple(vicky,pallavi).
couple(pallavi,vicky).
couple(swapnil,shraddha).
couple(shraddha,swapnil).
couple(sudhir,lata).
couple(lata,sudhir).
couple(vaibhav,shubhangi).
couple(shubhangi,vaibhav).
couple(madan,laxmi).
couple(laxmi,madan).
couple(shri,prajakta).
couple(prajakta,shri).
couple(pradip,shobha).
couple(shobha,pradip).

parent(bhimarao,vijayalaxmi).
parent(bhimarao,sheela).
parent(bhimarao,sandhya ).
parent(bhimarao,sudhir).
parent(bhimarao,vaibhav).
parent(kamal,vijayalaxmi).
parent(kamal,sheela).
parent(kamal,sandhya ).
parent(kamal,sudhir).
parent(kamal,vaibhav).
parent(shridhar,sagar).
parent(shridhar,kiran).
parent(vijayalaxmi,sagar).
parent(vijayalaxmi,kiran).
parent(sagar,sayali).
parent(sagar,jui).
parent(sagar,krishn).
parent(vrushali,sayali).
parent(vrushali,jui).
parent(vrushali,krishn).
parent(suraj,om).
parent(suraj,malhar).
parent(kiran,om).
parent(kiran,malhar).
parent(bramhadev,sanket).
parent(bramhadev,ganesh).
parent(sheela,sanket).
parent(sheela,ganesh).
parent(sanket,sanchita).
parent(akshata,sanchita).
parent(ganesh,pranvi).
parent(pranali,pranvi).
parent(bhavesh,vicky).
parent(bhavesh,swapnil).
parent(sandhya,vicky).
parent(sandhya,swapnil).
parent(sudhir,sumit).
parent(sudhir,snehal).
parent(lata,sumit).
parent(lata,snehal).
parent(vaibhav,sanika).
parent(vaibhav,samu).
parent(vaibhav,arnav).
parent(shubhangi,sanika).
parent(shubhangi,samu).
parent(shubhangi,arnav).
parent(madan,shri).
parent(madan,shobha).
parent(madan,lata).
parent(laxmi,shri).
parent(laxmi,shobha).
parent(laxmi,lata).
parent(shri,janvi).
parent(prajakta,janvi).
parent(pradip,sukanya).
parent(shobha,sukanya).

mother(X,Y):- female(X),parent(X,Y).
father(X,Y):- male(X),parent(X,Y).
son(X,Y):- male(X),parent(Y,X).
daughter(X,Y):- female(X),parent(Y,X).
brother(X,Y):- X\=Y, male(X),parent(Z,X),parent(Z,Y).
sister(X,Y):- X\=Y, female(X),parent(Z,X),parent(Z,Y).
sibling(X,Y):- X\=Y, parent(Z,X),parent(Z,Y).
cusine(X,Y):- parent(Z,X), parent(W,Y), sibling(Z,W).
maternal_uncle(X,Y):-male(X),mother(Z,Y),sibling(Z,X).    % mama
maternal_uncle(X,Y):-male(X),mother(Z,Y),cusine(Z,X).    % mama
maternal_uncle_wife(X,Y):-female(X),couple(Z,X),maternal_uncle(Z,Y).   % mami
maternal_aunt(X,Y):-female(X),mother(Z,Y),sibling(Z,X).  % mavashi
maternal_aunt(X,Y):-female(X),mother(Z,Y),cusine(Z,X).  % mavashi
maternal_aunt_husbund(X,Y):-male(X),couple(Z,X),maternal_aunt(Z,Y). %kaka
paternal_uncle(X,Y):- male(X), father(Z,Y),sibling(X,Z). % kaka
paternal_uncle(X,Y):- male(X), father(Z,Y),cusine(X,Z). % kaka
paternal_uncle_wife(X,Y):-female(X), paternal_uncle(Z,Y), couple(Z,X).  % kaki
paternal_aunt(X,Y):- female(X), father(Z,Y), sibling(X,Z).  % atya
paternal_aunt(X,Y):- female(X), father(Z,Y), cusine(X,Z).  % atya
paternal_aunt_husbund(X,Y):- male(X), paternal_aunt(Z,Y), couple(X,Z).
grandmother(X,Y):- female(X),parent(Z,Y),parent(X,Z).
grandmother(X,Y):- female(X),parent(Z,Y),maternal_aunt(X,Z).
grandmother(X,Y):- female(X),parent(Z,Y),paternal_aunt(X,Z).
grandfather(X,Y):- male(X),parent(Z,Y),parent(X,Z).
grandfather(X,Y):- male(X),parent(Z,Y),maternal_aunt_husbund(X,Z).
grandfather(X,Y):- male(X),parent(Z,Y),paternal_aunt_husbund(X,Z).
grandson(X,Y):-male(X),parent(Z,X),parent(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),maternal_aunt(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),maternal_aunt_husbund(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),maternal_uncle(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),maternal_uncle_wife(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),paternal_uncle(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),paternal_uncle_wife(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),paternal_aunt(Y,Z).
grandson(X,Y):-male(X),parent(Z,X),paternal_aunt_husbund(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),parent(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),maternal_aunt(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),maternal_aunt_husbund(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),maternal_uncle(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),maternal_uncle_wife(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),paternal_uncle(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),paternal_uncle_wife(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),paternal_aunt(Y,Z).
granddaughter(X,Y):-female(X),parent(Z,X),paternal_aunt_husbund(Y,Z).
son_in_low(X,Y):- male(X), couple(X,Z), daughter(Z,Y).
daughter_in_low(X,Y):- female(X), couple(Z,X), son(Z,Y).
daughter_in_low_second(X,Y):- female(X),male(Y), couple(Z,X), grandfather(Y,Z).
brother_of_husband(X,Y):- male(X),female(Y),couple(Z,Y), sibling(Z,X).  %dir
brother_of_husband(X,Y):- male(X),female(Y),couple(Z,Y), cusine(Z,X).  %dir
wife_of_brother_of_husband(X,Y):- female(X), couple(Z,X),brother_of_husband(Z,Y). % jau
sister_of_your_husband(X,Y):-female(X),female(Y),couple(Z,Y),sibling(Z,X). %nanand
sister_of_your_husband(X,Y):-female(X),female(Y),couple(Z,Y),cusine(Z,X). %nanand
husbund_of_sister_of_your_husband(X,Y):-male(X),couple(Z,X),sister_of_your_husband(Z,Y).
brother_of_your_wife(X,Y):-male(X),male(Y),couple(Z,Y),sibling(X,Z). %mevhana
brother_of_your_wife(X,Y):-male(X),male(Y),couple(Z,Y),cusine(X,Z). %mevhana
sister_of_your_wife(X,Y):-female(X),male(Y),couple(Z,Y),sibling(X,Z).%mevhani
sister_of_your_wife(X,Y):-female(X),male(Y),couple(Z,Y),cusine(X,Z).%mevhani
wife(X,Y):- female(X), couple(Y,X).
husbund(X,Y):- male(X), couple(X,Y).
father_in_low(X,Y):- male(X),couple(Z,Y),father(X,Z).
mother_in_low(X,Y):- female(X), couple(Z,Y), mother(X,Z).
great_grandfather(X,Y):- male(X),parent(Z,Y), grandfather(X,Z).
great_grandmother(X,Y):- female(X),parent(Z,Y), grandmother(X,Z).
wife_of_your_brother(X,Y):- female(X),couple(Z,X),sibling(Z,Y).
wife_of_your_brother(X,Y):- female(X),couple(Z,X),cusine(Z,Y).
son_of_brother(X,Y):-male(X),male(Y),father(Z,X),brother(Z,Y). %putanya
son_of_brother(X,Y):-male(X),male(Y),father(Z,X),cusine(Z,Y). %putanya
daughter_of_brother(X,Y):-female(X),father(Z,X),brother(Z,Y).%putani
daughter_of_brother(X,Y):-female(X),male(Y),father(Z,X),cusine(Z,Y).%putani
son_of_sister(X,Y):-male(X),mother(Z,X),sister(Z,Y). %bhacha
son_of_sister(X,Y):-male(X),female(Y),mother(Z,X),cusine(Z,Y). %bhacha
daughter_of_sister(X,Y):-female(X),female(Y),mother(Z,X),sister(Z,Y).%bhachi
daughter_of_sister(X,Y):-female(X),female(Y),mother(Z,X),cusine(Z,Y).%bhachi
greatgrandson(X,Y):- male(X),female(Y),parent(Z,X),grandmother(Y,Z).


relation(X,Y):-mother(X,Y),write(X),write(' is mother of '),write(Y).
relation(X,Y):-father(X,Y),write(X),write(' is father of '),write(Y).
relation(X,Y):-son(X,Y),write(X),write(' is son of '),write(Y).
relation(X,Y):-daughter(X,Y),write(X),write(' is daughter of '),write(Y).
relation(X,Y):-brother(X,Y),write(X),write(' is brother of '),write(Y).
relation(X,Y):-sister(X,Y),write(X),write(' is sister of '),write(Y).
relation(X,Y):-sibling(X,Y),write(X),write(' and '),write(Y),write(' sibling ').
relation(X,Y):-grandmother(X,Y),write(X),write(' is grandmother of '),write(Y).
relation(X,Y):-grandfather(X,Y),write(X),write(' is grandfather of '),write(Y).
relation(X,Y):-paternal_uncle(X,Y),write(X),write(' is paternal uncle of '),write(Y).
relation(X,Y):-paternal_uncle_wife(X,Y),write(X),write('is wife of paternal uncle of'),write(Y).

relation(X,Y):-paternal_aunt(X,Y),write(X),write(' is paternal aunt of '),write(Y).
relation(X,Y):-paternal_aunt_husbund(X,Y),write(X),write(' is husbund of paternal aunt of '),write(Y).
relation(X,Y):-cusine(X,Y),write(X),write(' is cusine of '),write(Y).
relation(X,Y):-son_in_low(X,Y),write(X),write(' is son-in-low of '),write(Y).
relation(X,Y):-daughter_in_low(X,Y),write(X),write(' is daughter_in_low of '),write(Y).
relation(X,Y):-brother_of_husband(X,Y),write(X),write(' is brother-in-low of '),write(Y).
relation(X,Y):-wife_of_brother_of_husband(X,Y),write(X),write(' is wife of '),write(Y),write(' brother-in-low').
relation(X,Y):-sister_of_your_husband(X,Y),write(X),write(' is sister-in-low of '),write(Y).
relation(X,Y):-husbund_of_sister_of_your_husband(X,Y),write(X),write(' is husbund of '),write(Y), write(' sister-in-low').
relation(X,Y):-brother_of_your_wife(X,Y),write(X),write(' is brother-in-low of '),write(Y).
relation(X,Y):-sister_of_your_wife(X,Y),write(X),write(' is sister-in-low of '),write(Y).
relation(X,Y):-wife(X,Y),write(X),write( 'is wife of '),write(Y).
relation(X,Y):-husbund(X,Y),write(X),write(' is husbund of '),write(Y).
relation(X,Y):-father_in_low(X,Y),write(X),write(' is father_in_low of '),write(Y).

relation(X,Y):-mother_in_low(X,Y),write(X),write(' is mother_in_low of '),write(Y).
relation(X,Y):-great_grandfather(X,Y),write(X),write('  is great_grandfather of '),write(Y).
relation(X,Y):-great_grandmother(X,Y),write(X),write(' is great_grandmother of '),write(Y).
relation(X,Y):-maternal_uncle(X,Y),write(X),write(' is maternal uncle of '),write(Y).
relation(X,Y):-maternal_uncle_wife(X,Y),write(X),write(' is wife of maternal uncle of '),write('Y').
relation(X,Y):-maternal_aunt(X,Y),write('X'),write(' is maternal aunt of '),write(Y).
relation(X,Y):-maternal_aunt_husbund(X,Y),write(X),write(' is husbund of maternal aunt of '),write(Y).
relation(X,Y):-wife_of_your_brother(X,Y),write(X),write(' is sister_in_low of '),write(Y).
relation(X,Y):-son_of_brother(X,Y),write(X),write(' is nephew of '),write(Y).
relation(X,Y):-daughter_of_brother(X,Y),write(X),write(' is neice of '),write(Y).
relation(X,Y):-son_of_sister(X,Y),write(X),write(' is nephew of '),write(Y).
relation(X,Y):-daughter_of_sister(X,Y),write(X),write(' is neice of '),write(Y).
relation(X,Y):-grandson(X,Y), write(X),write(' is grandson of '), write(Y).
relation(X,Y):-granddaughter(X,Y), write(X),write(' is granddaughter of '), write(Y).
relation(X,Y):-greatgrandson(X,Y), write(X),write(' is greatgrandson of '), write(Y).
relation(X,Y):-daughter_in_low_second(X,Y), write(X),write(' is daughter in law of '), write(Y).



