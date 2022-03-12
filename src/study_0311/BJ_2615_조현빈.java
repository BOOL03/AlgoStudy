package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615_조현빈 {
	static int[][] visit  = new int[19][19];
	static int[][] intArr = new int[19][19];
	static int[]   dx     =
		{
				1, 1, 0, -1
		};
	static int[]   dy     =
		{
				0, 1, 1, 1
		};
	static int[]   rdx    =
		{
				-1, -1, 0, 1
		};
	static int[]   rdy    =
		{
				0, -1, -1, -1
		};

	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		for ( int i = 0; i < intArr.length; i++ ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < intArr[i].length; j++ ) {
				intArr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		boolean flag = false;

		breakPoint : for ( int i = 0; i < intArr.length; i++ ) {
			for ( int j = 0; j < intArr[i].length; j++ ) {
				if ( intArr[i][j] == 0 ) continue;
				for ( int k = 0; k < 4; k++ ) {
					int depth = rdfs( i, j, k );
					if ( dfs( i, j, k, depth ) ) {
						System.out.println( intArr[i][j] );
						if ( k == 3 ) {
							System.out.println( ( i + 1 + 4 ) + " " + ( j + 1 - 4 ) );
						} else {
							System.out.println( ( i + 1 ) + " " + ( j + 1 ) );
						}
						flag = true;
						break breakPoint;
					}
				}
			}
		}

		if ( !flag ) {
			System.out.println( 0 );
		}
	}

	public static int rdfs( int i, int j, int dir ) {
		int result = 0;
		try {
			if ( intArr[i + rdy[dir]][j + rdx[dir]] == intArr[i][j] ) {
				result = 1 + rdfs( i + rdy[dir], j + rdx[dir], dir );
			} else {
				return 1;
			}
		}
		catch ( Exception e ) {
			return 1;
		}
		return result;
	}

	public static boolean dfs( int i, int j, int dir, int depth ) {
		boolean result = false;
		try {
			if ( intArr[i][j] == intArr[i + dy[dir]][j + dx[dir]] ) {
				if ( depth == 5 ) {
					return false;
				}
				result = dfs( i + dy[dir], j + dx[dir], dir, depth + 1 );
			} else {
				if ( depth == 5 ) {
					return true;
				}
				return false;
			}
		}
		catch ( Exception e ) {
			if ( depth == 5 ) {
				return true;
			}
			return false;
		}
		return result;
	}
}
