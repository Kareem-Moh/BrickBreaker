import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	public int x,y, width, height, hardness;
	public boolean hasPowerUp;
	
	//TODO: Add power up to code
	public Brick(int x, int y, int hardness) {
		width = Resources.BRICK1_WIDTH;
		height = Resources.BRICK1_HEIGHT;
		this.x = x;
		this.y = y;
		hasPowerUp = false;
		this.hardness = hardness;
	}
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
		
	}
}
