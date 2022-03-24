package study_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780_조현빈 {

	static int[][] paper  = null;
	static int[]   answer = null;

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader(
				new InputStreamReader( System.in )
		);
		StringTokenizer st = null;
		int             N  = Integer.parseInt( br.readLine() );

		paper = new int[N + 1][N + 1];

		// -1, 0, 1
		answer = new int[3];
		for ( int i = 1; i <= N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 1; j <= N; j++ ) {
				paper[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		divideAndConquer( 1, 1, N );
		for ( int ans : answer ) {
			System.out.println( ans );
		}

	}

	public static void divideAndConquer( int row, int col, int len ) {

		int     num  = paper[row][col];
		boolean flag = true;
		breakPoint : for ( int i = row; i < row + len; i++ ) {
			for ( int j = col; j < col + len; j++ ) {
				if ( paper[i][j] != num ) {
					flag = false;
					break breakPoint;
				}
			}
		}
		if ( flag ) {
			answer[num + 1] += 1;
			return;
		}
		int nextLen = len / 3;
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 0; j < 3; j++ ) {
				divideAndConquer( row + i * nextLen, col + j * nextLen, nextLen );
			}
		}
	}
}
