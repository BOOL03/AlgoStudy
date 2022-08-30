package study_0830;

import java.util.*;

class PR_성격유형검사하기_배찬비 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] score = new int[26];
        
        for(int i=0; i<survey.length; i++){
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            if(choices[i]<=3){
                score[disagree-'A'] += (4-choices[i]);
            } else{
                score[agree-'A'] += (choices[i]-4);
            }
        }
        
        if(score['R'-'A']>=score['T'-'A']) answer += "R";
        else answer += "T";
        
        if(score['C'-'A']>=score['F'-'A']) answer += "C";
        else answer += "F";
        
        if(score['J'-'A']>=score['M'-'A']) answer += "J";
        else answer += "M";
        
        if(score['A'-'A']>=score['N'-'A']) answer += "A";
        else answer += "N";
        
        return answer;
    }
}
