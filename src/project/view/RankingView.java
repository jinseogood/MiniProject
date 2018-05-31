package project.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RankingView extends JPanel {
	private JButton btnReturn;
	private JPanel panel;
	
	public RankingView(MainFrame mf, MainMenu m){
		this.setSize(1138, 500);
		
		Image icon = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		
		JLabel label = new JLabel(new ImageIcon(icon));
		
		label.setSize(1138, 462);
		//label.setLayout(null);
		
		btnReturn=new JButton();
		
		ImageIcon btn = new ImageIcon("images/button.PNG");
		btnReturn.setIcon(btn);
		
		btnReturn.setSize(80, 20);
		btnReturn.setLocation(550, 230);
		
		btnReturn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.remove(m.getPanel());
				panel=new MainMenu(mf);
				mf.add(panel);
				mf.repaint();
			}
			
		});
		
		
		label.add(btnReturn);
		this.add(label);
	}

	

}
