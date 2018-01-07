package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TAdapter implements KeyListener {
	private Snake snake;
	
	public TAdapter(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void keyPressed (KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			snake.setDirection(DIRECTION.up);
			break;
		case KeyEvent.VK_DOWN :
			snake.setDirection(DIRECTION.down);
			break;
		case KeyEvent.VK_LEFT:
			snake.setDirection(DIRECTION.left);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setDirection(DIRECTION.right);
			break;
		default: break;
		}

	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
