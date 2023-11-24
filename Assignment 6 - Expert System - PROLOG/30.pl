temple(meenakshi_temple, south, tamil_nadu, madurai, dravidian,april,yes).
temple(tirupati_temple, south, andhra_pradesh, tirupati, dravidian,september,no).
temple(virupaksha_temple, south, karnataka, vijayanagara, dravidian,march,yes).
temple(mahakaleshwar_temple, middle, madhya_pradesh, ujjain, chalukya,october,no).
temple(sangameshwar_temple, west, maharashtra, pune, chalukya,march,yes).
temple(alandi_temple, west, maharashtra, pune, peshwa,june,yes).
temple(kashi_vishwanath, north, uttar_pradesh, varanasi, nagara,april,no).
temple(jagannath_temple, east, odisha, puri, kalinga,june,no).
temple(badrinath_temple, north, uttarakhand, badrinath, nagara,june,yes).
temple(mahabodhi_temple, west, bihar, bodh_gaya, gupta,march,yes).
temple(sun_temple, east, odisha, konark, kalinga,december,yes).
temple(ganpati_pude_temple, west, maharashtra, konkan, maratha,october,no).
temple(shirdi_sai_baba_temple, west, maharashtra, shirdi, maratha,july,no).
temple(pandharpur_temple, west, maharashtra, pandharpur, maratha,june,yes).
temple(gajanan_maharaj_temple, west, maharashtra, shegaon, maratha,july,no).
temple(kedarnath_shiva_temple, north, uttarakhand, kedarnath, nagara,june,yes).
temple(dwarikadhish_temple, west, gujarat, dwarka, nagara,august,no).

identify_temple(Direction, State, City, Architecture,Month,River, Temple1) :-
    temple(Temple1, Direction, State, City, Architecture,Month,River),
    write('Based on your description, the temple may be the '), write(Temple1), nl.

identify_temple(_, _, _, _, _,_,_) :-
    write('No temple identified based on your given information'), nl.

start :-
    write('Welcome to the Indian Temple Identifier!'), nl,
    write('Please provide the following information:'), nl,
    write('Direction (e.g., north, south, east, west): '), read(Direction), nl,
    write('State: '), read(State), nl,
    write('City: '), read(City), nl,
    write('Architecture (e.g., dravidian, chalukya, nagara, kalinga, gupta, maratha  ): '), read(Architecture), nl,
    write('Which is the most important month for that temple : '),read(Month),nl,
    write('Is the temple at bank of a river : '),read(River),nl,
    identify_temple(Direction, State, City, Architecture,Month,River, Temple1).
