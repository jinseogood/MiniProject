package project.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private JButton btnStart, btnRank, btnExit;
	private JPanel panel;
	
	public MainMenu(MainFrame mf){
		MainMenu m=this;
		this.setSize(1138, 462);
		this.setLayout(null);
		
		btnStart=new JButton("Start");
		btnRank=new JButton("Rank");
		btnExit=new JButton("Exit");
		
		btnStart.setSize(80, 20);
		btnRank.setSize(80, 20);
		btnExit.setSize(80, 20);
		
		btnStart.setLocation(550, 230);
		btnRank.setLocation(550, 260);
		btnExit.setLocation(550, 290);
		
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.remove(m); 
				panel=new GameView(mf);
				mf.add(panel);
				mf.repaint();
				
			}
			
		});
		
		btnRank.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.remove(m);
				panel=new RankingView(mf, m);
				mf.add(panel);
				mf.repaint();
				
			}
			
		});
		
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		this.add(btnStart);
		this.add(btnRank);
		this.add(btnExit);
		
	}

	public JPanel getPanel() {
		return panel;
	}
}
