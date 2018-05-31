package project.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import project.view.MainFrame;

public class HumanMove {
	//private MainFrame mf;
	private int x;
	private int y;

	public HumanMove(/*MainFrame mf,*/ int x, int y){
		//this.mf=mf;
		this.x=x;
		this.y=y;
	}

	public void Move(MainFrame mf){
		System.out.println("asdfasdf");
		System.out.println("x : " + x + "y : " + y);
		mf.addKeyListener(new KeyAdapter(){
			

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					x-=50;
					System.out.println("aaaaa");
					mf.repaint();
				}
			}

		});
		System.out.println("eeeeee");
	}

}
