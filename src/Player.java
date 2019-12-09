import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
	
	int speed;
	boolean up;
	boolean down;
	boolean right;
	boolean left;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
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
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}

}
