package project.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	//1138x462
	public MainFrame(){
		this.setTitle("");

		this.setSize(1138, 490);
		
		mainPanel=new MainMenu(this);
		this.add(mainPanel);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setVisible(true);
	}	

}
