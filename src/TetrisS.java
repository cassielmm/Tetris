import java.awt.Color;

/**
 * TetrisS gives an S piece its shape
 */

/**
 * @author cassielm
 */
public class TetrisS extends TetrisPiece {
	
	/**
	 * Constructor
	 */
	public TetrisS() {
		pieceMatrix = getPieceMatrixR1();
						
		/*String line = "";
		for  (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
					line+=pieceMatrix[i][j];
				}
			System.out.println(line);
			line="";
		}*/
	}
	
	public Boolean[][] getPieceMatrixR1 () {
		return new Boolean[][] {
			{false, true, true, false},
			{true, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR2 () {
		return new Boolean[][] {
			{true, false, false, false},
			{true, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR3 () {
		return new Boolean[][] {
			{false, true, true, false},
			{true, true, false, false},
			{false, false, false, false},
			{false, false, false, false} };	
	}
	
	public Boolean[][] getPieceMatrixR4 () {
		return new Boolean[][] {
			{true, false, false, false},
			{true, true, false, false},
			{false, true, false, false},
			{false, false, false, false} };	
	}
	
	public Color getColor() {
		
		return new Color(136,255,201);
		
	}
	
}
