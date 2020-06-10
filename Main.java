/**
* Class main serves as an entry point into the program. 
* First a new game object is made between two players and 
* the board is fed to game's attribute play (i.e. start game)
*
* While the project is incomplete, it runs, and is good 
* enough for prospective employers to see.
*
* @author  Daniel Ene
* @version 1.0	
* @since   01-06-2020
*/

public class Main {
	public static void main(String args[]) {
		Player p1 = new HumanPlayer(true);
		Player p2 = new HumanPlayer(false);
		Game game = new Game(p1, p2);
		Board board = new Board();
		game.play(board);
	}
}