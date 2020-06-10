/**
* Class Move defines private variables pertaining to move parameters,
* i.e. Player that made the move, the spot from and to which a piece 
* had moved,the piece moved, the piece it captures (if any) 
* In the Game class, every player move creates a Move object that 
* contains these parameters for logging and informative purposes.
* 
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Move {
	private Player player;
	private Square start;
	private Square end;
	private Piece pieceMoved;
	private Piece pieceCaptured;
	private boolean castlingMove = false;
	
	/**
	* For a new move object these are the parameters that are
	* assigned * when this constructor gets called. On top of 
	* the args the piece moved is recorded by default through 
	* start dot getPiece()
	* 
	* @param player instance of Player
	* @param Square start: the starting position of the piece
	* @param Square end: the final position in the move
	*/
	public Move(Player player, Square start, Square end) {
		this.player = player;
		this.start = start;
		this.end = end;
		this.pieceMoved = start.getPiece();
	}
	
	/**
	* DO I NEED THIS?
	*
	* Method isCastlingMove is a way of checking whether current
	* involves a castle between the king and the rook. Once a castle
	* occurs on one side it can't happen again.
	*
	* @return boolean whether castlingMove for this move is true
	*/
	public boolean isCastlingMove() {
		return this.castlingMove == true;
	}
	
	/**
	 * @param boolean that determines whether this move is a castle
	 */
	public void setCastlingMove(boolean castlingMove) { 
		this.castlingMove = castlingMove;
	}
	
	/**
	 * @param boolean that determines whether this pawn has been captured
	 */
	public void setPieceCaptured(Piece piece) {
		this.pieceCaptured = piece;
	}
	
	/**
	 * @return Square that tells us the starting position in the move
	 */
	public Square getStart() {
		return this.start;
	}
	
	/**
	 * @return Square that tells us the end position in the move
	 */
	public Square getEnd() {
		return this.end;
	}
}
