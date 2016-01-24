import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

/**
 * TetrisGuiApplication builds the JFrame for the GUI game of Tetris
 */

/**
 * @author cassielm 
 * and tremendous help from TA Sophie
 */
public class TetrisGUIApplication{
	
	/**
	 * Create a JFrame that holds the TetrisController
	 * 
	 **/
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame("Tetris");
		
		guiFrame.add( new JLabel("Press the arrow keys, z, or x to play."), BorderLayout.NORTH);
		guiFrame.add( new TetrisGUIController() );
		guiFrame.pack();
		
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setSize(300, 590);
		guiFrame.setTitle("Tetris Game");
		guiFrame.setVisible(true);
		
	}

}
