package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9625_조현빈 {
	public static void main( String[] args ) throws NumberFormatException, IOException {
		int     N  = Integer
				.parseInt( new BufferedReader( new InputStreamReader( System.in ) ).readLine() );
		int[][] dp = new int[N + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for ( int i = 2; i < N + 1; i++ ) {
			dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
			dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
		}

		System.out.println( dp[N][0] + " " + dp[N][1] );
	}
}
