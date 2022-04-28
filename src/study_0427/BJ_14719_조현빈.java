package study_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_조현빈 {
	public static void main( String[] args ) throws IOException {
		BufferedReader  br  = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st  = new StringTokenizer( br.readLine() );
		int             H   = Integer.parseInt( st.nextToken() );
		int             W   = Integer.parseInt( st.nextToken() );
		int[][]         map = new int[H][W];

		st = new StringTokenizer( br.readLine() );
		for ( int i = 0; i < W; i++ ) {
			int num = Integer.parseInt( st.nextToken() );
			for ( int j = H - 1; j > H - 1 - num; j-- ) {
				map[j][i] = 1;
			}
		}

		int cnt = 0;

		for ( int i = 0; i < H; i++ ) {
			int start = -1;
			for ( int j = 0; j < W; j++ ) {
				if ( map[i][j] == 1 ) {
					if ( start != -1 ) {
						cnt += j - start - 1;
					}
					start = j;
				}
			}
		}

		System.out.println( cnt );
	}
}
