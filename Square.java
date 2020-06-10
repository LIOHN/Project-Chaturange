/**
* Class Square is concerned with the physical locations the pieces can 
* be placed on, if there's any. Seen mainly in class Board
*
*
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
public class Square {
	private Piece piece;
	private int x;
	private int y;
	
	/**
	* When a new Square object is made, this constructor gets called and 
	* the piece and the coordinates of it are set safely with setter methods
	*/
	public Square(int x, int y, Piece piece) { 
		this.setPiece(piece);
		this.setX(x);
		this.setY(y);
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	* @param Piece p that resides on this square
	*/
	public void setPiece(Piece p) {
		this.piece = p;
	}
	
	public int getX() {
		return this.x;
	}
	
	/**
	* @param int x coord
	*/
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	/**
	* @param int y coord
	*/
	public void setY(int y) {
		this.y = y;
	}
}
