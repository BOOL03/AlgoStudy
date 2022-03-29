package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7571_조현빈 {
	public static void main( String[] args ) throws Exception {

		BufferedReader  br = new BufferedReader(
				new InputStreamReader( System.in )
		);

		StringTokenizer st = new StringTokenizer( br.readLine() );

		int             N  = Integer.parseInt( st.nextToken() );
		int             M  = Integer.parseInt( st.nextToken() );

		int[]           X  = new int[M];
		int[]           Y  = new int[M];

		for ( int i = 0; i < M; i++ ) {
			st   = new StringTokenizer( br.readLine() );
			Y[i] = Integer.parseInt( st.nextToken() );
			X[i] = Integer.parseInt( st.nextToken() );
		}

		Arrays.sort( Y );
		Arrays.sort( X );

		int y   = Y[M / 2];
		int x   = X[M / 2];

		int min = 0;

		for ( int i = 0; i < M; i++ ) {
			min += Math.abs( Y[i] - y );
			min += Math.abs( X[i] - x );
		}

		System.out.println( min );
	}
}
