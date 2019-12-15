import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class TruckBottom extends GameObject implements ActionListener {
	
	Timer timer;
	boolean activeHitBox;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	TruckBottom(int x, int y, int width, int height) {
		super(x, y, width, height);
		timer = new Timer(1000,this);
		timer.start();
		collisionBox.setBounds(1000, 1000, 1, 1);
		activeHitBox = false;
		if (needImage) {
		    loadImage ("upTruck.png");
		}
	}
	
	void update() {
		if(activeHitBox == true) {
			super.update();
		}
		y--;
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.YELLOW);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		collisionBox.setBounds(x, y, width, height);
		activeHitBox = true;
		timer.stop();
	}
}
