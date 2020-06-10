/**
* The Pawn class extends (chess) Piece to define allowable movement
* by the Pawn. A pawn can only move in one direction, i.e. forward.
* It can move only if there is no obstacle in front of it, and 
* it can move two spots forward if it hasn't move yet.
* Unlike other pieces, pawns can capture an opponent pieces in a 
* different manner to others. A pawn can move one spot diagonally 
* away, but only if there is an opponent piece there. That is called
* en passant.
* If a pawn reaches the other end of the board, it is promoted to a 
* piece of the player's choice.
* It is important to note that the pieces are initialised on the very
* left and the very right of the board, rather than top/bottom, meaning
* pawn movement occurs in the x axis.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Pawn extends Piece {
	private boolean hasMoved = false;

	/**
	* The constructor Pawn that gets called at object creation (e.g. 
	* in class Board), given the colour of the piece, refers to the 
	* parent class constructor to set the colour of the piece.
	*
	* @param boolean white, determining whether it is white or black
	*/
	public Pawn(boolean white) {
		super(white);
	}
	
	/**
	 * @return the boolean that determines whether this pawn has moved
	 */
	public boolean getHasMoved() {
		return this.hasMoved;
	}
	
	/**
	 * @param boolean that determines whether this pawn has moved
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	/**
	 * {@inheritDoc}
	 * For the pawn, the only allowed moves are (returns true, for) defined below, in order:
	 *  Diagonally one away, for a capture iff there is an opponent's piece there
	 *  forward one if there is nothing in its way
	 *  forward two if there is nothing in its way and the piece hasn't moved yet
	 * with start/end.getX/Y as ways of counting spaces moved.
	 * Other invalid moves include trying to place
	 *
	 * @param Board: the board on which the game exists
	 * @param Square start: the starting position of the piece
	 * @param Square end: the final position in the move
	 * @return a boolean telling the player whether a move is valid
	 */
	@Override
	public boolean isAllowedMove(Board board, Square start, Square end) {
		// if the target spot contains a piece of the same colour, it's an invalid move
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		
		/*
		As the pawn is a special case, we need to know whether x is negative or note
		i.e. whether the move is valid or not.
		*/
		int x = start.getX() - end.getX();
		int y = Math.abs(start.getY() - end.getY());
		// The allowed capture move.
		if (end.getPiece().isWhite() != this.isWhite() && x == 1 &&  y == 1) {
			return true;
		} else if (y == 0) {
			//pawn can move forward one or two iff it hasnt moved before.
			if (x == 1 && end.getPiece() == null) {
				return true;
			}
			
			if (x == 2 && !hasMoved && end.getPiece() == null) {
				return true;
			}
		}
		return false;
	}
}
