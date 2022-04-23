package study_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_14442_조현빈 {
	static int            N, M, K, min;
	static int[]          dy, dx;
	static int[][]        map;
	static boolean[][][]  visit;
	static Deque< int[] > dq;

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N     = Integer.parseInt( st.nextToken() );
		M     = Integer.parseInt( st.nextToken() );
		K     = Integer.parseInt( st.nextToken() );
		map   = new int[N + 1][M + 1];
		visit = new boolean[K + 1][N + 1][M + 1];
		dq    = new ArrayDeque< int[] >();
		min   = N * M + 1;

		if ( N == 1 && M == 1 ) {
			System.out.println( 1 );
			System.exit( 0 );
		}

		dy = new int[]
			{
					-1, 0, 1, 0
			};
		dx = new int[]
			{
					0, 1, 0, -1
			};

		for ( int i = 1; i <= N; i++ ) {
			String tmp = br.readLine();
			for ( int j = 1; j <= M; j++ ) {
				map[i][j] = Integer.parseInt( String.valueOf( tmp.charAt( j - 1 ) ) );
			}
		}

		dq.offerLast( new int[]
			{
					1, 1, 0, 0
			} ); // y, x, k, cnt
		for ( int i = 0; i <= K; i++ ) {
			visit[i][1][1] = true;
		}

		while ( !dq.isEmpty() ) {
			int[] arr = dq.pollFirst();
			int   y   = arr[0];
			int   x   = arr[1];
			int   cnt = arr[2];
			int   k   = arr[3];

			for ( int i = 0; i < 4; i++ ) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if ( ny < 1 || nx < 1 || ny > N || nx > M ) continue;
				if ( cnt + 1 >= min ) continue;

				if ( map[ny][nx] == 0 ) {
					if ( visit[k][ny][nx] ) continue;
					if ( ny == N && nx == M ) {
						min = Math.min( cnt + 2, min );
					} else {
						dq.offerLast( new int[]
							{
									ny, nx, cnt + 1, k
							} );
					}
					visit[k][ny][nx] = true;
				} else {
					if ( k + 1 <= K ) {
						if ( visit[k + 1][ny][nx] ) continue;
						if ( ny == N && nx == M ) {
							min = Math.min( cnt + 2, min );
						} else {
							dq.offerLast( new int[]
								{
										ny, nx, cnt + 1, k + 1
								} );
						}
						visit[k + 1][ny][nx] = true;
					}
				}
			}
		}

		System.out.println( min == N * M + 1 ? -1 : min );
	}
}
