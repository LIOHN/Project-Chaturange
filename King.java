/**
* The King is also a special piece on the chess board. It is involved in determining 
* who wins. While it can only move one spot in any direction, it is arguably the most 
* important piece on the board, and needs defending as a checkmate on it ends the game.
* The King can also move in an unusual way, by castling, a move which changes the rook's
* and the king's positions simultaneously. The conditions for that are: if castling, it
* must be each piece's first move; A check on the king dissallows the player on the 
* receiving end from castling for the rest of the game; There must be no pieces in the 
* Squares where the castling ends. A player can only castle once in a game. There are
* two ways of castling
* A visual example of a castle move:
* start: R & & K & & & R
* end :  & K R & & & & R or
*        R & & & R K & &
* where the ampersand symbol signifies an empty (null) Square.
* The rook must be moved at the same time as the king for a castle move to be valid
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class King extends Piece {
	private boolean castlingDone = false;
	
	/**
	* When a piece object is created, the first thing we need to know 
	* the colour of it is. A setter method assigns the colour of the 
	* piece as true = white and false = black.
	*
	* @param boolean white, determining whether it is white or black
	*/
	public King(boolean white) {
		super(white);
	}
	
	/**
	* Method "isCastlingDone" checks variable "castlingDone", i.e. 
	* whether the player has done a castling move already 
	* 
	* @return boolean telling us whether a castle move has been done
	*/
	public boolean isCastlingDone() {
		return this.castlingDone == true;
	}
	
	/**
	* @param boolean castlingDone
	*/
	public void setCastlingDone(boolean castlingDone) {
		this.castlingDone = castlingDone;
	}
	
	/**
	* {@inheritDoc}
	*/	
	@Override
	public boolean isAllowedMove(Board board, Square start, Square end) {
		// if the target spot contains a piece of the same colour, it's an invalid move
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		
		int x = Math.abs(start.getX() - end.getX());
		int y = Math.abs(start.getY() - end.getY());
		if (x + y == 1) {
			return true;
		}
		
		return this.isValidCastling(board, start, end);
	}
	
	/**
	* This method checks if a castling move is valid, as shown in the representation
	* at the top of this class.
	*
	* TO CONSIDER: merge with method isAllowedMove 
	*
	* @param Board board
	* @param Square start: the starting position of the piece
	* @param Square end: the final position in the move	 
	*/
	private boolean isValidCastling(Board board, Square start, Square end) {
		//if a castle has already occured, another castle move cannot take place
		if (this.isCastlingDone()) {
			return false;
		}
		
		/*
		TO BE ADDED: Functionality to check if a castle move is correct
		*/
		return true;
	}
	
	/*
	public boolean isCastlingMove(Square start, Square end) {
		/*
		TO BE ADDED: Functionality to check if a move is a castle
		A check that can be used to link to the rook so the rook 
		can do its part in the castle (i.e. move as shown at top)
		***
	}
	*/
}