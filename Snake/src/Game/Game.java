package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game {

	public static void main (String[] args) throws InterruptedException{

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new GameEvent();
				frame.setVisible(true);
				}
		});

	}
}


