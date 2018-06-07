import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	int x,y,velocityX, velocityY, diameter;
	boolean start;
	Platform p;
	
	public Ball(Platform p) {
		diameter = Resources.BALL_DIAMETER;
		x = p.x + p.width/2 - diameter/2;
		y = p.y - p.height;
		start = true;
	}
	
	public void move(Platform p) {
		if (start) {
			x = p.x + p.width/2 - diameter/2;
			y = p.y - p.height;
		}
	}
	public void launch() {
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillArc(x, y, 15, 15, 0, 360);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
