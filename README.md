# daniel-chess - JAVA
jdk14
A game of chess implemented in java as an extracurricular project.
I accept and welcome any advice/criticism you have for me regarding this project.

While this project is incomplete, it does run.
I made this to showcase some OOP principles and notions I have a solid grasp of. 

I need to:
- improve input taking by standardising input to one notation system (some can be found here: https://en.wikipedia.org/wiki/Chess_notation)
- outputting board in ASCII at object creation and after each turn, for the players to see and calculate moves easier.
- implement getLegalDestinationSquares() method for check checking
- define CHECKMATE AND STALEMATE conditions in code
- write tests to catch any undesired behaviours. I suspect there are a few slips in Game -> verifyMove. Pieces might be able to jump over an opponent's piece. It might be that Game -> isInCheck() checks for check on both kings, rather than just the one of the given player.
