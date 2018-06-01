package project.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer extends Thread{
	private MainFrame mf;
	private JPanel panel;
	private String userId;
	
	public Timer(MainFrame mf, JPanel panel){
		this.mf = mf;
		this.panel = panel;
	}

	@Override
	public void run() {
		for(int i = 30; i >= 0; i--){
			try {
				System.out.println(i);
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		userId = JOptionPane.showInputDialog("아이디를 입력하세요!");
		//saveScore(userId);
		mf.remove(panel);
		panel=new RankingView(mf);
		mf.add(panel);
		mf.repaint();
		
		
	}
	
	/*public void saveScore(String userId){
		new ScoreManager(userId, mf, panel).saveScore();
	}*/

}
