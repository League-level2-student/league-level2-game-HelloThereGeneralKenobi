import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class level2Game extends JPanel implements ActionListener, KeyListener{
	JFrame frame = new JFrame();
	
	Timer t = new Timer(1000 / 60, this);
	
	Grid grid = new Grid();
	
	Player p = new Player();
	
	public static void main(String[] args) {
		new level2Game().start();
	}
	
	public void start(){
		setPreferredSize(new Dimension(500, 500));
		frame.add(this);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		t.start();
	}

	int x = 0;
	
	@Override
	public void paintComponent(Graphics g){
		grid.draw(g);
		p.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			t.stop();
			System.exit(0);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			p.moveLeft();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			p.moveRight();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			p.moveDown();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

