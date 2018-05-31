package project.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JPanel{
	public GameView(){
		this.setSize(1138, 500);
		
		Image icon = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		
		JLabel label = new JLabel(new ImageIcon(icon));
		
		label.setSize(1138, 500);
		//label.setLayout(null);
		
		this.add(label);
	}
	
}
