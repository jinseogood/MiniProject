package project.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.model.dao.Score;

public class RankingView extends JPanel {
	private JPanel panel;
	private JLabel btnReturn;
	private ArrayList<Score> list;
	
	public RankingView(MainFrame mf, Score s){
		RankingView r=this;
		this.setSize(1138, 500);
		
		Image icon = new ImageIcon("images/rankingbg.png").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		
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
		list=s.readAll();
		
		Font font = new Font("맑은 고딕", Font.BOLD, 36);
		JLabel[] score=new JLabel[3];
		
		for(int i=0;i<score.length;i++){
			score[i]=new JLabel();
			score[i].setText("  ");
			score[i].setBounds(77+(i*380), 95, 400, 200);
			score[i].setFont(font);
			label.add(score[i]);
		}
		for(int i=0;i<list.size();i++){
			if(i < score.length){
			s=(Score)list.get(i);
			score[i].setText(s.getScore() + " / " + s.getUserId());
			}
		}
		
		label.add(btnReturn);
		this.add(label);
		
	} 

	

}
