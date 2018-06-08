import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	
	boolean movingRight, movingLeft;
	int x, y, velocity, acc, velocity_cap;
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
		acc = Resources.PLATFORM_ACCELERATION;
		velocity_cap = Resources.PLATFORM_VELOCITY_CAP;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	public void move() {
		if (movingLeft == true) {velocity -= acc;}
		else if (movingRight == true) {velocity += acc;}
		else if (!movingLeft && !movingRight) {velocity *= Resources.FRICTION;}
		//Handle paddle moving too fast
		if (velocity >= velocity_cap) {velocity = velocity_cap;}
		else if (velocity <= -velocity_cap) {velocity = -velocity_cap;}
		//Handle wall collision
		if (x >= Resources.GAME_WIDTH - width) {
			if (movingLeft) {x += velocity;}
		} else if (x <= 0) {
			if (movingRight) {x += velocity;}
		} else {
			x += velocity;
		}
		
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
