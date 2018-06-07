import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	
	boolean movingRight, movingLeft;
	int x, y, velocity;
	int width, height;

	public Platform() {
		movingRight  = false;
		movingLeft = false;
		width = Resources.PLATFORM_WIDTH;
		height = Resources.PLATFORM_HEIGHT;
		//Ensure paddle starts at the center
		x = Resources.GAME_WIDTH/2 - width/2;
		y = Resources.GAME_HEIGHT - 40;
		velocity = 0;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	public void move() {
		if (movingLeft == true) {velocity -= 1;}
		else if (movingRight == true) {velocity += 1;}
		else if (!movingLeft && !movingRight) {velocity *= Resources.FRICTION;}
		x += velocity;
	}
	
	public int getX() {
		return x;
	}
	
	public void setMovingRight(boolean moved) {
		movingRight = moved;
	}
	
	public void setMovingLeft(boolean moved) {
		movingLeft = moved;
	}
}
