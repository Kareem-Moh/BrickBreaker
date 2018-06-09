import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Applet implements Runnable, KeyListener{
	Thread thread;
	Platform p;
	Ball b;
	AimBot a;
	ArrayList<Brick> bricks;
	int currX, currY;
	Grid gr;
	
	public void init() {
		
		this.resize(Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		this.addKeyListener(this);
		p = new Platform();
		b = new Ball(p);
		a = new AimBot(b);
		bricks = new ArrayList<Brick>();
		currX = 0; currY = 15;
		gr = new Grid(50, 3);
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		p.draw(g);
		if (b.start) {a.draw(g, b);}
		b.draw(g);
		gr.draw(g);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	@Override
	public void run() {
		
		while(true) {

			p.move();
			b.move(p);
			//System.out.println(b.velocityX + " " + b.velocityY);
			if (b.start) {a.move(b);}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && b.start){
			b.launch(a);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) { 
			p.setMovingLeft(true);
		} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) { 
			p.setMovingRight(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) { 
			p.setMovingLeft(false);
		} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) { 
			p.setMovingRight(false); 
		}
	}
}
