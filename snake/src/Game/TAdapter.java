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
			if(snake.getDirection() != DIRECTION.down)
				snake.setDirection(DIRECTION.up);
			break;
		case KeyEvent.VK_DOWN :
			if(snake.getDirection() != DIRECTION.up)
				snake.setDirection(DIRECTION.down);
			break;
		case KeyEvent.VK_LEFT:
			if(snake.getDirection() != DIRECTION.right)
				snake.setDirection(DIRECTION.left);
			break;
		case KeyEvent.VK_RIGHT:
			if(snake.getDirection() != DIRECTION.left)
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
