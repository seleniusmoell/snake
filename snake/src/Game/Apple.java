package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Apple {
	private int x;
	private int y;
	private final int RANDOM_POS = 29;
	private ImageIcon icon;
	
	public Apple(int dotSize) {
		this.x = (int)(Math.random() * RANDOM_POS) * dotSize;
		this.y = (int)(Math.random() * RANDOM_POS) * dotSize;
		this.icon = new ImageIcon("src/resources/apple.png");
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Image getImage() {
		return this.icon.getImage();
	}
}
