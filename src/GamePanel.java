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
	Player ship;
	ObjectManager object;
	
	GamePanel() {
		
	timer = new Timer(1000/60, this);
	titleFont = new Font("helvetica",Font.BOLD,46);
	subTitleFont = new Font("helvetica",Font.PLAIN,24);
	ship = new Player(250,700,50,50);
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
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, CarGame.width, CarGame.height);
		g.setFont(titleFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("SUPAAA FROGGER", 25, 150);
		g.setFont(subTitleFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Try to complete as many waves as possible", 25, 500);
		g.drawString("and do that while lasting as long as possible", 25, 535);
		g.drawString("you complete a wave by reaching the top of", 25, 570);
		g.drawString("the screen and making it back down to the", 25, 605);
		g.drawString("bottom. Just don't die 4head", 25, 640);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CarGame.width, CarGame.height);
		object.draw(g);
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 40, 600, 5);
		//g.fillRect(0, 760, 600, 5);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CarGame.width, CarGame.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("YOU GOT RUN OVER,", 5, 300);
		g.drawString("IDIOT", 200, 350);
		g.setFont(subTitleFont);
		g.drawString("Completed " + object.getScore() + " waves and lasted " +  object.seconds + " seconds", 20, 400);
	}
	
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){

            drawMenuState(g);
	
	    }else if(currentState == GAME_STATE){

            drawGameState(g);

	    }else if(currentState == END_STATE){

            drawEndState(g);
            timer.stop();

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
