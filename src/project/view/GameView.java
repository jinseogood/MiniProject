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

	private int x=550;
	private int y=330;

	public GameView(MainFrame mf){
		this.setSize(1138, 500);
		this.setLayout(null);
		Image img=new ImageIcon("images/player2.gif").getImage().getScaledInstance(90, 80, 0);
		JLabel label=new JLabel(new ImageIcon(img));
		Image backgroundImg = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 100); 
		JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
		label.setBounds(x, y, 100, 155);
		backgroundLabel.setSize(1138, 462);
		HumanMove test=new HumanMove(label,x,y);
		test.Move(mf, this);

		this.add(label);
		this.add(backgroundLabel);
	}

}
