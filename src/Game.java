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
	Random rand = new Random();
	Color randomColor = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	public void init() {
		
		this.resize(Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		this.addKeyListener(this);
		p = new Platform();
		b = new Ball(p);
		a = new AimBot(b);
		bricks = new ArrayList<Brick>();
		currX = 0; currY = 15;
		for (int i = 0; i < 30 ; i++){
			bricks.add(new Brick(currX, currY, 1));
			if(currX + Resources.BRICK1_WIDTH > Resources.GAME_WIDTH){
				currX = 0;
				currY += 15 + 1;
			} else {
				currX += Resources.BRICK1_WIDTH + 1;
			}
		}
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, Resources.GAME_WIDTH, Resources.GAME_HEIGHT);
		p.draw(g);
		if (b.start) {a.draw(g, b);}
		b.draw(g);
		for (Brick br : bricks){
			br.draw(g, randomColor);
		}
	}
	public void update(Graphics g) {
		paint(g);
	}
	@Override
	public void run() {
		
		while(true) {

			p.move();
			b.move(p);
			System.out.println(b.velocityX + " " + b.velocityY);
			if (b.start) {a.move(b);}
			repaint();
			try {
				Thread.sleep(25);
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
