package study_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_15787_조현빈 {
	public static void main( String[] args ) throws IOException {
		BufferedReader     br     = new BufferedReader(
				new InputStreamReader( System.in )
		);
		StringTokenizer    st     = new StringTokenizer( br.readLine() );
		int                N      = Integer.parseInt( st.nextToken() );
		int                M      = Integer.parseInt( st.nextToken() );
		int[]              trains = new int[N + 1];
		HashSet< Integer > set    = new HashSet< Integer >();
		for ( int m = 0; m < M; m++ ) {
			st = new StringTokenizer( br.readLine() );
			int oper     = Integer.parseInt( st.nextToken() );
			int trainNum = Integer.parseInt( st.nextToken() );
			int seat     = 0;
			if ( oper == 1 || oper == 2 ) {
				seat = Integer.parseInt( st.nextToken() );
			}

			switch ( oper ) {
				case 1:
					trains[trainNum] = trains[trainNum] | ( 1 << seat );
					break;
				case 2:
					trains[trainNum] &= ~( 1 << seat );
					break;
				case 3:
					trains[trainNum] = trains[trainNum] << 1;
					trains[trainNum] &= ( 1 << 21 ) - 1;
					break;
				case 4:
					trains[trainNum] = trains[trainNum] >> 1;
					trains[trainNum] &= ~1;
					break;
			}
		}

		for ( int i = 1; i < N + 1; i++ ) {
			set.add( trains[i] );
		}

		System.out.println( set.size() );
	}
}
