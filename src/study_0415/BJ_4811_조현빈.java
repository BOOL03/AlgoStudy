package study_0415;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_4811_조현빈 {

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		int            N;
		long[][]       dp = new long[31][62];

		for ( int i = 0; i < 2; i++ ) {
			dp[0][i] = 1;
		}

		for ( int i = 0; i < 31; i++ ) {
			dp[i][0] = 1;
		}

		while ( ( N = Integer.parseInt( br.readLine() ) ) != 0 ) {
			int y = N - 1;
			int x = N;

			if ( dp[y][x] != 0 ) {
				bw.write( String.format( "%d\n", dp[y][x] ) );
				continue;
			}

			for ( int i = 1; i < N; i++ ) {
				for ( int j = 1; j <= i + 1; j++ ) {
					if ( dp[i][j] != 0 ) continue;
					if ( dp[i][j] == 0 ) {
						if ( dp[i - 1][j] == 0 ) {
							dp[i][j] = dp[i][j - 1];
							break;
						} else {
							dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
						}
					}
				}
			}
			bw.write( String.format( "%d\n", dp[y][x] ) );
		}
		bw.flush();
	}
}
