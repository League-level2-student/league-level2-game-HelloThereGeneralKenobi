import java.awt.Color;
import java.awt.Graphics;

class Grid{
	private int yoffset = 0;
	private int xoffset = 0; 
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		for(int i = 0; i < 25; i++){
			g.fillRect(0, yoffset, 500, 1);
			yoffset += 20;
		}
		yoffset = 0;
		
		for(int i = 0; i < 25; i++){
			g.fillRect(xoffset, 0, 1, 500);
			xoffset += 20;
		}
		xoffset = 0;
	}
}