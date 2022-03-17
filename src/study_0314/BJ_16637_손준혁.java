package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_16637_손준혁 {
	
	static int max = Integer.MIN_VALUE;
	static int N;
	
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub​
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
          
         String t = br.readLine();
         for(int i=0; i<n; i++) {
             if(i%2==0) {
                 nums.add(t.charAt(i)-'0');
             }
             else {
                 ops.add(t.charAt(i));
             }
          }
         N = ops.size();
         DFS(0,nums.get(0));
         System.out.println(max);
	}
	static void DFS(int dp, int sum) {
		if(dp>=N) {
            max = Math.max(max, sum);
            return;
        }
        
        int a = cal(sum, nums.get(dp+1), ops.get(dp));
        DFS(dp+1, a);
        if(dp+1 < N) { 
            int b = cal (nums.get(dp+1), nums.get(dp+2), ops.get(dp+1));
            int result = cal (a, b, ops.get(dp));
            DFS(dp+2, result);
        }
	}
	static int cal(int a, int b, char op) {
		 switch(op) {
	        case '+':
	            return a+b;
	        case '-':
	            return a-b;
	        case '*':
	            return a*b;
	        }
		return 1;
	}
}
