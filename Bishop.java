/**
* The Bishop class extends (chess) Piece to define allowable movement
* by the Bishop. This chess piece can only move diagonally as long 
* as there is no piece in its way. This makes the Bishop the third
* most valuable piece on the board, tied with the knight.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Bishop extends Piece {
	public Bishop(boolean white) {
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
		//on a plane, diagonal movement occurs when the abs values for x and y are equal 
		return x == y;
	}
}
