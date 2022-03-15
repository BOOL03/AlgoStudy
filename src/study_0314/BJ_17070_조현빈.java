package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader br    = new BufferedReader( new InputStreamReader( System.in ) );
		int            N     = Integer.parseInt( br.readLine() );
		int[][]        arr   = new int[N + 1][N + 1];
		boolean[][]    visit = new boolean[N + 1][N + 1];
		for ( int i = 1; i < N + 1; i++ ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			for ( int j = 1; j < N + 1; j++ ) {
				arr[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		visit[1][1] = true;
		visit[1][2] = true;

		System.out.println( dfs( arr, 1, 2, N, 0, visit, 0 ) );
	}

	static int dfs( int[][] arr, int r, int c, int N, int cnt, boolean[][] visit, int prevIndex ) {

		if ( r == N && c == N ) return 1;
		int   count = 0;
		int[] dy    =
			{
					0, 1, 1
			};
		int[] dx    =
			{
					1, 1, 0
			};

		for ( int i = 0; i < 3; i++ ) {
			// 직각으로 못꺽음
			if ( prevIndex == 0 && i == 2 ) continue;
			if ( prevIndex == 2 && i == 0 ) continue;

			int nr = r + dy[i];
			int nc = c + dx[i];

			// 범위 벗어남
			if ( i == 1 ) {
				if ( nr < 0 || nc < 0 || nr > N || nc > N ) continue;
				if ( nc - 1 > N || nr - 1 > N ) continue;
			} else {
				if ( nr < 0 || nc < 0 || nr > N || nc > N ) continue;
			}

			// 벽
			if ( i == 1 ) {
				if ( arr[nr][nc] == 1 || arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1 ) continue;
			} else {
				if ( arr[nr][nc] == 1 ) continue;
			}

			// 이미 방문한곳
			if ( i == 1 ) {
				if ( visit[nr][nc] || visit[nr][nc - 1] || visit[nr - 1][nc] ) continue;
			} else {
				if ( visit[nr][nc] ) continue;
			}

			// 방문 체크
			if ( i == 1 ) {
				visit[nr][nc]     = true;
				visit[nr][nc - 1] = true;
				visit[nr - 1][nc] = true;
			} else {
				visit[nr][nc] = true;
			}

			count += dfs( arr, nr, nc, N, cnt, visit, i );

			if ( i == 1 ) {
				visit[nr][nc]     = false;
				visit[nr][nc - 1] = false;
				visit[nr - 1][nc] = false;
			} else {
				visit[nr][nc] = false;
			}
		}

		return cnt + count;
	}
}
