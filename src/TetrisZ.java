import java.awt.Color;

/**
 * TetrisZ gives an Z piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisZ extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisZ() {
		pieceMatrix = getPieceMatrixR1();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] {	
			{true, true, false, false},
			{false, true, true, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] {	
			{false, true, false, false},
			{true, true, false, false},
			{true, false, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] {	
			{true, true, false, false},
			{false, true, true, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] {	
			{false, true, false, false},
			{true, true, false, false},
			{true, false, false, false},
			{false, false, false, false} };
	}
	
	public Color getColor() {
		
		return new Color(204, 204, 255);
		
	}
	
}
