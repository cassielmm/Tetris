import java.awt.Color;

/**
 * TetrisJ gives an J piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisJ extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisJ() {
		pieceMatrix = getPieceMatrixR1();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] { 
			{false, true, false, false},
			{false, true, false, false},
			{true, true, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] { 
			{false, false, false, false},
			{true, true, true, false},
			{false, false, true, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] { 
			{false, true, true, false},
			{false, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };
	}
	
	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] { 
			{true, false, false, false},
			{true, true, true, false},
			{false, false, false, false},
			{false, false, false, false} };
	}	
	
	public Color getColor() {
		
		return new Color(252,145,58);
		
	}

}
