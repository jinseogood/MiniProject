package project.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	//1138x462
	public MainFrame(){
		this.setTitle("A Round Of Life");
		this.setSize(1138, 490);
		
		//프로그램 아이콘
		try {
			this.setIconImage(ImageIO.read(new File("images/icon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//메인 메뉴 객체 생성 및 추가
		mainPanel=new MainMenu(this);
		this.add(mainPanel);
		
		this.setResizable(false);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true); 
		this.setVisible(true);
		
		//배경음악
		try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
            		new File("sound/splatoon8bit.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
		
	}	

}
