import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class AlienTop extends GameObject implements ActionListener {

	Timer timer;
	boolean activeHitBox;
	
	AlienTop(int x, int y, int width, int height) {
		super(x, y, width, height);
		timer = new Timer(1000,this);
		timer.start();
		collisionBox.setBounds(1000, 1000, 1, 1);
		activeHitBox = false;
	}
	
	void update() {
		if(activeHitBox == true) {
			super.update();
		}
		y++;
	}

	void draw(Graphics g) {
		if(activeHitBox == false) {
			g.setColor(Color.green);
		}
		else {
			g.setColor(Color.yellow);
		}
		g.fillRect(x, y, width, height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		collisionBox.setBounds(x, y, width, height);
		activeHitBox = true;
		timer.stop();
	}
}
