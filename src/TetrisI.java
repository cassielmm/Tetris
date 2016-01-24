import java.awt.Color;

/**
 * TetrisI gives an I piece its shape
*/

/**
 * @author cassielm
 */
public class TetrisI extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisI() {
		pieceMatrix = getPieceMatrixR1();
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] { 
					{true, false, false, false},
					{true, false, false, false},
					{true, false, false, false},
					{true, false, false, false} };
	}

	public Boolean[][] getPieceMatrixR2() {	
		return new Boolean[][] { 
					{false, false, false, false},
					{false, false, false, false},
					{false, false, false, false},
					{true, true, true, true} };
	}

	public Boolean[][] getPieceMatrixR3() {	
		return new Boolean[][] { 
					{false, false, false, true},
					{false, false, false, true},
					{false, false, false, true},
					{false, false, false, true} };
	}

	public Boolean[][] getPieceMatrixR4() {	
		return new Boolean[][] {  
					{true, true, true, true},
					{false, false, false, false},
					{false, false, false, false},
					{false, false, false, false} };
	}
	
	public Color getColor() {
		
		return new Color(255,78,80);
	}
	
}
