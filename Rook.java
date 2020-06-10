/**
* The Rook class extends (chess) Piece to define allowable movement
* by the Rook. This chess piece can only move in a straight line as long 
* as there is no piece in its way. This makes the Rook the second 
* strongest piece on the board.
* TO BE ADDED: Move Rook if castling move 
*
* @author  Daniel Ene
* @version 1.0	
* @since   01-06-2020
*/
public class Rook extends Piece {
	public Rook(boolean white) {
		super(white);
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
		//XOR case, if either vector is zero, it means movement only occurs on one plane
		return x == 0 ^ y == 0;
	}
}
