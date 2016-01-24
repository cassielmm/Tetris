import java.awt.Color;

/**
 * TetrisL gives an L piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisL extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisL() {
		pieceMatrix = getPieceMatrixR1 ();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] { 
			{true, false, false, false},
			{true, false, false, false},
			{true, true, false, false},
			{false, false, false, false} };
	}
		
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] { 
			{false, false, true, false},
			{true, true, true, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
		
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] { 
			{true, true, false, false},
			{false, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };
	}

	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] { 
			{true, true, true, false},
			{true, false, false, false},
			{false, false, false, false},
			{false, false, false, false} };
	}
	
	public Color getColor() {
		
		return new Color(237,229,116);
		
	}
	
}
