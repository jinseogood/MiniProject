package project.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.controller.HumanMove;
import project.controller.Timer;
import project.model.dao.Score;

public class Bonus extends JPanel{
	private MainFrame mf;
	private HumanMove human;
	private Score s;
	private Bonus b=this;
	private JLabel backgroundLabel, boxOp, boxNum, plus, minus;
	private JLabel[] num=new JLabel[10];
	private JPanel panel;
	private String userId;
	private int swOp=0, swNum=0;

	public Bonus(MainFrame mf, HumanMove human, Score s){
		this.mf=mf;
		this.human=human;
		this.s=s;
		panel=this;

		this.setSize(1138, 500);
		this.setLayout(null);
		Image backgroundImg = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 0); 
		backgroundLabel = new JLabel(new ImageIcon(backgroundImg));

		backgroundLabel.setSize(1138, 462);

		Image boxOpImg = new ImageIcon("Images/box.gif").getImage().getScaledInstance(218, 121, 0);
		Image boxNumImg = new ImageIcon("Images/box.gif").getImage().getScaledInstance(218, 121, 0);
		boxOp = new JLabel();
		boxNum = new JLabel();

		boxOp.setBounds(370, 190, 218, 121);
		boxNum.setBounds(610, 190, 218, 121);

		boxOp.setIcon(new ImageIcon(boxOpImg));
		boxNum.setIcon(new ImageIcon(boxNumImg));

		backgroundLabel.add(boxOp);
		backgroundLabel.add(boxNum);

		boxOp.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				backgroundLabel.remove(boxOp);
				swOp=(int)(Math.random()*2)+1;

				if(swOp==2){
					Image plusImg = new ImageIcon("images/icon.PNG").getImage().getScaledInstance(51, 51, 0);
					plus=new JLabel();
					plus.setIcon(new ImageIcon(plusImg));
					plus.setBounds(370, 190, 218, 121);
					backgroundLabel.add(plus);
				}
				else{
					Image minusImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					minus=new JLabel();
					minus.setIcon(new ImageIcon(minusImg));
					minus.setBounds(370, 190, 218, 121);
					backgroundLabel.add(minus);	
				}

				panel.add(backgroundLabel);
				mf.repaint();
			}
		});

		boxNum.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				backgroundLabel.remove(boxNum);
				swNum=(int)(Math.random()*9);
				switch(swNum){
				case 0:
					Image zeroImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[0]=new JLabel();
					num[0].setIcon(new ImageIcon(zeroImg));
					num[0].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[0]);
					
					break;
				case 1:
					Image oneImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[1]=new JLabel();
					num[1].setIcon(new ImageIcon(oneImg));
					num[1].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[1]);
					
					break;
				case 2:
					Image twoImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[2]=new JLabel();
					num[2].setIcon(new ImageIcon(twoImg));
					num[2].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[2]);
					
					break;
				case 3:
					Image threeImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[3]=new JLabel();
					num[3].setIcon(new ImageIcon(threeImg));
					num[3].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[3]);
					
					break;
				case 4:
					Image fourImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[4]=new JLabel();
					num[4].setIcon(new ImageIcon(fourImg));
					num[4].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[4]);
					
					break;
				case 5:
					Image fiveImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[5]=new JLabel();
					num[5].setIcon(new ImageIcon(fiveImg));
					num[5].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[5]);
					
					break;
				case 6:
					Image sixImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[6]=new JLabel();
					num[6].setIcon(new ImageIcon(sixImg));
					num[6].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[6]);
					
					break;
				case 7:
					Image sevenImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[7]=new JLabel();
					num[7].setIcon(new ImageIcon(sevenImg));
					num[7].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[7]);
					
					break;
				case 8:
					Image eightImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[8]=new JLabel();
					num[8].setIcon(new ImageIcon(eightImg));
					num[8].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[8]);
					
					break;
				case 9:
					Image nineImg = new ImageIcon("images/button.PNG").getImage().getScaledInstance(51, 51, 0);
					num[9]=new JLabel();
					num[9].setIcon(new ImageIcon(nineImg));
					num[9].setBounds(610, 190, 218, 121);
					backgroundLabel.add(num[9]);
					
					break;
				}
				panel.add(backgroundLabel);
				mf.repaint();
				
				try {
					Thread.sleep(1000);
					b.dialog();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		

		this.add(backgroundLabel);
	}

	public void dialog(){
		Image dialogImg = new ImageIcon("images/dialogIcon.PNG").getImage().getScaledInstance(51, 51, 0);
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
