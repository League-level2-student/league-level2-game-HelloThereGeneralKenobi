import java.awt.Color;
import java.awt.Graphics;

public class AlienLeft extends GameObject {

	AlienLeft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	void update() {
		super.update();
		x++;
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
