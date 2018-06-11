package project.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;
import project.controller.Timer_Item;
import project.model.dao.Score;

public class GameView extends JPanel{

	public GameView(MainFrame mf, Score s){
		this.setSize(1138, 500);
		this.setLayout(null);
		Image backgroundImg = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 0); 
		JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImg));

		backgroundLabel.setSize(1138, 462);
		
		//캐릭터 움직이게 하는 클래스
		HumanMove human=new HumanMove(this);
		human.Move(mf, this);

		//타이머, 점수, 아이템 출력 기능을 가진 클래스
		Thread timer_item=new Timer_Item(mf,this, human, s);
		timer_item.start();

		this.add(backgroundLabel);

	}

}