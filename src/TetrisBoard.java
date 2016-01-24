import java.awt.Color;

/**
 * TetrisBoard is an object that stores data for TetrisGame
 * It can send information to the view
 */

/**
 * @author cassielm
 */
public class TetrisBoard {
	
	//constants
	public static final int NUM_ROWS = 18;
	public static final int NUM_COLS = 10;
	
	//make board matrix
	public Boolean[][] boardMatrix;
	public Color[][] colorMatrix;
	
	//make the current moving Tetris piece
	private TetrisPiece currentPiece;
	private int[] currentPiecePosition;
	
	/**
	 * Constructor for TetrisBoard
	 */
	public TetrisBoard() {

		boardMatrix = new Boolean[NUM_ROWS][NUM_COLS];
		colorMatrix = new Color[NUM_ROWS][NUM_COLS];
		
		//initialize all elements to be false
		for (int i = 0; i < NUM_ROWS; i++){
			for (int j = 0; j < NUM_COLS; j++) {
				boardMatrix[i][j] = false;
			}
		}
		
		currentPiece = new TetrisL();
		
		currentPiecePosition = new int[] {0,5};
		

	}
	
	/**
	 * Move the current piece
	 */
	public void moveRight() {

		int[] newPos = {getCurrentPosition()[0],getCurrentPosition()[1]+1};
		setCurrentPosition(newPos);

	}
	
	public void moveLeft() {

		int[] newPos = {getCurrentPosition()[0],getCurrentPosition()[1]-1};
		setCurrentPosition(newPos);
		
	}
	
	public void moveDown() {

		int[] newPos = {getCurrentPosition()[0]+1,getCurrentPosition()[1]};
		setCurrentPosition(newPos);

	}

	
	/**
	 * Removes a full row from the board
	 */
	public void removeRow(int row) {
		
		//move everything above the row down
		for (int i = row; i > 0 ; i--) {
			for (int j = 0; j < NUM_COLS; j++) {
				boardMatrix[i][j] = boardMatrix[i-1][j];
				colorMatrix[i][j] = colorMatrix[i-1][j];
			}
		}
		
		//new blank row on top
		for (int j = 0; j < NUM_COLS; j++) {
			boardMatrix[0][j] = false;
		}
		
	}
	
	/**
	 * Setters and getters
	 */
	public int[] getCurrentPosition() {
		return currentPiecePosition;
	}
	
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}
	
	public void setCurrentPosition(int[] pos) {
		currentPiecePosition = pos;
	}
	
	public void setCurrentPiece(TetrisPiece piece) {
		currentPiece = piece;
	}
	
	public int getNumRows() {
		return NUM_ROWS;
	}
	
	public int getNumCols() {
		return NUM_COLS;
	}
	
}
