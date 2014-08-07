package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;


public class Board extends JPanel implements ActionListener, KeyListener {	
	private Snake s;
	private Board b;

	private int x1;
	private int x2;
	private int y1;
	private int y2;

	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean rightPressed = false;
	private boolean leftPressed = false;


	public Board (Snake snake){
		s = snake;

		//listen to key presses
		setFocusable(true);
		addKeyListener(this);

		// call moveSnake() 5 fps
		Timer timer = new Timer(1000/5, this);
		timer.start();
	}

	public void actionPerformed (ActionEvent e) {
		moveSnake();
	}

	public void openWindow (JFrame f) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350, 350);
		b = new Board (s);
		f.add(b);
		f.setVisible(true);
	}

	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		//				RenderingHints.VALUE_ANTIALIAS_ON);

		// draw board
		g2d.setColor(Color.black);
		g2d.drawRect(30, 15, 250, 250);

		// draw snake head		
		g2d.drawLine(s.getX(), s.getY(), s.getX(), s.getY());

		// draw snake tail
		for (int i = 1; i < s.getSize(); i++){

			g2d.drawLine(s.getTailX(i), s.getTailY(i), s.getTailX(i), s.getTailY(i));
		}


	}

	public void moveSnake() {	

		repaint();

		// set new direction
		if (upPressed == true) {
			s.setDir("up");
		} else if (downPressed == true) {
			s.setDir("down");
		} else if (rightPressed == true) {
			s.setDir("right");
		} else if (leftPressed == true) {
			s.setDir("left");
		}

		// move tail
		moveTail();

		// set new position
		switch(s.getDir()) {		
		case "up": 			
			s.setY(-1);
			break;
		case "down":
			s.setY(1);
			break;
		case "left":
			s.setX(-1);
			break;
		case "right":
			s.setX(1);
			break;
		default:
			break;
		}

	}

	public void moveTail(){

		// set X
		for (int i = s.getSize() - 1; i > 0 ; i--){

			s.setTailX(i, s.getTailX(i - 1));
		}

		s.setTailX(0, s.getX());

		// set Y
		for (int i = s.getSize() - 1; i > 0 ; i--){

			s.setTailY(i, s.getTailY(i - 1));
		}

		s.setTailY(0, s.getY());
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed (KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			upPressed = true;
			break;
		case KeyEvent.VK_DOWN :
			downPressed = true;
			break;
		case KeyEvent.VK_LEFT:
			leftPressed = true;
			break;
		case KeyEvent.VK_RIGHT:
			rightPressed = true;
			break;
		default: break;
		}

	}

	public void keyReleased(KeyEvent e){

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			upPressed = false;
			break;
		case KeyEvent.VK_DOWN :
			downPressed = false;
			break;
		case KeyEvent.VK_LEFT:
			leftPressed = false;
			break;
		case KeyEvent.VK_RIGHT:
			rightPressed = false;
			break;
		default: break;
		}

	}


}
