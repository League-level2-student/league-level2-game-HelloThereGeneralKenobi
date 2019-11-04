import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subTitleFont;
	Rocketship ship;
	ObjectManager object;
	
	GamePanel() {
		
	timer = new Timer(1000/60, this);
	titleFont = new Font("wingdings",Font.BOLD,48);
	subTitleFont = new Font("wingdings",Font.PLAIN,20);
	ship = new Rocketship(250,700,50,50);
	object = new ObjectManager(ship);
	}
	
	void startGame () {
		timer.start();
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		object.update();
		object.manageEnemies();
		object.checkCollision();
		object.purgeObjects();
		if(ship.isAlive == false) {
			currentState = END_STATE;
		}
	}
	
	void updateEndState() {
	
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 15, 200);
		g.setFont(subTitleFont);
		g.drawString("Press ENTER to start", 75, 350);
		g.drawString("Press SPACE for instructions", 15, 500);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		object.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("YOU DIED", 90, 300);
		g.setFont(subTitleFont);
		g.drawString(object.getScore() + " Enemies killed", 90, 400);
	}
	
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){

            drawMenuState(g);
	
	    }else if(currentState == GAME_STATE){

            drawGameState(g);

	    }else if(currentState == END_STATE){

            drawEndState(g);

    }
	        }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){

            updateMenuState();

		}else if(currentState == GAME_STATE){

            updateGameState();

		}else if(currentState == END_STATE){

            updateEndState();

    }
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed");
		if(10 == e.getKeyCode()) {
			currentState++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		
		if(e.getKeyCode() == 37) {
			ship.left = true;
		}
		if(e.getKeyCode() == 38) {
			ship.up = true;
		}
		if(e.getKeyCode() == 39) {
			ship.right = true;
		}
		if(e.getKeyCode() == 40) {
			ship.down = true;
		}
		if(e.getKeyCode() == 32) {
			ObjectManager.addProjectile(new Projectile(ship.x + 20, ship.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyEvent");
		if(e.getKeyCode() == 37) {
			ship.left = false;
		}
		if(e.getKeyCode() == 38) {
			ship.up = false;
		}
		if(e.getKeyCode() == 39) {
			ship.right = false;
		}
		if(e.getKeyCode() == 40) {
			ship.down = false;
		}
	}
}
