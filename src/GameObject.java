import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive;
	Rectangle collisionBox;
	
	GameObject (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isAlive = true;
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	void update() {
		//x = x + 10;
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g){
		//g.fillRect(x, y, width, height);
	        }
}
