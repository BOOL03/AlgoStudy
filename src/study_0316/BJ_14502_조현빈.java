package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_조현빈 {
	static int                N;
	static int                M;
	static int[][]            map;
	static int                zeroCount;
	static ArrayList< int[] > virus;
	static int                max;

	public static void main( String[] args ) throws Exception {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N         = Integer.parseInt( st.nextToken() );
		M         = Integer.parseInt( st.nextToken() );
		map       = new int[N][M];
		zeroCount = -3;
		virus     = new ArrayList< int[] >();
		max       = -1;

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < M; j++ ) {
				int temp = Integer.parseInt( st.nextToken() );
				if ( temp == 0 ) zeroCount++;
				else if ( temp == 2 ) virus.add( new int[]
					{
							i, j
					} );

				map[i][j] = temp;
			}
		}
		makeWall( 0 );
		System.out.println( max - 1 );
	}

	static void makeWall( int depth ) {
		if ( depth == 3 ) {
			bfs();
			return;
		}
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < M; j++ ) {
				if ( map[i][j] == 0 ) {
					map[i][j] = 1;
					makeWall( depth + 1 );
					map[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		Queue< int[] > q     = new LinkedList< int[] >();
		boolean[][]    visit = new boolean[N][M];
		int            count = -1;
		int[]          dy    =
			{
					-1, 0, 1, 0
			};
		int[]          dx    =
			{
					0, 1, 0, -1
			};

		for ( int i = 0; i < virus.size(); i++ ) {

			q.offer( new int[]
				{
						virus.get( i )[0], virus.get( i )[1]
				} );

			while ( !q.isEmpty() ) {
				int[] temp = q.poll();

				for ( int j = 0; j < 4; j++ ) {
					int ny = temp[0] + dy[j];
					int nx = temp[1] + dx[j];
					if ( ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 ) continue;
					if ( visit[ny][nx] || map[ny][nx] != 0 ) continue;
					visit[ny][nx] = true;
					count++;
					q.offer( new int[]
						{
								ny, nx
						} );
				}
			}
		}
		max = Math.max( max, zeroCount - count );
	}
}
