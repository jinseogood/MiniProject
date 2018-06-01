package project.view;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;

public class GameView extends JPanel{

	private int x=530;
	private int y=330;

	public GameView(MainFrame mf){
		this.setSize(1138, 500);
		this.setLayout(null);
		Image playerImg=new ImageIcon("images/player2.gif").getImage().getScaledInstance(90, 80, 0);
		JLabel playerLabel=new JLabel(new ImageIcon(playerImg));
		Image backgroundImg = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 0); 
		JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
		Image timerImg=new ImageIcon("images/timer5.gif").getImage().getScaledInstance(141, 484, 0);
		JLabel timerLabel=new JLabel(new ImageIcon(timerImg));
		
		playerLabel.setBounds(x, y, 100, 155);
		backgroundLabel.setSize(1138, 462);
		timerLabel.setBounds(10, 0, 141, 484);
		
		HumanMove human=new HumanMove(playerLabel,x,y);
		human.Move(mf, this);

		this.add(timerLabel);
		this.add(playerLabel);
		this.add(backgroundLabel);
	}

}
