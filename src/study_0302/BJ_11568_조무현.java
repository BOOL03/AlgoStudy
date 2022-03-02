package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11568_조무현 {
	static int N;
	static long[] num;
	static int[] dp;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new long[N];
		dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}			
			
			ans = Math.max(ans, dp[i]);
		}
		
		
		System.out.println(ans);			
		
	}

}
