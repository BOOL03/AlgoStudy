package study_0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_이다영 {
	static int[] card;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		card = new int[N+1];
		dp = new int[2][N+1]; // 0행 : 직전까지의 dp, 1행  : 현재행의 최적해
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= N; j++) {
				if(i <= j) {
					dp[1][j] = Math.max(dp[1][j-i]+card[i], dp[0][j]);
				}else dp[1][j] = dp[0][j];
			}
			// copy
			for (int j = 1; j <= N; j++) {
				dp[0][j] = dp[1][j];
			}
		}
		
		System.out.println(dp[1][N]);
	}
}
