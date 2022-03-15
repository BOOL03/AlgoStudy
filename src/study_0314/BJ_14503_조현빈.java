package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_조현빈 {
	static int d;

	public static void main( String[] args ) throws Exception {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int             N  = Integer.parseInt( st.nextToken() );
		int             M  = Integer.parseInt( st.nextToken() );

		st = new StringTokenizer( br.readLine() );
		// 0 북, 1 동, 2 남, 3 서
		int r = Integer.parseInt( st.nextToken() );
		int c = Integer.parseInt( st.nextToken() );

		d = Integer.parseInt( st.nextToken() );

		int[][]     arr   = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < M; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		visit[r][c] = true;
		int   cnt = 1;
		int[] dy  =
			{
					-1, 0, 1, 0
			};
		int[] dx  =
			{
					0, 1, 0, -1
			};

		while ( true ) {
			boolean cleaning = false;

			for ( int i = 0; i < 4; i++ ) {
				// 왼쪽방향 인덱스 조정
				int nr = r + dy[( d + 3 ) % 4];
				int nc = c + dx[( d + 3 ) % 4];

				// 회전
				d = ( d + 3 ) % 4;

				// 범위
				if ( nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 ) continue;

				// 빈칸일때
				if ( arr[nr][nc] == 0 ) {
					// 청소
					if ( !visit[nr][nc] ) {
						visit[nr][nc] = true;
						cnt++;
						r        = nr;
						c        = nc;
						cleaning = true;
						break;
					}
				}
			}

			// 청소 할 곳이 없을때
			if ( !cleaning ) {
				// 뒤가 벽이면 break
				if ( arr[r - dy[d]][c - dx[d]] == 1 ) break;
				else {
					r = r - dy[d];
					c = c - dx[d];
				}
			}
		}
		System.out.println( cnt );
	}
}
