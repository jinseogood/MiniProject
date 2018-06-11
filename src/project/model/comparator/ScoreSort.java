package project.model.comparator;

import java.util.Comparator;

import project.model.dao.Score;

public class ScoreSort implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Score s1 = (Score) o1;
		Score s2 = (Score) o2;
		
		int result = 0;
		
		if(s1.getScore() == s2.getScore()){
			result = 0;
		}
		if(s1.getScore() > s2.getScore()){
			result = -1;
		}
		if(s1.getScore() < s2.getScore()){
			result = 1;
		}
		
		return result;
	}
}
