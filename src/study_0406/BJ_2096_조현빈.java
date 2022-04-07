package study_0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096_조현빈 {
	static BufferedReader br;
	static int            N;
	static int[][]        map;
	static int[][][]      dp; // 0 최소 1 최대
	static int[]          dx;
	static int            min;
	static int            max;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		init();

		findMinMax( fillArray() );

		System.out.println( max + " " + min );
	}

	static void findMinMax( int lastIndex ) {
		for ( int i = 0; i < 3; i++ ) {
			min = Math.min( min, dp[lastIndex][i][0] );
			max = Math.max( max, dp[lastIndex][i][1] );
		}
		return;
	}

	static int fillArray() {
		int nx    = 0;
		int index = 0;
		for ( int i = 1; i < N; i++ ) {
			index = i & 1;
			for ( int j = 0; j < 3; j++ ) {
				for ( int k = 0; k < 3; k++ ) {
					nx = j + dx[k];
					if ( nx < 0 || nx > 2 ) continue;

					// 최소값
					dp[index][j][0] = Math.min( dp[index][j][0], map[i][j] + dp[index ^ 1][nx][0] );

					// 최대값
					dp[index][j][1] = Math.max( dp[index][j][1], map[i][j] + dp[index ^ 1][nx][1] );
				}
			}
			for ( int j = 0; j < 3; j++ ) {
				dp[index ^ 1][j][0] = Integer.MAX_VALUE;
				dp[index ^ 1][j][1] = Integer.MIN_VALUE;
			}
		}
		return index;
	}

	static void init() throws NumberFormatException, IOException {
		StringTokenizer st = null;

		br  = new BufferedReader( new InputStreamReader( System.in ) );
		N   = Integer.parseInt( br.readLine() );
		map = new int[N][3];
		dp  = new int[2][3][2];
		dx  = new int[]
			{
					-1, 0, 1
			};
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < 3; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		// dp 배열 초기화
		for ( int i = 0; i < 2; i++ ) {
			for ( int j = 0; j < 3; j++ ) {
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MIN_VALUE;
			}
		}

		// 초기값 다 채워줌
		for ( int i = 0; i < 3; i++ ) {
			dp[0][i][0] = map[0][i];
			dp[0][i][1] = map[0][i];
		}

		br.close();

		return;
	}
}
