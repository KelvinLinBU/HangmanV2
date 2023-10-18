# HangmanV2
Hangman Game CS501
Target both a Portrait and Landscape views as shown
below. This is a design challenge as well, so please make design choices on your own,
(eg.,- how to render the hangman stick figure, how to tell the user they won or lost, etc.)
Your game should be able to run at least one complete game and handle both winning
and losing, no scoring is necessary. Include a "New Game" Button which will reset the
current game and start a new and different game when clicked.
a. Your game must remember state when rotating!
b. Hard code the words for the game, but randomly present different words when
run. Ensure the maximum length of any word is 6 characters. This will simplify
rendering the word on the screen.
c. You must implement for both a phone and a table – your choice of models.
Panel 1: Contains a "Choose the le[er" set of bu[ons. Provide a menu of le[ers, just
use buttons. Be sure to disable the button afer it's been selected.
Panel 2: Contains a Hint Button.
a. Clicking the Hint Button can do two things.
i. The first time it is clicked it displays a hint message.
ii. The second time it is clicked it disables half of the remaining le[ers (that
are not part of the word) BUT it costs the user a turn.
iii. The third time it is clicked, it shows all the vowels, BUT it costs the user a
turn. Be sure to disable all of the vowel bu[ons so they user doesn't click
them again.
iv. If clicking the hint button would cause the user to be completely hung, ie,
lose the game, then show a toast, "Hint not available".
General Game Play:
c. Afer choosing a letter, the user will be notified whether the letter was correct or
not. If correct the letter will be displayed in the proper area, if incorrect, another
body part will hang. The game ends when the user successfully iden6fies the
word or is completely hung. 
d. You will need to test in both a phone and tablet. You may use the emulator, but
you must identify which model of phone and tablet you used.
