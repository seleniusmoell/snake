package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{	

	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 1000;
	private final int DOT_SIZE = 10;
	private final int ALL_DOTS = (B_HEIGHT*B_WIDTH)/(DOT_SIZE*DOT_SIZE);
	private final int RANDOM_POS = 29;
	private final int DELAY = 500;

	private final int x[] = new int[ALL_DOTS];
	private final int y[] = new int [ALL_DOTS];
	private Snake snake;
	private Apple apple;

	private int dots;
	private boolean ingame = false;
	private Timer timer;

	public Board (){
		snake = new Snake();
		apple = new Apple();
		addKeyListener(new TAdapter(snake));
		setBackground(Color.WHITE);
		setFocusable(true);

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		initGame();
	}

	private void initGame() {
		dots = 3;

		for(int z = 0; z < dots; z++) {
			this.x[z] = 50 - z * DOT_SIZE;
			this.y[z] = 50;

			ingame = true;
			timer = new Timer(DELAY, this);
			timer.start();
		}

	}
	
	private void locateApple() {

        int r = (int) (Math.random() * RANDOM_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RANDOM_POS);
        apple_y = ((r * DOT_SIZE));
    }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		if (ingame) {

			for (int z = 0; z < dots; z++ ) {
					g.drawRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
				g.fillRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
			}
		} else 
		{
			gameOver(g);
		}

	}

	private void gameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.BLACK);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - metr.stringWidth(msg) / 2), (B_HEIGHT / 2));
	}

	private void move() {
		for (int z = dots; z > 0; z--) {
			x[z] = x[z - 1];
			y[z] = y[z - 1];

			switch(snake.getDirection()) {
			case down:
				y[0] += DOT_SIZE;
				break;
			case up:
				y[0] -= DOT_SIZE;
				break;
			case right:
				x[0] += DOT_SIZE;
				break;
			case left:
				x[0] -= DOT_SIZE;	
				break;
			}
		}
	}

	private void checkCollision() {
		
		for(int z = dots; z > 0; z--) {
			
			// Check if snake is biting its own tail
			if((z > 4) && x[0]==x[z] && (y[0]==y[z])) {
				ingame = false;
			}
			
			if(y[0]>= B_HEIGHT) {
				ingame = false;
			}
			if(y[0]<0) {
				ingame = false;
			}
			if(x[0]>= B_WIDTH) {
				ingame = false;
			}
			if(x[0]<0) {
				ingame = false;
			}
			if(!ingame) {
				timer.stop();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ingame) {
			checkCollision();
			move();
		}
		
		repaint();	
	}
}

