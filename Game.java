/**
* Chess is a two-player strategy board game played on a board with 64 squares 
* arranged in an 8×8 grid.
* Class game contains the main game logic. In it one can find the game loop,
* turntaking, input taking, translation of input into parameters for a move,
* checking a move and update the board accordingly. 
* 
* @author  Daniel Ene
* @version 1.0
* @since   01-06-2020
*/
import java.util.List;
import java.util.Scanner;

public class Game {
	private Board board;
	private Player[] players;
	private Player playerMoving;
	private List<Move> movesPlayed;
	private GameStatus status = GameStatus.ACTIVE;
	
	//An enum containing possible stages of a game seems like the right 
	//way of controlling a game loop.
	public enum GameStatus {
		ACTIVE, 
		BLACK_WIN, 
		WHITE_WIN, 
		FORFEIT, 
		STALEMATE, 
		RESIGNATION;
	}

	//these values are used by getInput(); and get overwritten every move
	Scanner in = new Scanner(System.in);
	private int startX;
	private int endX;
	private int startY;
	private int endY;
	private String inputMove;

	/*
	* Constructor does setup when a game object is created.
	* Adds players to players array, initiaises turntaking and clears
	* arraylist movesPlayed
	*
	* @param Player p1
	* @param Player p2
	*/
	public Game(Player p1, Player p2) {
		players[0] = p1;
		players[1] = p2;
		
		if (p1.isWhiteSide()) {
			this.playerMoving = p1;
		} else {
			this.playerMoving = p2;
		}
		
		movesPlayed.clear();	
	}
	
	/**
	* A game object has an attribute play which takes a board as an 
	* argument. This contains the game loop. There are several checks  
	* that change GameStatus.status if game status changes, and when 
	* that happens, the while loop breaks. In the loop, input is 
	* taken and a move is made according to the parameters given.
	* Once that happens, update turntaking.
	*
	* TO BE ADDED: Checks for checkmate, stalemate, before 
	*
	* @param Board board, the board on which the game plays
	*/
	public void play(Board board) {
		while (getStatus() == GameStatus.ACTIVE) {
			
			System.out.println("Enter your move, in the format: piece, starting x, starting y, end x, end y - no breaks");
			getInput();
			
			makeMove(this.playerMoving, startX, startY, endX, endY);
			
			//Output log (moved piece () to spot () and captured piece ())
			//Output board in ASCII form like above
			
			if (getPlayerMoving() == players[0]) {
				setPlayerMoving(players[1]);
			} else {
				setPlayerMoving(players[0]);
			}
		}
		
		System.out.println(getStatus());  	
	}
	
	/**
	* Method getInput is the user's way of interacting with the game.
	* It is found in the play method.
	* At the moment, the user has to input a string containing the 
	* the initial of the piece and the coordinates of the starting 
	* and end position. The string gets split and the parameters get
	* fed to the makeMove method.
	* 
	* TO BE IMPROVED: Standardise chess move notation to a known standard 
	* e.g. Algebraic: "d3 Bb4+" where + symbolises a check, and d3 being 
	* the initial Square in the move. Ask for input in that format and 
	* write code to translate that move into game logic.
	*/
	private void getInput() {
		inputMove = in.nextLine();
		/*
		if (inputMove == "resign") {
			newGame.setStatus(RESIGNATION);
		} else if (inputMove == "status") {
			print getStatus
		} else if (inputMove = "moves") {
			print movesPlayed
		}
		*/
		startX = Integer.parseInt(String.valueOf(inputMove.charAt(1)));
		endX = Integer.parseInt(String.valueOf(inputMove.charAt(2))); 
		startY = Integer.parseInt(String.valueOf(inputMove.charAt(3)));
		endY = Integer.parseInt(String.valueOf(inputMove.charAt(4))); 
	}
	
	/**
	* @return Player playermoving
	*/
	public Player getPlayerMoving() {
		return this.playerMoving;
	}	

	/**
	* @param Player player
	*/
	public void setPlayerMoving(Player player) {
		this.playerMoving = player;
	}
	
	/**
	* @return boolean whether game status is no longer active and the game has ended
	*/
	public boolean isEnd() {
		return this.getStatus() != GameStatus.ACTIVE; 
	}
	
	/**
	* @return GameStatus status
	*/
	public GameStatus getStatus() {
		return this.status;
	}

	/**
	* @parram GameStatus status
	*/
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	
	/**
	* @return Board board
	*/
	public Board getBoard() {
		return this.board;
	}
	
