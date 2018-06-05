package project.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import project.model.comparator.ScoreSort;

public class Score implements Serializable{
	private int score=0;
	private String userId="";
	
	public Score() {}
	public Score(int score, String userId) {
		this.score = score;
		this.userId = userId;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void scoreSave(){
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream("score.dat", true));
			oos.writeObject(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public ArrayList readAll() {
		ArrayList list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("score.dat");
			list = new ArrayList();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				Score s = (Score) ois.readObject();
				list.add(s);
			}
		} catch (EOFException e) {
			list.sort(new ScoreSort());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	

}
