/**
* Can define as the computer player as a minimax or RL
* to determine a suitable next move. More complex solutions 
* require a bigger lookahead. Or, very simply, the computer
* player can start out picking moves randomly.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class ComputerPlayer extends Player {
	public ComputerPlayer(boolean whiteSide) {
		this.whiteSide = whiteSide;
		this.humanPlayer = false;
	}
}