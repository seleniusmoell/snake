package Game;

enum DIRECTION {up, down, left, right};

public class Snake {
	
	private DIRECTION direction = DIRECTION.right;
	
	public Snake() {
	}
	
	public void setDirection(DIRECTION direction) {
		this.direction = direction;
	}
	
	public DIRECTION getDirection() {
		return this.direction;
	}
	
	
}
