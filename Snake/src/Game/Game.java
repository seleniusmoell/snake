package Game;

import javax.swing.JFrame;

public class Game {

	public static void main (String[] args) throws InterruptedException{
		
		JFrame frame = new JFrame("Snake");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 350);
		frame.setVisible(true);	

		Snake snake = new Snake();

		Board board = new Board();

		GameEvent event = new GameEvent(snake);

	}
}


