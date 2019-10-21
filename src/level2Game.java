import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class level2Game extends JPanel implements ActionListener, KeyListener{
	JFrame frame = new JFrame();
	
	Timer t = new Timer(1000 / 60, this);
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subTitleFont;
	
	public static void main(String[] args) {
		new level2Game().start();
	}
	
	public void start(){
		setPreferredSize(new Dimension(500, 800));
		frame.add(this);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleFont = new Font("Times New Roman",Font.BOLD,48);
		subTitleFont = new Font("Arial",Font.PLAIN,20);
		
		t.start();
	}

	int x = 0;
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {

	}
	
	void updateEndState() {
	
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Title", 200, 200);
		g.setFont(subTitleFont);
		g.drawString("Press ENTER to start", 140, 350);
		g.drawString("Press SPACE for instructions", 110, 500);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("You Lost >:(", 90, 300);
		g.setFont(subTitleFont);
		//g.drawString(object.getScore() + "", 90, 400);
	}
	
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(10 == e.getKeyCode()) {
			currentState++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			t.stop();
			System.exit(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			JOptionPane.showMessageDialog(null, "try to win");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

