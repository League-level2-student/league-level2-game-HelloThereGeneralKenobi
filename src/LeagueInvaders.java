import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	
	JFrame frame;
	final static int width = 500;
	final static int height = 800;
	GamePanel gamePanel;
	
	public static void main(String[] args) {
		
		LeagueInvaders object = new LeagueInvaders();
		object.setup();
	}
		void setup() {
			frame = new JFrame();
			gamePanel = new GamePanel();
			frame.add(gamePanel);
			frame.setVisible(true);
			frame.addKeyListener(gamePanel);
			frame.getContentPane().setPreferredSize(new Dimension(width, height));
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gamePanel.startGame();
		
		}
}