	/**
	* Method makeMove finds the squares from the coordinates given by user input
	* and creates a new move object. Before the move is finalised, it needs to be
	* checked by verifyMove. If that succeeds, the end piece becomes the starting 
	* piece and the starting piece becomes null. Add the move to the arraylist.
	*
	// in input loop if makemove is false ask for anther one
	// bc if it's true it does what needs to be done here.
	* @param Player player
	* @param int startX
	* @param int startY
	* @param int endX
	* @param int endY
	*/
	public void makeMove(Player player, int startX, int startY, int endX, int endY) {
		try {
			Square startSquare = board.getSquare(startX, startY);
			Square endSquare = board.getSquare(startY, endY);
			Move move = new Move(player, startSquare, endSquare);
			if (this.verifyMove(move, player)) {
				// move piece from the start box to end box, and add move to array of moves
				move.getEnd().setPiece(move.getStart().getPiece());
				move.getStart().setPiece(null);
				movesPlayed.add(move);			
			} else {
				System.out.println("couldn't make a move, your king might be in check or your input is invalid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Method verify move takes a desired move and runs a number of checks on it
	* The check fails if: 
	* -one tries to move a piece that doesnt exist,
	* -one tries to move if it isn't your turn,
	* -one tries to move a piece that isn't yours
	* -one tries to move a piece in a way that isn't allowed
	* -ones king is in check.
	*
	* @param Move move
	* @param Player player
	*/
	public boolean verifyMove(Move move, Player player) {
		Square sourceSquare = move.getStart();
		Square endSquare = move.getEnd();
		Piece sourcePiece = sourceSquare.getPiece();
		Piece destPiece = endSquare.getPiece();
		
		if (sourcePiece == null) {
			return false;
		}

		if (player != playerMoving) {
			return false;
		}
		
		if (sourcePiece.isWhite() != player.isWhiteSide()) {
			return false;
		}
	
		if (!sourcePiece.isAllowedMove(board, sourceSquare, endSquare)) {
			return false;
		}
		
		//If there is a piece there, make note in move object that destPiece has been captured. 
		if (destPiece != null) {
			destPiece.setCaptured(true);
			move.setPieceCaptured(destPiece);
		}
		
		/*
		// Check castle and make note in move that a castle has occured for player(colour)
		if (sourcePiece != null && sourcePiece instanceof King 
								&& sourcePiece.isCastlingMove()) {
			move.setCastlingMove(true);
		}
		*/
		
		/*
		//if the piece in play is a pawn, register that it has moved and it can no 
		// longer move two pieces.
		if (sourcePiece instanceof Pawn) {
			sourcePiece.setHasMoved(true);
		}
		*/

		/*	
		This simple line checking for check works because if the opponent's attacking
		your king, you can only move if you can prevent the check. 
		* TO BE IMPLEMENTED:
		* if (no possible moves cancel check), gamestatus is CHECKMATE/___WIN, break
		* if (no possible moves that dont result in check), gamestatus is STALEMATE, break
		*/
		return !isInCheck(board, player);
	}

	/**
	* Checking for check is definitely not a King matter, as the check a board 
	* configuration in which a king is under attack. These configurations are being searched
	* for in the method below. It suffices to only check for a check once per turn because
	* the overarching case is "you can't move if your king is  under attack".
	* My rationale is: every piece has its own isAllowedMove that decides whether it's okay 
	* for a piece to move (whether it can move in a certain direction, and if so, whether 
	* it can move to a certain position) Checking for a check on the king falls under the 
	* same category, and for each piece checkingforcheck should be part of checking if move 
	* is allowed. 
	*
	* isInCheck checks if a player's king is under attack by iterating 
	* through all pieces (iterating through each square of the board and getting piece on that 
	* square) and checking if that piece is an opponent's.
	* If it is, get its possble endSquare if it were to move, and if that piece is the Player
	* player's king, then return true as that is a check. This method is found in verifyMove();
	* 
	* TO BE REVIEWED. It is possible the line containing "instanceof King" checks for check 
	* on both kings.
	* 
	* @param Board board, the board on which the game occurs.
	* @param Player player, the player for which we want to carry out a check for check
	* @retrun boolean whether said player is in check.
	*
	*/
	public boolean isInCheck(Board board, Player player) {
		boolean playerColour = player.isWhiteSide();
		Square[][] boardArray = board.getBoardArray();
		//loop through squares
		try {
			for (int i = 0; i < boardArray.length; i++) {
				for (int j = 0; j < boardArray[i].length; j++) {
					Piece selectedPiece = board.getSquare(i, j).getPiece();
					//if piece at current square is opposite Colour of candidate player
					if (playerColour && selectedPiece.isWhite() == !playerColour) {
						//if piece's current legal squares moves contains square of player's king
						if (selectedPiece.getLegalDestinationSquares(boardArray[i][j]) instanceof King) {
							return true;
						}
					} else {
						return false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("You tried to retrieve attribute isWhite for a piece that is null (for an empty square)" + e);
			e.printStackTrace();
		}
		
		return false;
	}
}

