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


public class Board extends JPanel {	

	private Board b;
	
	public Board (){}

	public void addBoard (JFrame f) {	
		b = new Board ();
		f.add(b);
	}

	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// draw board
		g2d.setColor(Color.black);
		g2d.drawRect(30, 15, 250, 250);

	}


}
