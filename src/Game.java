import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Applet implements Runnable, KeyListener{
	Thread thread;
	Platform p;
	public void init() {
		
		this.resize(Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		this.addKeyListener(this);
		p = new Platform();
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		p.draw(g);
	}
	public void update(Graphics g) {
		paint(g);
	}
	@Override
	public void run() {
		
		while(true) {

			p.move();
			repaint();
			//System.out.println(p.movingLeft + " " + p.movingRight);
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
		if(e.getKeyCode() == KeyEvent.VK_LEFT) { p.setMovingLeft(true);} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) { p.setMovingRight(true); }		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) { p.setMovingLeft(false);} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) { p.setMovingRight(false); }		
	}
}
