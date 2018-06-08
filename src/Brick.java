import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	public int x,y, width, height, hardness;
	public boolean hasPowerUp;
	public Color c;
	
	//TODO: Add power up to code
	public Brick(int x, int y, int hardness, Color c) {
		this.c = c;
		width = Resources.BRICK1_WIDTH;
		height = Resources.BRICK1_HEIGHT;
		this.x = x;
		this.y = y;
		hasPowerUp = false;
		this.hardness = hardness;
	}
	public void draw(Graphics g) {
		g.setColor(this.c);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(hardness), (x + width/2), (y + height - 2)); //Position string val
	}
	
	public void hit(){
		hardness -= 1;
	}
}
