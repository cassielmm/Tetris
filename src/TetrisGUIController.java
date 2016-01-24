import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

/**
 * TetrisGuiController is the controller for the GUI Tetris game
 * It takes input from the user, changes the model, and updates the view
 */

/**
 * @author cassielm
 */
public class TetrisGUIController extends JPanel implements KeyListener {

	//eclipse generated serial version UID
	private static final long serialVersionUID = -5924777658925407968L;

	///create an instance of the model
	TetrisGame model;
	
	//create an instance of the view
	TetrisGUIView view;
	
	//create a JLabel
	JLabel score;
	
	/**
	 * Set up the model, view, and first input
	 */
	public void Start() {

		model = new TetrisGame();
		view = new TetrisGUIView(model.board);
		add(view, BorderLayout.CENTER);
		view.setSize(300,540);
		
		//label
		score = new JLabel("Score: "+model.getScore()+"\n"+"Tetrises: "+model.getTetrisScore());
		add(score, BorderLayout.NORTH);
		
		//timer
		Timer timer = new Timer();
		timer.schedule(new dropDown(), 0, 1000);
		
	}
	
	/**
	 * Constructor
	 */
	public TetrisGUIController () {

		super(new BorderLayout());
		
		//add key listener
		this.setFocusable(true);
		addKeyListener(this);
		
		//first time set up
		Start();
		
	}
	
	/**
	 * Updates model with user input
	 * @param key pressed
	 */
	public void updateModel(int key){
		
		int[] pos = model.board.getCurrentPosition();
		boolean legal = model.legalMove(key, pos);
		
		if (legal) {
			if (key == 39) {
				model.board.moveRight();
			}
			if (key == 37) {
				model.board.moveLeft();
			}
			if (key == 40) {
				model.board.moveDown();
			}
			if (key == 88) {
				model.board.getCurrentPiece().rotateCW();
			}
			if (key == 90) {
				model.board.getCurrentPiece().rotateCCW();
			}
		}
		
		updateView();

	}
	
	/**
	 * Updates view
	 */
	public void updateView() {
		
		view.repaint();
		
	}

	/**
	* Listens for user input from user then calls updateModel and updateView
	*/
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		updateModel(keyCode);
		updateView();
		
	}
	
	class dropDown extends TimerTask {
		
		public void run() {
			//move the piece down
			if (model.legalMove(40, model.board.getCurrentPosition())) {
				model.board.moveDown();
			}
			//if the piece can't go down any further, it has hit bottom
			//abandon the piece and make a new one
			else {
				//if the new piece can't enter the screen, game over
				if (!model.checkRotation(model.startPos[0], model.startPos[1], model.board.getCurrentPiece().pieceMatrix)) {
					JOptionPane.showMessageDialog(view, "Game over!");
					System.exit(0);
				}
				else {
					model.newPiece();
				}
			}
			
			score.setText("Score: "+model.getScore()+"\n"+"Tetrises: "+model.getTetrisScore());
			model.checkForLineClear();
			updateView();
			
		}
		
	}
	
	/** Necessary for KeyListener implementation */
	public void keyTyped(KeyEvent e) { }

	/** Necessary for KeyListener implementation */
	public void keyReleased(KeyEvent e) { }

}
