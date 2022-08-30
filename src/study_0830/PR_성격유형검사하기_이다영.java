package study_0830;

import java.util.*;

public class PR_성격유형검사하기_이다영 {
	  public String solution(String[] survey, int[] choices) {
	        String answer = "";
	        
	        HashMap<Character, Integer> map = new HashMap<>();
	        
	        int l = survey.length;
	        
	        for(int i = 0 ; i < l ; i++ ){
	            String sur = survey[i];
	            int score = choices[i];
	            
	            if(score == 0) continue;
	            else if(score < 4) {
	                map.put(sur.charAt(0), map.getOrDefault(sur.charAt(0), 0) + (4-score));
	            }else{
	                map.put(sur.charAt(1),  map.getOrDefault(sur.charAt(1), 0) + (score-4));
	            }
	        }
	        
	        // 비교
	        if ( map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ){
	            answer += 'R';
	        }else{
	            answer += 'T';
	        }

	        if ( map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ){
	            answer += 'C';
	        }else{
	            answer += 'F';
	        }

	        if ( map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ){
	            answer += 'J';
	        }else{
	            answer += 'M';
	        }

	        if ( map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ){
	            answer += 'A';
	        }else{
	            answer += 'N';
	        }
	        
	        return answer;
	    }
}
