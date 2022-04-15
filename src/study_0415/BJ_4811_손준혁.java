package study_0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4811_손준혁 {
	static long[] dp = new long[31];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			for (int i = 3; i <= n; i++) {
				long count = 0;

				for (int j = 0; j < i; j++) {
					count += dp[j] * dp[i - 1 - j];
				}

				dp[i] = count;
			}
			System.out.println(dp[n]);
		}
	}

}
