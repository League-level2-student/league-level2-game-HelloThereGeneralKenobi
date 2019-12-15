import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	
	int speed;
	boolean up;
	boolean down;
	boolean right;
	boolean left;
	int border;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		border = 0;
		if (needImage) {
		    loadImage ("frogLookingUp.png");
		}
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		super.update();
		if (up) {
			y-= speed;
		}
		if (down) {
			y+= speed;
		}
		if (left) {
			x-= speed;
		}
		if (right) {
			x+= speed;
		}
		/*
		if(y == 50 && border == 0) {
			border++;
			loadImage ("frogLookingDown.png");
		}
		if(y == 700 && border == 1) {
			border--;
			loadImage ("frogLookingUp.png");
		}
		*/
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

}
