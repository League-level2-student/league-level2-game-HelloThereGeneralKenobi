import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

class Player{
	public int xPosition = 0;
	public int yPosition = 0;
	
	int xMove = 20;
	int yMove = 20;
	
	private boolean moveLeft = false;
	private boolean moveRight = false;
	
	public Player(){
		xPosition = 225;
		yPosition = 0;	 
	}
	
	public void moveLeft(){
		moveLeft = true;
	}
	
	public void moveRight(){
		moveRight = true;
	}
	
	public void moveDown(){
		
		yPosition += yMove;
	}
	
	public void draw(Graphics g){
		g.fillRect(xPosition - 4, yPosition, 20, 20);
	}
	
	//public void update(){
	//	moveLeft = false;
	//	moveRight = false;
	//}
}