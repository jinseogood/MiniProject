package project.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RankingView extends JPanel {
	private JPanel panel;
	private JLabel btnReturn;
	
	public RankingView(MainFrame mf){
		RankingView r=this;
		this.setSize(1138, 500);
		
		Image icon = new ImageIcon("images/rankingbg.PNG").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		
		JLabel label = new JLabel(new ImageIcon(icon));
		
		label.setSize(1138, 462);
		
		Image iReturn = new ImageIcon("Images/buttons/returnbtn.png").getImage().getScaledInstance(218, 121, 0);
		Image iReturn1 = new ImageIcon("Images/buttons/return.gif").getImage().getScaledInstance(218, 121, 0);
		
		btnReturn = new JLabel();
		
		btnReturn.setIcon(new ImageIcon(iReturn));
		
		btnReturn.setSize(218, 121);
		btnReturn.setLocation(480, 290);
		
		btnReturn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e){
				btnReturn.setIcon(new ImageIcon(iReturn1));
			}
			@Override
			public void mouseExited(MouseEvent e){
				btnReturn.setIcon(new ImageIcon(iReturn));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				mf.remove(r);
				panel=new MainMenu(mf);
				mf.add(panel);
				mf.repaint();
			}
			
		}); 
		
		label.add(btnReturn);
		this.add(label);
	} 

	

}
