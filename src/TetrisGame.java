/**
 * TetrisGame is the model of the Tetris application
 * It stores information and can be called by the controller
 */

/**
 * @author cassielm
 */
public class TetrisGame {

	//make board
	TetrisBoard board; 

	//instance variables
	public int[] startPos = new int[] {0, 5};
	
	private int score;
	private int tetrisScore;
	
	/**
	 * Set up the board
	 */
	public TetrisGame() {

		board = new TetrisBoard();
		score = 0;

	}

	/**
	 * Check if there is a full row
	 */
	public boolean checkForLineClear() {
		
		int count = 0;
		int tetrisCount = 0;
		boolean[] filledRows = new boolean[board.getNumRows()];
		
		//find full lines
		for (int i = 0; i < board.getNumRows(); i++){
			for (int j = 0; j < board.getNumCols(); j++) {
				if (board.boardMatrix[i][j]==true) {
					count++;
				}
			}
			if (count == board.getNumCols()) {
				score++;
				tetrisCount++;
				filledRows[i]=true;
			}
			count = 0;
		}
		
		//clear full lines
		if (tetrisCount >= 1) {
			
			for (int i = 0; i < board.getNumRows(); i++) {
				if (filledRows[i]==true) {
					board.removeRow(i);
				}
			}
			if (tetrisCount >= 5) {
				tetrisScore++;
			}
			return true;
		}
		
		//if no filled lines, exit without doing anything
		return false;
	}
	
	/**
	 * Checks if the piece can move in specified direction
	 */
	public Boolean legalMove(int key, int[] pos) {
		
		//instance variables
		int row = board.getCurrentPosition()[0];
		int col = board.getCurrentPosition()[1];
		
		//check if another piece is below or if it has hit the bottom 
		if (key == 40) {
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (board.getCurrentPiece().pieceMatrix[i][j]==true) {
						if (i+row+1 >= board.getNumRows()) {
							return false;
						}
						else if (board.boardMatrix[row+i+1][col+j]==true) {
							return false;
						}
					}
				}
			}
			
		}
		
		//check if another piece is to the right or if it has hit the edge
		if (key == 39) {
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (board.getCurrentPiece().pieceMatrix[i][j]==true) {
						if (j+col+1 >= board.getNumCols()) {
							return false;
						}
						else if (board.boardMatrix[row+i][col+j+1]==true) {
							return false;
						}
					}
				}
			}
			
		}
		
		//check if another piece is to the left or if it has hit the edge
		if (key == 37) {

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (board.getCurrentPiece().pieceMatrix[i][j]==true) {
						if (j+col-1 < 0) {
							return false;
						}
						else if (board.boardMatrix[row+i][col+j-1]==true) {
							return false;
						}
					}
				}
			}
			
		}
		
		//check if it can rotate clockwise without hitting the edge or a piece
		if (key == 88) {
			
			int deg = board.getCurrentPiece().getRotation();
			Boolean[][] comparisonPiece;

			//get the future rotation matrix
			if (deg == 0) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR4();
			}
			else if (deg == 90) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR1();
			}
			else if (deg == 180) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR2();
			}
			else {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR3();
			}
			
			//check rotation
			if (!checkRotation (row, col, comparisonPiece)) {
				return false;
			}
			
		}
		
		//check if it can rotate counterclockwise without hitting the edge or a piece
		if (key == 90) {
			
			int deg = board.getCurrentPiece().getRotation();
			Boolean[][] comparisonPiece;

			//get the future rotation matrix
			if (deg == 0) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR2();
			}
			else if (deg == 90) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR3();
			}
			else if (deg == 180) {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR4();
			}
			else {
				comparisonPiece = board.getCurrentPiece().getPieceMatrixR1();
			}
			
			//check rotation
			if (!checkRotation(row, col, comparisonPiece)) {
				return false;
			}
			
		}
		
		//if no obstructions, return true
		return true;
		
	}
	
	/**
	 * Writes the old piece to the board
	 * Replaces currentPiece with a new one
	 */
	public void newPiece() {
		
		int row = board.getCurrentPosition()[0];
		int col = board.getCurrentPosition()[1];
		
		//write current piece to the board
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board.getCurrentPiece().pieceMatrix[i][j ]== true){
					board.boardMatrix[row+i][col+j] = true;
					board.colorMatrix[row+i][col+j] = board.getCurrentPiece().getColor();
				}
			}
		}
		
		//new random shape to replace current shape
		double random = 7* Math.random();
		random = Math.ceil(random);
		
		if (random == 1.0){
			board.setCurrentPiece(new TetrisI());
		}
		else if (random == 2.0) {
			board.setCurrentPiece(new TetrisJ());
		}
		else if (random == 3.0) {
			board.setCurrentPiece(new TetrisL());
		}
		else if (random == 4.0) {
			board.setCurrentPiece(new TetrisO());
		}
		else if (random == 5.0) {
			board.setCurrentPiece(new TetrisS());
		}
		else if (random == 6.0) {
			board.setCurrentPiece(new TetrisT());
		}
		else {
			board.setCurrentPiece(new TetrisZ());
		}
		
		//locate the currentPiece at the top of the screen
		board.setCurrentPosition(startPos);
		
	}
	
	/**
	* Check if this hypothetical matrix is over the edge or overlapping another piece
	*/
	public boolean checkRotation(int row, int col, Boolean[][] comparisonPiece) {
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				//going off the edge
				if ((j+col) >= board.getNumCols() || (j+col) < 0) {
					return false;
				}
				//overlapping with another piece
				if (comparisonPiece[i][j ]==true){
					if (board.boardMatrix[i+row][j+col]==true) {
						return false;
					}
				}
			}
		}
		return true;
		
	}
	
	/**
	 * Setters and getters
	 */
	public int getScore() {
		return score;
	}
	
	public int getTetrisScore() {
		return tetrisScore;
	}
	
}