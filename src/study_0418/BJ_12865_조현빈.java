package study_0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_조현빈 {
	static int     N, K, minWeight;
	static int[][] stuff;

	public static void main( String[] args ) throws IOException {
		init();
		System.out.println( knapsack() );
	}

	public static int knapsack() {
		int[][] dp = new int[N + 1][K + 1];

		for ( int i = 1; i < N + 1; i++ ) {
			for ( int j = 1; j < K + 1; j++ ) {
				int weight = stuff[i][0];
				int value  = stuff[i][1];

				if ( weight > j ) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = Math.max( dp[i - 1][j], value + dp[i - 1][j - weight] );
			}
		}

		return dp[N][K];
	}

	static void init() throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );

		N = Integer.parseInt( st.nextToken() );
		K = Integer.parseInt( st.nextToken() );

		// 0 무게, 1 가치
		stuff     = new int[N + 1][2];
		minWeight = Integer.MAX_VALUE;

		for ( int i = 1; i <= N; i++ ) {
			st          = new StringTokenizer( br.readLine() );
			stuff[i][0] = Integer.parseInt( st.nextToken() );
			stuff[i][1] = Integer.parseInt( st.nextToken() );
			if ( minWeight > stuff[i][0] ) minWeight = stuff[i][0];
		}

		return;
	}
}
