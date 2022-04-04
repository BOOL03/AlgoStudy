package study_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2565_조현빈 {

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br  = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st  = null;
		int             N   = Integer.parseInt( br.readLine() );
		int[][]         pp  = new int[N][2];
		int[]           LIS = new int[N];
		int             len = 0;

		for ( int i = 0; i < N; i++ ) {
			st       = new StringTokenizer( br.readLine() );
			pp[i][0] = Integer.parseInt( st.nextToken() );
			pp[i][1] = Integer.parseInt( st.nextToken() );
		}

		Arrays.sort( pp, ( e1, e2 ) -> Integer.compare( e1[0], e2[0] ) );

		for ( int i = 0; i < N; i++ ) {
			int position = Math.abs( Arrays.binarySearch( LIS, 0, len, pp[i][1] ) ) - 1;

			LIS[position] = pp[i][1];

			if ( len == position ) len++;
		}

		System.out.println( N - len );
	}
}
