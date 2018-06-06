package project.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;
import project.controller.Timer;

public class RandomBox extends Item implements Runnable{
	private JPanel panel;
	private JLabel item;
	private HumanMove human;
	private Timer timer;
	private int itemX=0;
	private int itemY=0;
	private boolean randomSW=false;
	
	public RandomBox(){}
	public RandomBox(JPanel panel, HumanMove human, Timer timer){
		this.panel=panel;
		this.human=human;
		this.timer=timer;
		this.makeItem();
	}
	
	public void makeItem(){
		itemX=(int)(Math.random()*1090);

		Image itemImg=new ImageIcon("images/randombox.gif").getImage().getScaledInstance(50, 50, 0);
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
	
	public void randomSW(){
		this.randomSW=true;
		timer.setRandomSW(randomSW);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.fallingStart();
			while(true){
				if(itemY<407){
					int dis = (int)(Math.sqrt((human.getPlayerX() + 35 - itemX)*(human.getPlayerX() + 35- itemX)
							+ (human.getPlayerY()- itemY)*(human.getPlayerY()- itemY)));
					if(dis<60 && itemY > 330){
						this.randomSW();
						this.fallingEnd();
						break;
					}
					Thread.sleep(300);
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
