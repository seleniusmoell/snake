package Game;

public class Snake {
	
	private int x = 150;
	private int y = 19;
	private int size = 4;
	private String dir = "down";
	private int [] tailX = {150, 150, 150, 150};
	private int [] tailY = {18, 17, 16, 15};
	
	public Snake() {
	}
	
	
	public int getX() {
				
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	public int getSize() {
		return size;
	}
	
	public void setX(int i) {
		x += i;
	}
	
	public void setY(int i) {
		y += i;
	}
	
	public void sizeUp() {
		size += 4;
	}
	
	public String getDir() {
		return dir;
	}
	
	public void setDir(String s) {
		dir = s;
	}
	
	public int  getTailX(int i) {
		return tailX[i];
	}
	
	public int getTailY(int i){
		return tailY[i];
	}
	
	public void setTailX(int index, int x) {
		tailX[index] = x;
	}
	
	public void setTailY(int index, int y){
		tailY[index] = y;
	}
	
}
