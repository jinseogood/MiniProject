package project.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.view.MainFrame;

public class HumanMove {
	private JLabel label;
	private int x;
	private int y;

	public HumanMove(JLabel label, int x, int y){
		this.label=label;
		this.x=x;
		this.y=y;
	}

	public void Move(MainFrame mf, JPanel panel){		
		mf.addKeyListener(new KeyAdapter(){


			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT){

					if(x>0){
						x-=20;
						label.setLocation(x, y);
					}
				}

				if(e.getKeyCode()==KeyEvent.VK_RIGHT){

					if(x<1015){
						x+=20;
						label.setLocation(x, y);
					}
				}
			}

		});
	}

}
