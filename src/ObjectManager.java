import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {

	Rocketship rocket;
	static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<AlienTop> aliensTop = new ArrayList<AlienTop>();
	ArrayList<AlienBottom> aliensBottom = new ArrayList<AlienBottom>();
	ArrayList<AlienLeft> aliensLeft = new ArrayList<AlienLeft>();
	ArrayList<AlienRight> aliensRight = new ArrayList<AlienRight>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	int border;
	Timer timer;
	int seconds;
	
	

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		score = 0;
		border = 0;
		timer = new Timer(1000,this);
		timer.start();
		seconds = 0;
	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
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
		}
		if(rocket.y == 750 && border == 1) {
			System.out.println("Bottom");
			border--;
			score++;
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
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
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
	}

	static void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien(AlienTop alien) {
		aliensTop.add(alien);
	}
	void addAlien(AlienBottom alien) {
		aliensBottom.add(alien);
	}
	void addAlien(AlienLeft alien) {
		aliensLeft.add(alien);
	}
	void addAlien(AlienRight alien) {
		aliensRight.add(alien);
	}

	void purgeObjects() {
		for (int i = (projectiles.size() - 1); i >= 0; i--) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
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
			addAlien(new AlienTop(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			addAlien(new AlienBottom(new Random().nextInt(LeagueInvaders.width),(LeagueInvaders.height), 50, 50));
			addAlien(new AlienLeft(0, new Random().nextInt(LeagueInvaders.height), 50, 50));
			addAlien(new AlienRight((LeagueInvaders.width), new Random().nextInt(LeagueInvaders.height), 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void checkCollision() {
		for (AlienTop a : aliensTop) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int k = 0; k < aliensTop.size(); k++) {
				if (projectiles.get(i).collisionBox.intersects(aliensTop.get(k).collisionBox)) {
					projectiles.get(i).isAlive = false;
					aliensTop.get(k).isAlive = false;
				}
			}
		}
		for (AlienBottom a : aliensBottom) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int k = 0; k < aliensBottom.size(); k++) {
				if (projectiles.get(i).collisionBox.intersects(aliensBottom.get(k).collisionBox)) {
					projectiles.get(i).isAlive = false;
					aliensBottom.get(k).isAlive = false;
				}
			}
		}
		for (AlienLeft a : aliensLeft) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int k = 0; k < aliensLeft.size(); k++) {
				if (projectiles.get(i).collisionBox.intersects(aliensLeft.get(k).collisionBox)) {
					projectiles.get(i).isAlive = false;
					aliensLeft.get(k).isAlive = false;
				}
			}
		}
		for (AlienRight a : aliensRight) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int k = 0; k < aliensRight.size(); k++) {
				if (projectiles.get(i).collisionBox.intersects(aliensRight.get(k).collisionBox)) {
					projectiles.get(i).isAlive = false;
					aliensRight.get(k).isAlive = false;
				}
			}
		}
	}
	
	int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		seconds++;
		
	}
}
