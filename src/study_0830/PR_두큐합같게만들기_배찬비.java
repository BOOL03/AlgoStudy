package study_0830;

import java.util.*;

class PR_두큐합같게만들기_배찬비 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Integer> Q1 = new ArrayDeque<>();
        Queue<Integer> Q2 = new ArrayDeque<>();
        
        long total = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i : queue1){
            total += i;
            sum1 += i;
            Q1.offer(i);
        }
        for(int i : queue2){
            total += i;
            sum2 += i;
            Q2.offer(i);
        }
        
        long middle = total/2;
        int cnt1 = 0;
        while(cnt1<queue1.length*3){
            if(sum1==middle) break;
            else if(sum1<middle){
                sum1 += Q2.peek();
                Q1.offer(Q2.poll());
            } else{
                sum1 -= Q1.peek();
                Q2.offer(Q1.poll());
            }
            cnt1++;
        }
        
        if(cnt1!=queue1.length*3) answer = cnt1;
        
        return answer;
    }
}
