package project.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	//1138x462
	public MainFrame(){
		this.setTitle("A Round Of Life");
		this.setSize(1138, 490);
		
		try {
			this.setIconImage(ImageIO.read(new File("images/icon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mainPanel=new MainMenu(this);
		this.add(mainPanel);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setVisible(true);
	}	

}
