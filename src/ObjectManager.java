import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;
	static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		score = 0;
	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		enemySpawnTime = 1000 - (score*score)/3;
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	static void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	void purgeObjects() {
		for (int i = (projectiles.size() - 1); i >= 0; i--) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
		for (int i = (aliens.size() - 1); i >= 0; i--) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(i);
			}
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				rocket.isAlive = false;
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int k = 0; k < aliens.size(); k++) {
				if (projectiles.get(i).collisionBox.intersects(aliens.get(k).collisionBox)) {
					projectiles.get(i).isAlive = false;
					aliens.get(k).isAlive = false;
					score++;
				}
			}
		}
	}
	
	int getScore() {
		return score;
	}
}
