/**
* The Knight class extends (chess) Piece to define allowable movement
* by the Knight.  It moves to a square that is two squares away 
* horizontally and one square vertically, or two squares vertically 
* and one square horizontally. The complete move therefore looks like 
* the letter "L". Unlike other pieces, the Knight can jump over other pieces.
* The limited range constrasted with the versatility this piece provides
* makes the Knight's value the third highest comparable with that of the 
* Bishop.
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Knight extends Piece {
	public Knight(boolean white) {
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
		//as the knight can only move 2 in one direction and one in the other, the 
		//following equation suffices.
		return x * y == 2;
	}
 }
