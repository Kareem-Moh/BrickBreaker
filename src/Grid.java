import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Grid {
	int numBricks, difficulty;
	Random rand;
	ArrayList<Brick> grid;
	
	public Grid(int numBricks, int difficulty){
		this.numBricks = numBricks;
		this.difficulty = difficulty;
		this.grid = new ArrayList<Brick>();
		grid = generateGrid();
	}
	
	public void draw(Graphics g){
		for (Brick b : this.grid){
			b.draw(g);
		}
	}
	
	
	public Color getRandomColor(){
		return new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}
	
	public int getRandomHardness(){
		rand = new Random();
		int hardness = rand.nextInt(difficulty) + 1;
		return hardness;
	}
	
	public ArrayList<Brick> generateGrid(){
		int currX = 10;
		int currY = 10;
		for (int i = 0; i < numBricks; i++){
			grid.add(new Brick(currX, currY, getRandomHardness(), getRandomColor()));
			if((currX += (Resources.BRICK1_WIDTH+1)) >= Resources.GAME_WIDTH){
				currY += Resources.BRICK1_HEIGHT + 1;
				currX = 10;
			}
		}
		return grid;
	}
}
