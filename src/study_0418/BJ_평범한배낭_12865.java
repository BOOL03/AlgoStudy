package study_0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_평범한배낭_12865 {
	static int N, K;
	static int[][] item;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[2][K+1];
		item = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken()); // 물건 무게
			item[i][1] = Integer.parseInt(st.nextToken()); // 물건 가치
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(item[i][0] > j) dp[1][j] = dp[0][j]; // 물건 무게 > 버틸 수 있는 무게
				else dp[1][j] = Math.max(dp[0][j], dp[0][j-item[i][0]] + item[i][1]);
			}
			
			for (int j = 1; j <= K; j++) { //복사
				dp[0][j] = dp[1][j];
			}
		}
		System.out.println(dp[1][K]);
	}
}
