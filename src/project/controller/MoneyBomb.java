package project.controller;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyBomb extends Thread{
	private JPanel panel;
	private JLabel[] money=new JLabel[2];
	private int[] moneyX=new int[2];
	private int[] moneyY=new int[2];
	private int itemNo=0;

	public MoneyBomb(JPanel panel){
		this.panel=panel;
		
		this.makeItem(0);
		this.makeItem(1);
		
	}
	
	public void makeItem(int itemNo){
		moneyX[itemNo]=(int)(Math.random()*1090);
		
		Image moneyImg=new ImageIcon("images/money" + (itemNo+1) + ".gif").getImage().getScaledInstance(50, 50, 0);
		money[itemNo]=new JLabel(new ImageIcon(moneyImg));
		
		money[itemNo].setBounds(moneyX[itemNo], moneyY[itemNo], 50, 50);
		money[itemNo].setVisible(false);

		panel.add(money[itemNo]);
	}
	
	public void fallingStart(int itemNo){
		money[itemNo].setVisible(true);
	}
	public void fallingEnd(int itemNo){
		panel.remove(money[itemNo]);
	}
	
	public void falling(int itemNo){
		moneyY[itemNo]+=15;
		money[itemNo].setLocation(moneyX[itemNo], moneyY[itemNo]);
	}

	@Override
	public void run() {
		try {
			this.sleep(1000);
			this.fallingStart(0);
			this.fallingStart(1);
			while(true){
				if(moneyY[0]<407){
					this.sleep(500);
					this.falling(0);
					this.falling(1);
				}
				else{
					this.fallingEnd(0);
					this.fallingEnd(1);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
