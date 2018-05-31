package project.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RankingView extends JPanel {
	private JButton btnReturn;
	private JPanel panel;
	
	public RankingView(MainFrame mf, MainMenu m){
		this.setSize(1138, 462);
		this.setBackground(Color.RED);
		
		btnReturn=new JButton("main");
		
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
		
		this.add(btnReturn);
	}

	

}
