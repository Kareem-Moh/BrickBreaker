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
		} else {
			x += velocityX;
			y += velocityY;
		}
		if (x <= 0 || x >= Resources.GAME_WIDTH){
			velocityX = -velocityX;
		}
		if (y <= 0){
			velocityY = -velocityY;
		} else if (y >= Resources.GAME_HEIGHT){
			start = true; //Loses a life
		}
	}
	
	public void launch(AimBot a) {
		start = false;
		velocityX = (a.x2 + (a.x2 - x))/100;
		velocityY = - (y - a.y2)/100;
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
