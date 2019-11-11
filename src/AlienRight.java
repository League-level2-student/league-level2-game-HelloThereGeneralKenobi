import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class AlienRight extends GameObject {

	AlienRight(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	void update() {
		super.update();
		x = x - 1;//((new Random.nextInt(6)+2)/4);
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
