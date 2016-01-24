import java.awt.Color;

/**
 * TetrisO gives an O piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisO extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisO() {
		pieceMatrix = getPieceMatrixR1();
	}
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] { 
			{true, true, false, false},
			{true, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	public Boolean[][] getPieceMatrixR2 () {
		return getPieceMatrixR1();
	}
	public Boolean[][] getPieceMatrixR3 () {
		return getPieceMatrixR1();
	}
	public Boolean[][] getPieceMatrixR4 () {
		return getPieceMatrixR1();
	}
	
	public Color getColor() {
		
		return new Color(161,238,250);
		
	}

}
