import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class AimBot {
	boolean on;
	int x1, x2, y1, y2, angle;
	char direction;
	public AimBot(Ball b) {
		x1 = b.x + (b.diameter)/2;
		y1 = b.y;
		x2 = 0;
		y2 = 0;
		direction = 'R';
	}
	public void draw(Graphics g, Ball b) {
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D) g.create();
		
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x1, y1, x2, y2);

        //gets rid of the copy
        g2d.dispose();
	}
	public void move(Ball b) {
		x1 = b.x + (b.diameter)/2;
		y1 = b.y;
		if (direction == 'R') {
			if(x2 >= Resources.GAME_WIDTH) { 
				x2 -= 12;
				direction = 'L';
			} else { x2 += 12;}
		} else if (direction == 'L') {
			if (x2 <= 0) {
				x2 += 12;
				direction = 'R';
			} else { x2 -= 12;}
		}
	}
}
