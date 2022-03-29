package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5904_조현빈 {
	static int     curIndex = 0;
	static int     N        = 0;
	static boolean flag     = false;
	static char    curChar  = 'A';

	public static void main( String[] args ) throws Exception {
		N = Integer.parseInt(
				( new BufferedReader( new InputStreamReader( System.in ) ).readLine() )
		);

		int length        = 3;
		int nextMooLength = 4;
		int k             = 0;

		while ( true ) {
			int newLength = ( length * 2 ) + nextMooLength;
			length = newLength;
			k++;
			if ( length >= N ) {
				break;
			}
			nextMooLength++;
		}

		dfs( k );
		System.out.println( curChar );
	}

	static void dfs( int k ) {
		if ( k == -1 ) return;
		if ( flag ) return;

		dfs( k - 1 );
		if ( curIndex + k + 2 + 1 >= N ) {
			for ( int i = 1; i <= k + 2 + 1; i++ ) {
				if ( curIndex + i == N ) {
					if ( i == 1 ) curChar = 'm';
					else curChar = 'o';
					flag = true;
					return;
				}
			}
		} else {
			curIndex += k + 2 + 1;
		}
		dfs( k - 1 );
		return;
	}
}
