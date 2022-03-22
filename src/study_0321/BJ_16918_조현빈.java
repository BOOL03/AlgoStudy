package study_0321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16918_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader  br     = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter  bw     = new BufferedWriter( new OutputStreamWriter( System.out ) );
		StringTokenizer st     = new StringTokenizer( br.readLine() );
		int             R      = Integer.parseInt( st.nextToken() );
		int             C      = Integer.parseInt( st.nextToken() );
		int             N      = Integer.parseInt( st.nextToken() );
		int[][][]       map    = new int[R][C][2];
		int             count  = 1;
		boolean[][]     delete = null;

		for ( int i = 0; i < R; i++ ) {
			char[] block = br.readLine().toCharArray();
			for ( int j = 0; j < C; j++ ) {
				if ( block[j] == '.' ) {
					map[i][j][0] = 0;

				} else {
					map[i][j][0] = 1;
					map[i][j][1] = 1;
				}
			}
		}

		while ( count < N ) {
			count++;

			for ( int i = 0; i < R; i++ ) {
				for ( int j = 0; j < C; j++ ) {
					if ( map[i][j][0] == 1 ) {
						map[i][j][1]++;
					}
				}
			}

			if ( ( count & 1 ) == 0 ) {
				for ( int i = 0; i < R; i++ ) {
					for ( int j = 0; j < C; j++ ) {
						if ( map[i][j][0] == 0 ) {
							map[i][j][0] = 1;
							map[i][j][1] = 0;
						}
					}
				}
			} else {
				delete = new boolean[R][C];
				for ( int i = 0; i < R; i++ ) {
					for ( int j = 0; j < C; j++ ) {
						if ( map[i][j][1] == 3 ) {
							delete[i][j] = true;
							if ( i - 1 > -1 ) delete[i - 1][j] = true;
							if ( i + 1 < R ) delete[i + 1][j] = true;
							if ( j - 1 > -1 ) delete[i][j - 1] = true;
							if ( j + 1 < C ) delete[i][j + 1] = true;
						}
					}
				}
				for ( int i = 0; i < R; i++ ) {
					for ( int j = 0; j < C; j++ ) {
						if ( delete[i][j] ) {
							map[i][j][0] = 0;
							map[i][j][1] = 0;
						}
					}
				}
			}
		}

		for ( int i = 0; i < R; i++ ) {
			for ( int j = 0; j < C; j++ ) {
				if ( map[i][j][0] == 0 ) bw.write( '.' );
				else bw.write( 'O' );
			}
			bw.write( "\n" );
		}

		bw.flush();
	}
}
