/**
* The Board class contains the definition of the board on which the game
* runs. The board is 8 by 8 and it houses 16 pawns, 4 of each: bishops,
* rooks and knights and 2 of each: queens and kings. Each piece has a set
* starting position for the standard game of chess. These are shown below.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Board {
	private Square[][] board;
	
	/**
	* A new Board object is created, the board gets set automatically, with
	* parameters below. (Calls setBoard)
	*/
	public Board() {
		this.setBoard();
	}
	
	
	public Square[][] getBoardArray() {
		return this.board;
	}
	
	/**
	* getter for the item in board[x][y]
	* TO ADD, throw outofbounds error when x and y are not between 0 and 7
	*
	* @param int x: x coordinate of desired location
	* @param int y: y coordinate of desired location
	* @return Square at coordinates given
	*/
	public Square getSquare(int x, int y) {
		return board[x][y];
	}
	
	/**
	* Method setBoard fills the 2D array "board" with Square objects, that
	* in turn contain individual piece objects and their respective coordinates. 
	* The 2D array "board" also helps with the initialisation of empty Squares,
	*/
	public void setBoard() {
		// initialise white pieces (individual piece arguments are true)
		board[0][0] = new Square(0, 0, new Rook(true));
		board[0][1] = new Square(0, 1, new Knight(true));
		board[0][2] = new Square(0, 2, new Bishop(true));
		board[0][3] = new Square(0, 3, new Queen(true));
		board[0][4] = new Square(0, 4, new King(true));
		board[0][5] = new Square(0, 5, new Bishop(true));
		board[0][6] = new Square(0, 6, new Knight(true));
		board[0][7] = new Square(0, 7, new Rook(true));
		board[1][0] = new Square(1, 0, new Pawn(true));
		board[1][1] = new Square(1, 1, new Pawn(true));
		board[1][2] = new Square(1, 2, new Pawn(true));
		board[1][3] = new Square(1, 3, new Pawn(true));
		board[1][4] = new Square(1, 4, new Pawn(true));
		board[1][5] = new Square(1, 5, new Pawn(true));
		board[1][6] = new Square(1, 6, new Pawn(true));
		board[1][7] = new Square(1, 7, new Pawn(true));
		
		// initialise black pieces (individual piece arguments are false)
		board[6][0] = new Square(6, 0, new Pawn(false));
		board[6][1] = new Square(6, 1, new Pawn(false));
		board[6][2] = new Square(6, 2, new Pawn(false));
		board[6][3] = new Square(6, 3, new Pawn(false));
		board[6][4] = new Square(6, 4, new Pawn(false));
		board[6][5] = new Square(6, 5, new Pawn(false));
		board[6][6] = new Square(6, 6, new Pawn(false));
		board[6][7] = new Square(6, 7, new Pawn(false));
		board[7][0] = new Square(7, 0, new Rook(false));
		board[7][1] = new Square(7, 1, new Knight(false));
		board[7][2] = new Square(7, 2, new Bishop(false));
		board[7][3] = new Square(7, 2, new Queen(false));
		board[7][4] = new Square(7, 2, new King(false));
		board[7][5] = new Square(7, 2, new Bishop(false));
		board[7][6] = new Square(7, 2, new Knight(false));
		board[7][7] = new Square(7, 2, new Rook(false));
		
		// initialise remaining board as empty
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Square(i, j, null);
			}
		}
	}
}
