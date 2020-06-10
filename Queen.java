/**
* The Queen class extends (chess) Piece to define allowable movement
* by the Queen. This chess piece can move in any direction (diagonal,
* straight) as long as there is no piece in its way. This makes the
* Queen the strongest piece on the board, therefore, it has the highest
* value.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Queen extends Piece {
	public Queen(boolean white) {
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
		//XOR cases, allowing moves only where x=y (diagonal movement)
		// or x or y equaling 0 (movement in one direction.
		return x == y ^ x == 0 ^ y == 0;
	}
}
