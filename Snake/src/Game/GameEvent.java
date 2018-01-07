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

public class GameEvent extends JFrame{	

		public GameEvent (){
			add(new Board());
			
			setResizable(false);
			pack();
			
			setTitle("Snake");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

