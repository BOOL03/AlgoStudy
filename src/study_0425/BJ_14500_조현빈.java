package study_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_조현빈 {
	static int       N, M;
	static int[][]   map;
	static int[][][] dy =
		{
				{
						{
								0, 0, 0, 0
						},
						{
								0, 1, 2, 3
						},
				},
				{
						{
								0, 0, 1, 1
						}
				},
				{
						{
								0, 1, 2, 2
						},
						{
								0, 0, 0, 1
						},
						{
								0, 0, 1, 2
						},
						{
								0, 1, 1, 1
						},
						{
								0, 1, 2, 2
						},
						{
								0, 0, 0, 1
						},
						{
								0, 0, 1, 2
						},
						{
								0, 1, 1, 1
						}
				},
				{
						{
								0, 1, 1, 2
						},
						{
								0, 0, 1, 1
						},
						{
								0, 1, 1, 2
						},
						{
								0, 0, 1, 1
						}
				},
				{
						{
								0, 0, 0, 1
						},
						{
								0, 1, 1, 2
						},
						{
								0, 1, 1, 1
						},
						{
								0, 1, 1, 2
						}
				}
		};
	static int[][][] dx =
		{
				{
						{
								0, 1, 2, 3
						},
						{
								0, 0, 0, 0
						}
				},
				{
						{
								0, 1, 0, 1
						}
				},
				{
						{
								0, 0, 0, 1
						},
						{
								0, 1, 2, 0
						},
						{
								0, 1, 1, 1
						},
						{
								0, 0, -1, -2
						},
						{
								0, 0, 0, -1
						},
						{
								0, 1, 2, 2
						},
						{
								0, 1, 0, 0
						},
						{
								0, 0, 1, 2
						}
				},
				{
						{
								0, 0, 1, 1
						},
						{
								0, 1, -1, 0
						},
						{
								0, 0, -1, -1
						},
						{
								0, 1, 1, 2
						}
				},
				{
						{
								0, 1, 2, 1
						},
						{
								0, -1, 0, 0
						},
						{
								0, -1, 0, 1
						},
						{
								0, 0, 1, 0
						}
				}
		};

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N   = Integer.parseInt( st.nextToken() );
		M   = Integer.parseInt( st.nextToken() );

		map = new int[N][M];

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < M; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		int y   = 0;
		int x   = 0;
		int ny  = 0;
		int nx  = 0;
		int max = Integer.MIN_VALUE;
		while ( true ) {
			int     sum  = 0;
			boolean flag = true;
			for ( int i = 0; i < 5; i++ ) {
				int limit = 4;
				if ( i == 0 ) limit = 2;
				else if ( i == 1 ) limit = 1;
				else if ( i == 2 ) limit = 8;
				for ( int j = 0; j < limit; j++ ) {
					sum  = 0;
					flag = true;
					for ( int k = 0; k < 4; k++ ) {
						ny = y + dy[i][j][k];
						nx = x + dx[i][j][k];
						if ( ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 ) {
							flag = false;
							break;
						}
						sum += map[ny][nx];
					}
					if ( flag ) {
						max = Math.max( max, sum );
					}
				}
			}
			if ( y == N - 1 && x == M - 1 ) break;

			x += 1;
			if ( x == M ) {
				y += 1;
				x  = 0;
			}
		}
		System.out.println( max );
	}
}
