package project.model.vo;

import javax.swing.JPanel;

public class Item extends Thread{
	private Item item=this;
	
	public Item(){}

	@Override
	public void run() {
		if(item instanceof Money){
			new Money().start();			
		}
		if(item instanceof Goldbar){
			new Goldbar().start();
		}
		if(item instanceof Moneybag){
			new Moneybag().start();
		}
		if(item instanceof Coin){
			new Coin().start();
		}
		if(item instanceof BombBlue){
			new BombBlue().start();
		}
		if(item instanceof BombRed){
			new BombRed().start();
		}
		if(item instanceof BombGreen){
			new BombGreen().start();
		}
	}



}
