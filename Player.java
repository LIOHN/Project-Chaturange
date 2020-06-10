/**
* In we need to know about a player in a chess game is what 
* he/she's on. An abstract class for Player is used as the 
* game can be played by a human player or by a computer (AI)
* player. 
* Both classes that inherit player call constructor and tell 
* us what colour they are, and whether they're a human player 
* or not
* 
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public abstract class Player {
	public boolean whiteSide;
	public boolean humanPlayer;
	
	public boolean isWhiteSide() {
		return this.whiteSide == true;
	}
	
	public boolean isHumanPlayer() {
		return this.humanPlayer == true;
	}
}


