package project.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.HumanMove;

public class Diamond extends Item implements Runnable{
	private JPanel panel;
	private JLabel item;
	private HumanMove human;
	private int itemX=0;
	private int itemY=0;
	
	public Diamond(){}
	public Diamond(JPanel panel, HumanMove human){
		this.panel=panel;
		this.human=human;
		this.makeItem();
	}
	
	//�������� �����ϴ� �Լ�
	public void makeItem(){
		itemX=(int)(Math.random()*1090);

		Image itemImg=new ImageIcon("images/diamond.gif").getImage().getScaledInstance(50, 50, 0);
		item=new JLabel(new ImageIcon(itemImg));
		
		item.setBounds(itemX, itemY, 50, 50);
		item.setVisible(false);

		panel.add(item);
	}
	
	//���� �� �������� �������� ���� �����ִ� �Լ�
	public void fallingStart(){
		item.setVisible(true);
	}
	//���� �������� ����� ��, �Ծ��� �� �����ִ� �Լ�
	public void fallingEnd(){
		panel.remove(item);
	}
	
	//�������� �Լ� (X, Y �� �� ������)
	public void falling(){
		int op=(int)(Math.random()*2)+1;
		if(op==1){
			itemX-=100;
			itemY+=50;
			item.setLocation(itemX, itemY);
		}
		else{
			itemX+=100;
			itemY+=50;
			item.setLocation(itemX, itemY);
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.fallingStart();
			while(true){
				if(itemY<407){
					//int dis = �������� �Ͱ� ĳ������ �ִ� �Ÿ��� ���
					int dis = (int)(Math.sqrt((human.getPlayerX() + 35 - itemX)*(human.getPlayerX() + 35- itemX)
							+ (human.getPlayerY()- itemY)*(human.getPlayerY()- itemY)));
					//�ִ� �Ÿ�, �����۰� ������ �Ÿ��� �Ǻ� 
					if(dis<60 && itemY > 330){
						human.setScore(human.getScore()+5000000);
						System.out.println("score:" + human.getScore());
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
