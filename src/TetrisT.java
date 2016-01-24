import java.awt.Color;

/**
 * TetrisT gives a T piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisT extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisT() {
		pieceMatrix = getPieceMatrixR1();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] {
			{false, true, false, false},
			{true, true, true, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] {
			{false, true, false, false},
			{true, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] {
			{true, true, true, false},
			{false, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] {
			{false, true, false, false},
			{false, true, true, false},
			{false, true, false, false},
			{false, false, false, false} };
	}					
	
	public Color getColor() {
		
		return new Color(96,185,154);

	}
}
