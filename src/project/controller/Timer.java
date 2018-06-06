package project.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import project.model.vo.Goldbar;
import project.model.vo.Item;
import project.model.vo.Money;
import project.model.vo.Moneybag;
import project.model.vo.RandomBox;
import project.view.MainFrame;
import project.view.RankingView;

public class Timer extends Thread{
	private MainFrame mf;
	private JPanel panel;
	private JLabel scoreField;
	private HumanMove human;
	private Score s;
	private String userId;
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
		scoreLabel.setFont(new Font("Consolas", Font.BOLD, 23));
		scoreField.setFont(new Font("Consolas", Font.BOLD, 23));

		timerLabel.setBounds(550, 0, 51, 51);
		scoreLabel.setBounds(938, 10, 130, 23);
		scoreField.setBounds(1038, 10, 200, 23);

		panel.add(timerLabel);
		panel.add(scoreLabel);
		panel.add(scoreField);

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
				}else{
					items[i]=new RandomBox(panel, human, this);
				}
				break;
			case 3:
				op2 = (int)(Math.random()*1000);
				if(op2>666){
					items[i]=new BombBlue(panel, human);
				}else if(op2>333){
					items[i]=new BombRed(panel, human);
				}else{
					items[i]=new BombGreen(panel, human);
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
					if(count==34){
						randomSW=false;
						op3=(int)(Math.random()*2)+1;
					}
				}
				else{
					itemsBomb[i].start();
					if(count==34){
						randomSW=false;
						op3=(int)(Math.random()*2)+1;
					}
				}
			}
			else{
				items[i].start();
			}
			scoreField.setText(Integer.toString(human.getScore()));
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		panel.removeAll();
		Image dialogImg = new ImageIcon("images/icon.PNG").getImage().getScaledInstance(51, 51, 0);

		userId = (String) JOptionPane.showInputDialog(null, human.getScore() + "점, 아이디를 입력하세요!", "게임 종료", JOptionPane.PLAIN_MESSAGE , new ImageIcon(dialogImg), null, "");
		s.setScore(human.getScore());
		s.setUserId(userId);
		s.scoreSave();

		mf.remove(panel);
		panel=new RankingView(mf, s);
		mf.add(panel);
		mf.repaint();


	}


}
