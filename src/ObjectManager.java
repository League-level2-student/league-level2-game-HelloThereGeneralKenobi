import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	Player rocket;
	ArrayList<TruckTop> aliensTop = new ArrayList<TruckTop>();
	ArrayList<TruckBottom> aliensBottom = new ArrayList<TruckBottom>();
	ArrayList<TruckLeft> aliensLeft = new ArrayList<TruckLeft>();
	ArrayList<TruckRight> aliensRight = new ArrayList<TruckRight>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	int border;
	Timer timer;
	int seconds;
	AudioClip bing;
	
	

	ObjectManager(Player rocket) {
		this.rocket = rocket;
		score = 0;
		border = 0;
		timer = new Timer(1000,this);
		timer.start();
		seconds = 0;
		bing = loadSound("woohoo.wav");
	}

	void update() {
		rocket.update();
		for (int i = 0; i < aliensTop.size(); i++) {
			aliensTop.get(i).update();
		}
		for (int i = 0; i < aliensBottom.size(); i++) {
			aliensBottom.get(i).update();
		}
		for (int i = 0; i < aliensLeft.size(); i++) {
			aliensLeft.get(i).update();
		}
		for (int i = 0; i < aliensRight.size(); i++) {
			aliensRight.get(i).update();
		}
		if(rocket.y == 50 && border == 0) {
			System.out.println("Top");
			border++;
			score++;
			bing.play();
			//draw line on other side
		}
		if(rocket.y == 700 && border == 1) {
			System.out.println("Bottom");
			border--;
			score++;
			bing.play();
			//draw line on other side
		}
		if(score <= 15) {
			enemySpawnTime = 3000 - (100 * score);
		}
		else {
			enemySpawnTime = 1500;
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliensTop.size(); i++) {
			aliensTop.get(i).draw(g);
		}
		for (int i = 0; i < aliensBottom.size(); i++) {
			aliensBottom.get(i).draw(g);
		}
		for (int i = 0; i < aliensLeft.size(); i++) {
			aliensLeft.get(i).draw(g);
		}
		for (int i = 0; i < aliensRight.size(); i++) {
			aliensRight.get(i).draw(g);
		}
		g.setColor(Color.white);
		if(border == 1) {
			g.fillRect(0, 740, 600, 5);
		}
		if(border == 0) {
			g.fillRect(0, 40, 600, 5);
		}
	}

	void addAlien(TruckTop alien) {
		aliensTop.add(alien);
	}
	void addAlien(TruckBottom alien) {
		aliensBottom.add(alien);
	}
	void addAlien(TruckLeft alien) {
		aliensLeft.add(alien);
	}
	void addAlien(TruckRight alien) {
		aliensRight.add(alien);
	}

	void purgeObjects() {
		for (int i = (aliensTop.size() - 1); i >= 0; i--) {
			if (aliensTop.get(i).isAlive == false) {
				aliensTop.remove(i);
			}
		}
		for (int i = (aliensBottom.size() - 1); i >= 0; i--) {
			if (aliensBottom.get(i).isAlive == false) {
				aliensBottom.remove(i);
			}
		}
		for (int i = (aliensLeft.size() - 1); i >= 0; i--) {
			if (aliensLeft.get(i).isAlive == false) {
				aliensLeft.remove(i);
			}
		}
		for (int i = (aliensRight.size() - 1); i >= 0; i--) {
			if (aliensRight.get(i).isAlive == false) {
				aliensRight.remove(i);
			}
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new TruckTop(new Random().nextInt(CarGame.width), 0, 50, 50));
			addAlien(new TruckBottom(new Random().nextInt(CarGame.width),(CarGame.height), 50, 50));
			addAlien(new TruckLeft(0, new Random().nextInt(CarGame.height), 50, 50));
			addAlien(new TruckRight((CarGame.width), new Random().nextInt(CarGame.height), 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void checkCollision() {
		for (TruckTop a : aliensTop) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (TruckBottom a : aliensBottom) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (TruckLeft a : aliensLeft) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (TruckRight a : aliensRight) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
	}
	
	int getScore() {
		return score;
	}
	
	public AudioClip loadSound(String fileName) {
		return JApplet.newAudioClip(getClass().getResource(fileName));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		seconds++;
		
	}
}
