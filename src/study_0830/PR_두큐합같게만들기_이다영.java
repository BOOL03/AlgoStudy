package study_0830;

import java.util.*;

public class PR_두큐합같게만들기_이다영 {
	 static long sum1 = 0;
	    static long sum2 = 0;
	    static long sum = 0;
	    
	    public int solution(int[] queue1, int[] queue2) {
	        int answer = 0;
	        
	        Queue<Integer> copy1 = copy1(queue1);
	        Queue<Integer> copy2 = copy2(queue2);
	        sum = sum1+sum2;
	        int len = queue1.length + queue2.length;
	        
	        if( sum % 2 != 0) return -1;
	        
	        while(true){
	            if(sum1 == sum2) break;
	            
	            while(sum1 > sum2){
	                int num = copy1.poll();
	                sum1 -= num;
	                sum2 += num;
	                copy2.add(num);
	                answer++;
	            }
	            
	            while(sum1 < sum2){
	                int num = copy2.poll();
	                sum2 -= num;
	                sum1 += num;
	                copy1.add(num);
	                answer++;
	            }
	            
	            if(answer > len + 1) return -1;
	        }
	        return answer;
	    }
	    public Queue<Integer> copy1(int[] queue){
	        int len = queue.length;
	        Queue<Integer> copyQ = new LinkedList<>();
	        for(int i = 0; i < len ; i++){
	            copyQ.add(queue[i]);
	            sum1 += queue[i];
	        }
	        return copyQ;
	    }
	    public Queue<Integer> copy2(int[] queue){
	        int len = queue.length;
	        Queue<Integer> copyQ = new LinkedList<>();
	        for(int i = 0; i < len ; i++){
	            copyQ.add(queue[i]);
	            sum2 += queue[i];
	        }
	        return copyQ;
	    }
}
