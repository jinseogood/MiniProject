package project.controller;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.view.MainFrame;

public class HumanMove {
	private JLabel playerLabel;
	private int score=0;
	private int playerX=530;
	private int playerY=330;

	public HumanMove(JPanel panel){
		Image playerImg=new ImageIcon("images/player.gif").getImage().getScaledInstance(90, 80, 0);
		playerLabel=new JLabel(new ImageIcon(playerImg));
		
		playerLabel.setBounds(playerX, playerY, 100, 155);
		
		panel.add(playerLabel);
	}
	
	public int getPlayerX() {
		return playerX;
	}
	
	public int getPlayerY() {
		return playerY;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void Move(MainFrame mf, JPanel panel){		
		mf.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					if(playerX>0){
						playerX-=20;
						playerLabel.setLocation(playerX, playerY);
					}
				}

				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					if(playerX<1015){
						playerX+=20;
						playerLabel.setLocation(playerX, playerY);
					}
				}
			}

		});
	}

	
	

}
