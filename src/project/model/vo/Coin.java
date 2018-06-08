package project.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;

public class Coin extends Item implements Runnable{
	private JPanel panel;
	private JLabel item;
	private HumanMove human;
	private int itemX=0;
	private int itemY=0;
	
	public Coin(){}
	public Coin(JPanel panel, HumanMove human){
		this.panel=panel;
		this.human=human;
		this.makeItem();
	}
	
	public void makeItem(){
		itemX=(int)(Math.random()*1090);

		Image itemImg=new ImageIcon("images/coin.gif").getImage().getScaledInstance(50, 50, 0);
		item=new JLabel(new ImageIcon(itemImg));
		
		item.setBounds(itemX, itemY, 50, 50);
		item.setVisible(false);

		panel.add(item);
	}
	
	public void fallingStart(){
		item.setVisible(true);
	}
	public void fallingEnd(){
		panel.remove(item);
	}
	
	public void falling(){
		itemY+=15;
		item.setLocation(itemX, itemY);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.fallingStart();
			while(true){
				if(itemY<407){
					int dis = (int)(Math.sqrt((human.getPlayerX() + 35 - itemX)*(human.getPlayerX() + 35 - itemX)
							+ (human.getPlayerY()- itemY)*(human.getPlayerY()- itemY)));
					if(dis<60 && itemY > 330){
						human.setScore(human.getScore()+1000);
						System.out.println("score:" + human.getScore());
						this.fallingEnd();
						break;
					}
					Thread.sleep(120);
					this.falling();
				}
				else{
					this.fallingEnd();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
