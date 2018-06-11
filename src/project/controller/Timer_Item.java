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

public class Timer_Item extends Thread{
	private MainFrame mf;
	private JPanel panel;
	private JLabel scoreField, stageLabel;
	private HumanMove human;
	private Score s;
	//op : 폭탄과 돈이 떨어질 확률을 결정하는 변수, 
	//op2 : 돈과 폭탄 중 세부 아이템의 확률을 결정하는 변수,
	//op3 : 랜덤박스를 먹었을 시 금괴와 빨강 폭탄 중 어느걸 떨어뜨릴지 확률을 결정하는 변수
	private int op,op2,op3=(int)(Math.random()*2)+1;;
	private boolean randomSW;
	//떨어지는 아이템을 미리 만들어 저장하기 위해 선언된 쓰레드
	private Thread[] items=new Item[132];
	private Thread[] itemsGold=new Item[132];
	private Thread[] itemsBomb=new Item[132];

	public Timer_Item(MainFrame mf, JPanel panel, HumanMove human, Score s){
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

	//랜덤 박스를 먹었는지 안 먹었는지 확인하는 함수
	public void setRandomSW(boolean randomSW) {
		this.randomSW = randomSW;
	}

	//화면에 뿌려줄 아이템을 만들어 놓는 함수
	public void makeItem(){
		for(int i=0;i<132;i++){
			op = (int)(Math.random()*4);
			switch(op){
			case 0:
			case 1:
			case 2:
				op2 = (int)(Math.random()*1000);
				if(op2>500){
					items[i]=new Coin(panel, human);
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

	//랜덤 박스 먹었을 때 나올 금괴, 폭탄을 미리 만들어 놓음
	public void changeItem(){
		for(int i=0;i<itemsGold.length;i++){
			itemsGold[i]=new Goldbar(panel, human);
			itemsBomb[i]=new BombRed(panel, human);
		}
	}

	@Override
	public void run() {
		int count=0;
		for(int i = 0; i < 132; i++){
			if(randomSW){	//랜덤 박스를 먹었을 때 if문 진입
				count++;
				if(op3==2){ 	
					itemsGold[i].start();
					if(count==20){ //20개 한정
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
			else{ //랜덤박스 제외 다른 아이템을 뿌려준다
				items[i].start();
			}
			scoreField.setText(Integer.toString(human.getScore()));
			if(i==7){ //게임 시작 후 START 라벨을 안 보이게 함
				stageLabel.setVisible(false);
			}
			if(i==129){ //주어진 시간 종료 후 스레드 종료
				try {
					this.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				this.sleep(200); //0.2초마다 아이템 하나씩 발생
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		//현재 게임 패널에 있는 모든 컴포넌트들을 제거
		panel.removeAll();

		//보너스 페이지로 전환
		mf.remove(panel);
		panel=new Bonus(mf, human, s);
		mf.add(panel);
		mf.repaint();

	}


}
