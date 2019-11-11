import java.awt.Color;
import java.awt.Graphics;

public class AlienTop extends GameObject {

	AlienTop(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	void update() {
		super.update();
		y++;
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}
}
