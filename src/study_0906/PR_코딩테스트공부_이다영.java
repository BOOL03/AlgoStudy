package study_0906;

import java.util.*;
import java.lang.*;

class PR_코딩테스트공부_이다영 {
    public int solution(int alp, int cop, int[][] problems) {
        int alp_max = 0;
        int cop_max = 0;
        for(int[] problem : problems){
            if(alp_max < problem[0]) alp_max = problem[0];
            if(cop_max < problem[1]) cop_max = problem[1];
        }
        int[][] dp = new int[alp_max+1][cop_max+1];
        for (int[] i : dp) Arrays.fill(i, 15000);
        
        // 초기값이 problems 의 max값 보다 클 수 있음
        alp = Math.min(alp, alp_max);
        cop = Math.min(cop, cop_max);
        dp[alp][cop] = 0;
        
        int len = problems.length;
        
        for(int i = 0; i <= alp_max ; i++){
            for(int j = 0; j <= cop_max ; j++){
                if(i+1 <= alp_max) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j+1 <= cop_max) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] problem : problems){
                    if(i < problem[0] || j < problem[1]) continue;
                    
                    // 범위 넘을 수 있음
                    int alp_next = Math.min(alp_max, i+problem[2]);
                    int cop_next = Math.min(cop_max, j+problem[3]);
                    
                    dp[alp_next][cop_next] = Math.min(dp[alp_next][cop_next], dp[i][j] + problem[4]);
                }
            }
        }
        
        int answer = dp[alp_max][cop_max];
        return answer;
    }                              
}
