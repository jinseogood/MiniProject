package project.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private JButton btnStart, btnRank, btnExit;
	private JPanel panel;
	
	public MainMenu(MainFrame mf){
		MainMenu m=this;
		this.setSize(1138, 500);
		this.setLayout(null);
		
		btnStart=new JButton();
		btnRank=new JButton();
		btnExit=new JButton();
		
		btnStart.setSize(80, 20);
		btnRank.setSize(80, 20);
		btnExit.setSize(80, 20);
		
		btnStart.setLocation(550, 230);
		btnRank.setLocation(550, 260);
		btnExit.setLocation(550, 290);
		
		Image icon = new ImageIcon("images/back.PNG").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		
		JLabel label = new JLabel(new ImageIcon(icon));
		
		/*Icon or*/ImageIcon btn = new ImageIcon("images/button.PNG");/*.getImage().getScaledInstance(80, 20, 100);*/
		
		btnStart.setIcon(btn);
		btnRank.setIcon(btn);
		btnExit.setIcon(btn);
		label.setSize(1138, 462);
		//label.setLayout(null);
		
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mf.remove(m); 
				panel=new GameView();
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
		
		this.add(label);
		label.add(btnStart);
		label.add(btnRank);
		label.add(btnExit);
		
	}

	public JPanel getPanel() {
		return panel;
	}
}
