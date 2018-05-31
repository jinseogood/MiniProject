package project.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	//1138x462
	public MainFrame(){
		this.setTitle("인생 한방 !");
		this.setSize(1138, 500);
		
		mainPanel=new MainMenu(this);
		this.add(mainPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	

}
