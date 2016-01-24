import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * TetrisGUIView is the view for the GUI Tetris game
 * It displays information and receives updates from the controller
 */

/**
 * @author cassielm
 */
public class TetrisGUIView extends JPanel {

	//eclipse generated serial version UID
	private static final long serialVersionUID = 2582922621854628026L;

	//create an instance of the board
	private TetrisBoard board;

	//constants
	public static final int BLOCK_SIZE = 30;
	
	/**
	 * Constructor for TetrisGUIView
	 */
	public TetrisGUIView(TetrisBoard b) {
		
		board = b;
		
	}
	
	/**
	 * Paint the board and currentPiece
	 */
	public void paint(Graphics g) { 
		
		int row = board.getCurrentPosition()[0];
		int col = board.getCurrentPosition()[1];
		
		for (int i = 0; i < board.getNumRows(); i++){
			for (int j = 0; j < board.getNumCols(); j++) {
				int[] pos = {i,j};
				if (board.boardMatrix[i][j] == true) {
					if (board.colorMatrix[i][j] != null){
						paintSquare(g, pos, board.colorMatrix[i][j]);
					}
					else {
						paintSquare(g, pos, Color.WHITE);
					}
				}
				else if (i >= row && i <= row+3 && j >= col && j <= col+3) {
					if (board.getCurrentPiece().pieceMatrix[i-row][j-col] == true) {
						paintSquare(g, pos, board.getCurrentPiece().getColor());
					}
					else {
						paintSquare(g, pos, Color.BLACK);
					}
				}
				else {
					paintSquare(g, pos, Color.BLACK);
				}
			}
		}

	}
	
	/**
	 * Paint a square
	 */
	public void paintSquare(Graphics g, int[] pos, Color color) {
		
		//filled block
		g.setColor(color);
		g.fillRect(pos[1]*BLOCK_SIZE, pos[0]*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
		
		//outline
		g.setColor(Color.BLACK);
		g.drawRect(pos[1]*BLOCK_SIZE, pos[0]*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
		
	}

}
