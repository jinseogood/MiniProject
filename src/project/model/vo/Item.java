package project.model.vo;

import javax.swing.JPanel;

public class Item extends Thread{
	public Item(){}
	@Override
	public void run() {
		if(this instanceof Money){
			new Money().start();			
		}
		if(this instanceof Goldbar){
			new Goldbar().start();
		}
		if(this instanceof Moneybag){
			new Moneybag().start();
		}
		if(this instanceof Coin){
			new Coin().start();
		}
		if(this instanceof BombBlue){
			new BombBlue().start();
		}
		if(this instanceof BombRed){
			new BombRed().start();
		}
		if(this instanceof BombGreen){
			new BombGreen().start();
		}
	}



}
