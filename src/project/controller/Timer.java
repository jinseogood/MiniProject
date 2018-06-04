package project.controller;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.model.vo.BombBlue;
import project.model.vo.BombGreen;
import project.model.vo.BombRed;
import project.model.vo.Coin;
import project.model.vo.Goldbar;
import project.model.vo.Item;
import project.model.vo.Money;
import project.model.vo.Moneybag;
import project.view.MainFrame;
import project.view.RankingView;

public class Timer extends Thread{
	private MainFrame mf;
	private JPanel panel;
	private HumanMove human;
	private String userId;
	private int op,op2;
	private Thread[] items=new Item[150];

	public Timer(MainFrame mf, JPanel panel, HumanMove human){
		this.mf = mf;
		this.panel = panel;
		this.human=human;

		Image timerImg=new ImageIcon("images/timer.gif").getImage().getScaledInstance(51, 51, 0);
		JLabel timerLabel=new JLabel(new ImageIcon(timerImg));

		timerLabel.setBounds(550, 0, 51, 51);

		panel.add(timerLabel);

		for(int i=0;i<150;i++){
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
				}else if(op2>50){
					items[i]=new Moneybag(panel, human);
				}else{
					items[i]=new Goldbar(panel, human);
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

	@Override
	public void run() {
		for(int i = 0; i < 150; i++){
			items[i].start();
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		panel.removeAll();
		userId = JOptionPane.showInputDialog("아이디를 입력하세요!");
		//saveScore(userId);
		mf.remove(panel);
		panel=new RankingView(mf);
		mf.add(panel);
		mf.repaint();


	}

	/*public void saveScore(String userId){
		new ScoreManager(userId, mf, panel).saveScore();
	}*/

}
