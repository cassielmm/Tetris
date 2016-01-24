import java.awt.Color;

/**
 * TetrisPiece is the blueprint for all TetrisPiece objects in the game
 */

/**
 * @author cassielm
 */
public abstract class TetrisPiece {
	
	//variables
	public Boolean[][] pieceMatrix;
	private int rotation = 0;
	
	//matrixes for all 4 possible rotation shapes
	public abstract Boolean[][] getPieceMatrixR1();
	public abstract Boolean[][] getPieceMatrixR2();
	public abstract Boolean[][] getPieceMatrixR3();
	public abstract Boolean[][] getPieceMatrixR4();
	
	//color
	public abstract Color getColor();
	
	/**
	 * Update TetrisPiece pieceMatrix to reflect rotation
	 */
	public void rotateCW() {
		
		if (rotation == 0) {
			pieceMatrix = getPieceMatrixR4();
			rotation = 270;
		}
		else if (rotation == 90) {
			pieceMatrix = getPieceMatrixR1();
			rotation = 0;
		}
		else if (rotation == 180) {
			pieceMatrix = getPieceMatrixR2();
			rotation = 90;
		}
		else if (rotation == 270) {
			pieceMatrix = getPieceMatrixR3();
			rotation = 180;
		}

	}
	
	public void rotateCCW() {
	
		if (rotation == 0) {
			pieceMatrix = getPieceMatrixR2();
			rotation = 90;
		}
		
		else if (rotation == 90) {
			pieceMatrix = getPieceMatrixR3();
			rotation = 180;
		}
		else if (rotation == 180) {
			pieceMatrix = getPieceMatrixR4();
			rotation = 270;
		}
		else if (rotation == 270) {
			pieceMatrix = getPieceMatrixR1();
			rotation = 0;
		}
	
	}
	
	/**
	 * Setters and getters
	 */
	public int getRotation() {
		return rotation;
	}
	
	public void setRotation(int deg) {
		rotation = deg;
	}
	
}
