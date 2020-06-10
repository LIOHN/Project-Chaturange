/**
* (Super) Class Piece defines the basic blueprint for a chess piece.
* Pieces can only be of two colours, as the game can only be played 
* between 2 players. Different pieces have different,  behaviours so 
* implementing an abstract class is the choice. Pieces, if within
* range, can move to empty spaces, or to a spot where there is an
* opponent's piece to capture it. (with the exception of the king
* can't capture the king, you can only place it under attack.) If
* a piece is captured it must be removed from play. Pieces can't jump
* over other pieces, unless it's the Knight. These nuances are
* implemented in the unique classes.
* The unique classes constructors all call super(white) to call 
* constructor in this class, in order to assign a colour to the piece.
*
* Because there are only two possible colours in chess, it suffices to
* use a boolean operator for the two colours. In this implementation 
* of the game of chess, I use black and white as the two colours.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public abstract class Piece {
	private boolean captured = false;
	private boolean white = false;
	
	/**
	* When a piece object is created, the first thing we need to know 
	* the colour of it is. A setter method assigns the colour of the 
	* piece as true = white and false = black.
	*
	* @param boolean white, determining whether it is white or black
	*/
	public Piece(boolean white) {
		this.setWhite(white);
	}
	
	/**
	* Method "isWhite" checks whether the piece is white
	* 
	* @return boolean telling us whether the piece is white or black
	*/
	public boolean isWhite() {
		return this.white == true;
	}
	
	public void setWhite(boolean white) {
		this.white = white;
	}
	
	/**
	* Method "isCaptured" checks whether the piece in question has been 
	* captured (true = yes)
	*  
	* @return boolean whether piece in question has been captured
	*/
	public boolean isCaptured() {
		return this.captured == true;
	}
	
	/**
	* @param boolean captured
	*/
	public void setCaptured(boolean captured) {
		this.captured = captured;
	}
	
	/**
	* This method should iterate through possible moves of a 
	* piece on a given square and return the pieces that it has 
	* under attack/ can capture in one move.
	* To be used in the check for check method
	* 
	* @return Piece reachable by piece on a given Square square
	* @param Square square
	*/
	public Piece getLegalDestinationSquares(Square square) {
	/*
	* TO BE IMPLEMENTED
	*
	*/
		return null;
	}
	
	/**
	* Abstract method "isAllowedMove" to be overridden in each unique chess piece 
	* class so that allowable behavior can be coded for each unique piece.
	* Method should return true if move is possible, valid, and allowed.
 	*
	* @param Board: the board on which the game exists
	* @param Square start: the starting position of the piece
	* @param Square end: the final position of the piece
	* @return a boolean telling the player whether a move is valid
	*/
	public abstract boolean isAllowedMove(Board board, Square start, Square end);
}

