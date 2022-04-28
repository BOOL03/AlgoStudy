package study_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_2573_조현빈 {
	static int     N, M, cnt, year;
	static int[]   dy, dx;
	static int[][] map;
	static boolean noland;

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
				if ( map[i][j] != 0 ) {
					noland = true;
				}
			}
		}
		if ( !noland ) {
			System.out.println( 0 );
			System.exit( 0 );
		}

		cnt = 0;
		dy  = new int[]
			{
					-1, 0, 1, 0
			};
		dx  = new int[]
			{
					0, 1, 0, -1
			};
		while ( true ) {
			year++;
			melting();
			boolean[][] visited = new boolean[N][M];
			cnt = 0;
			for ( int i = 0; i < N; i++ ) {
				for ( int j = 0; j < M; j++ ) {
					if ( map[i][j] != 0 && !visited[i][j] ) {
						dfs( i, j, visited );
						cnt++;
						if ( cnt >= 2 ) {
							System.out.println( year );
							System.exit( 0 );
						}
					}
				}
			}
			if ( cnt == 0 ) {
				System.out.println( 0 );
				System.exit( 0 );
			}
		}
	}

	static void dfs( int y, int x, boolean[][] visited ) {
		visited[y][x] = true;

		int ny, nx;
		for ( int i = 0; i < 4; i++ ) {
			ny = y + dy[i];
			nx = x + dx[i];

			if ( ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 ) continue;
			if ( map[ny][nx] != 0 && !visited[ny][nx] ) dfs( ny, nx, visited );
		}
	}

	static void melting() {
		boolean[][]    isOcean = new boolean[N][M];
		Deque< int[] > dq      = new ArrayDeque<>();

		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < M; j++ ) {
				if ( map[i][j] == 0 ) {
					isOcean[i][j] = true;
				} else {
					dq.offerLast( new int[]
						{
								i, j
						} );
				}
			}
		}

		while ( !dq.isEmpty() ) {
			int[] coord = dq.poll();
			int   y     = coord[0];
			int   x     = coord[1];
			int   ocean = 0;
			if ( map[y][x] == 0 ) continue;

			for ( int k = 0; k < 4; k++ ) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if ( ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 ) continue;
				if ( !isOcean[ny][nx] ) continue;
				if ( map[ny][nx] != 0 ) continue;

				ocean++;

			}
			int num = map[y][x] - ocean;
			map[y][x] = num <= 0 ? 0 : num;
		}

	}
}
