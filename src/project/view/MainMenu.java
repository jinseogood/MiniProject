package project.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.model.dao.Score;

public class MainMenu extends JPanel {
	private JButton btnStart, btnRank, btnExit;
	private JPanel panel;
	private JLabel lbStart, lbRank, lbExit;
	private Score s=new Score();

	public MainMenu(MainFrame mf){
		MainMenu m=this;
		this.setSize(1138, 500);
		this.setLayout(null);

		Image iStart = new ImageIcon("Images/buttons/GameStart_normal.PNG").getImage().getScaledInstance(218, 121, 0);
		Image iRanking = new ImageIcon("Images/buttons/Ranking_normal.PNG").getImage().getScaledInstance(218, 121, 0);
		Image iExit = new ImageIcon("Images/buttons/Exit_normal.PNG").getImage().getScaledInstance(218, 121, 0);

		Image iStart1 = new ImageIcon("Images/buttons/GameStart_press.gif").getImage().getScaledInstance(218, 121, 0);
		Image iRanking1 = new ImageIcon("Images/buttons/Ranking_press.gif").getImage().getScaledInstance(218, 121, 0);
		Image iExit1 = new ImageIcon("Images/buttons/Exit_press.gif").getImage().getScaledInstance(218, 121, 0);

		lbStart = new JLabel();
		lbRank = new JLabel();
		lbExit = new JLabel();
		
		lbStart.setIcon(new ImageIcon(iStart));
		lbRank.setIcon(new ImageIcon(iRanking));
		lbExit.setIcon(new ImageIcon(iExit));

		lbStart.setSize(218, 121);
		lbRank.setSize(218, 121);
		lbExit.setSize(218, 121);

		lbStart.setLocation(300, 290);
		lbRank.setLocation(480, 290);
		lbExit.setLocation(660, 290);

		Image icon = new ImageIcon("images/mainbg.PNG").getImage().getScaledInstance(1138, 462, 100); //이미지아이콘으로만드는것이좀더편함
		JLabel label = new JLabel(new ImageIcon(icon));

		
		//버튼에 이벤트 추가 (마우스 이벤트)
		lbStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){	//마우스 들어갔을 때
				lbStart.setIcon(new ImageIcon(iStart1));
				lbStart.setSize(218, 121);
				lbStart.setLocation(300, 290);
			}
			@Override
			public void mouseExited(MouseEvent e) { //마우스 나갔을 때
				lbStart.setIcon(new ImageIcon(iStart));
				lbStart.setSize(218, 121);
				lbStart.setLocation(300, 290);
			}
			
			@Override
			public void mouseClicked(MouseEvent e){ //마우스 클릭 시
				mf.remove(m); 
				panel=new GameView(mf, s);
				mf.add(panel);
				mf.repaint();
			}
		});

		lbRank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){	
				lbRank.setIcon(new ImageIcon(iRanking1));
				lbRank.setSize(218, 121);
				lbRank.setLocation(480, 290);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbRank.setIcon(new ImageIcon(iRanking));
				lbRank.setSize(218, 121);
				lbRank.setLocation(480, 290);
			}
			@Override
			public void mouseClicked(MouseEvent e){
				mf.remove(m);
				panel=new RankingView(mf, s);
				mf.add(panel);
				mf.repaint();
			}
		});
		
		lbExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e){	
				lbExit.setIcon(new ImageIcon(iExit1));
				lbExit.setSize(218, 121);
				lbExit.setLocation(660, 290);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbExit.setIcon(new ImageIcon(iExit));
				lbExit.setSize(218, 121);
				lbExit.setLocation(660, 290);
			}
			@Override
			public void mouseClicked(MouseEvent e){
				System.exit(0);
				}
		});

		label.setSize(1138, 462);

		label.add(lbStart);
		label.add(lbRank);
		label.add(lbExit);
		this.add(label);
		
	}

	public JPanel getPanel() {
		return panel;
	}
}
