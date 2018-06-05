package project.view;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;
import project.controller.Timer;
import project.model.dao.Score;

public class GameView extends JPanel{

	public GameView(MainFrame mf, Score s){
		this.setSize(1138, 500);
		this.setLayout(null);
		Image backgroundImg = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 0); 
		JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));
		
		backgroundLabel.setSize(1138, 462);
		
		HumanMove human=new HumanMove(this);
		human.Move(mf, this);
		
		Thread timer=new Timer(mf,this, human, s);
		timer.start();

		this.add(backgroundLabel);
	}

}
