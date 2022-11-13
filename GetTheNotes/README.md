## Chord Search 

-- It lists out the root chords(C,D,E etc) and the child(Cmaj, Cmin, C7 etc) within it(which is static data currently).
when clicked on individual chord/childChord, getDetails end point is triggered to get the details of searched chord,
out of which we display chordNames and tones on the UI.

## Architecture
MVVM

## UI Components

* Root Chords displayed in a horizontally way
* Onclick of rootchords childchords will be displayed accordingly
* When user click on child chord, details of that chord will be displayed below as chordname and tones

## Dev testing

* Tested application on below devices

- Nexus 5 - API level 30
- One Plus 6T - API level 30

## Futuristic additions

* Currently static data is used to display tne roots chords and child chords but we can make use of exisitng Notes & Keys.

