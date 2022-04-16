package study_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_조현빈 {

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br    = new BufferedReader( new InputStreamReader( System.in ) );
		int             N     = Integer.parseInt( br.readLine() );
		int[]           cards = new int[N + 1], dp = new int[N + 1];
		StringTokenizer st    = new StringTokenizer( br.readLine() );

		for ( int i = 1; i <= N; i++ ) {
			cards[i] = Integer.parseInt( st.nextToken() );
		}

		for ( int i = 1; i <= N; i++ ) {
			dp[i] = dp[i - 1] + cards[1];
		}

		for ( int i = 2; i <= N; i++ ) {
			for ( int j = i; j <= N; j++ ) {
				dp[j] = Math.max( dp[j - i] + cards[i], dp[j] );
			}
		}

		System.out.println( dp[N] );

	}
}
