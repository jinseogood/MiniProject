package project.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.model.dao.Score;
import project.model.vo.BombBlue;
import project.model.vo.BombGreen;
import project.model.vo.BombRed;
import project.model.vo.Coin;
import project.model.vo.Diamond;
import project.model.vo.Goldbar;
import project.model.vo.Item;
import project.model.vo.Money;
import project.model.vo.Moneybag;
import project.model.vo.RandomBox;
import project.view.Bonus;
import project.view.MainFrame;
import project.view.RankingView;

public class Timer extends Thread{
	private MainFrame mf;
	private JPanel panel;
	private JLabel scoreField, stageLabel;
	private HumanMove human;
	private Score s;
	private int op,op2,op3=(int)(Math.random()*2)+1;;
	private boolean randomSW;
	private Thread[] items=new Item[150];
	private Thread[] itemsGold=new Item[150];
	private Thread[] itemsBomb=new Item[150];

	public Timer(MainFrame mf, JPanel panel, HumanMove human, Score s){
		this.mf = mf;
		this.panel = panel;
		this.human=human;
		this.s=s;

		Image timerImg=new ImageIcon("images/timer.gif").getImage().getScaledInstance(51, 51, 0);
		JLabel timerLabel=new JLabel(new ImageIcon(timerImg));
		JLabel scoreLabel=new JLabel("SCORE : ");
		scoreField=new JLabel("0");
		stageLabel=new JLabel("START");
		scoreLabel.setFont(new Font("Consolas", Font.BOLD, 23));
		scoreField.setFont(new Font("Consolas", Font.BOLD, 23));
		stageLabel.setFont(new Font("Consolas", Font.BOLD, 25));

		timerLabel.setBounds(550, 0, 51, 51);
		scoreLabel.setBounds(908, 10, 130, 23);
		scoreField.setBounds(1008, 10, 200, 23);
		stageLabel.setBounds(540, 220, 100, 25);

		panel.add(timerLabel);
		panel.add(scoreLabel);
		panel.add(scoreField);
		panel.add(stageLabel);

		this.makeItem();
		this.changeItem();
	}

	public void setRandomSW(boolean randomSW) {
		this.randomSW = randomSW;
	}

	public void makeItem(){
		for(int i=0;i<150;i++){
			op = (int)(Math.random()*4);
			switch(op){
			case 0:
			case 1:
			case 2:
				op2 = (int)(Math.random()*1000);
				if(op2>500){
					items[i]=new Coin(panel, human);
					//items[i]=new RandomBox(panel, human, this);
				}else if(op2>200){
					items[i]=new Money(panel, human);
				}else if(op2>80){
					items[i]=new Moneybag(panel, human);
				}else if(op2>35){
					items[i]=new Goldbar(panel, human);
				}else if(op2>5){
					items[i]=new RandomBox(panel, human, this);
				}else{
					items[i]=new Diamond(panel, human);
				}

				break;
			case 3:
				op2 = (int)(Math.random()*1000);
				if(op2>500){
					items[i]=new BombGreen(panel, human);
				}else if(op2>200){
					items[i]=new BombBlue(panel, human);
				}else{
					items[i]=new BombRed(panel, human);
				}
				break;

			}
		}
	}

	public void changeItem(){
		for(int i=0;i<itemsGold.length;i++){
			itemsGold[i]=new Goldbar(panel, human);
			itemsBomb[i]=new BombRed(panel, human);
		}
	}

	@Override
	public void run() {
		int count=0;
		for(int i = 0; i < 150; i++){
			if(randomSW){
				count++;
				if(op3==2){
					itemsGold[i].start();
					if(count==20){
						randomSW=false;
						count=0;
						op3=(int)(Math.random()*2)+1;
					}
				}
				else{
					itemsBomb[i].start();
					if(count==20){
						randomSW=false;
						count=0;
						op3=(int)(Math.random()*2)+1;
					}
				}
			}
			else{
				items[i].start();
			}
			scoreField.setText(Integer.toString(human.getScore()));
			if(i==7){
				stageLabel.setVisible(false);
			}
			if(i==149){
				for(int k=134;k<150;k++){
					try {
						Thread.sleep(1);
						items[k].interrupt();
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
				}
			}
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		panel.removeAll();
		
		mf.remove(panel);
		panel=new Bonus(mf, human, s);
		mf.add(panel);
		mf.repaint();

	}


}
