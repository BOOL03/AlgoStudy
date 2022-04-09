package study_0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SW_2382_조현빈 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int            T, N, M, K;
	static int[][][]      microbes, newMicrobes;
	static int[]          dy, dx;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		init();
		for ( int t = 1; t <= T; t++ ) {
			bfs();
			int sum = 0;
			for ( int i = 0; i < N; i++ ) {
				for ( int j = 0; j < N; j++ ) {
					if ( microbes[i][j][0] != 0 ) {
						sum += microbes[i][j][0];
					}
				}
			}

			bw.write( String.format( "#%d %d\n", t, sum ) );
		}
		bw.flush();
	}

	static void bfs() {
		int                 time = 0;
		ArrayDeque< int[] > dq   = new ArrayDeque< int[] >();

		while ( time <= M ) {

			for ( int i = 0; i < N; i++ ) {
				for ( int j = 0; j < N; j++ ) {
					if ( microbes[i][j][0] != 0 ) {
						dq.offerLast( new int[]
							{
									i, j
							} );
					}
				}
			}

			while ( !dq.isEmpty() ) {
				getCopy();

				int[] microbe = dq.pollFirst();
				int   y       = microbe[0];
				int   x       = microbe[1];
				int   num     = microbes[y][x][0];
				int   dir     = microbes[y][x][1];
				int   ny      = y + dy[dir - 1];
				int   nx      = x + dx[dir - 1];

				if ( ny == 0 || ny == N - 1 || nx == 0 || nx == N - 1 ) {
					if ( dir == 1 ) dir = 2;
					if ( dir == 2 ) dir = 1;
					if ( dir == 3 ) dir = 4;
					if ( dir == 4 ) dir = 3;
					num = num / 2;
				}
				newMicrobes[ny][nx][0] += num;

				if ( newMicrobes[ny][nx][1] != 0 ) {
					int prevY   = newMicrobes[ny][nx][2];
					int prevX   = newMicrobes[ny][nx][3];
					int prevNum = microbes[prevY][prevX][0];
					int prevDir = microbes[prevY][prevX][1];

					if ( num > prevNum ) {
						newMicrobes[ny][nx][1] = dir;
						newMicrobes[ny][nx][2] = y;
						newMicrobes[ny][nx][3] = x;
					} else {
						newMicrobes[ny][nx][1] = prevDir;
						newMicrobes[ny][nx][2] = prevY;
						newMicrobes[ny][nx][3] = prevX;
					}
				} else {
					newMicrobes[ny][nx][1] = dir;
					newMicrobes[ny][nx][2] = y;
					newMicrobes[ny][nx][3] = x;
				}
			}

			applyChange();

			time++;
		}
	}

	static void applyChange() {
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ ) {
				microbes[i][j][0] = newMicrobes[i][j][0];
				microbes[i][j][1] = newMicrobes[i][j][1];
			}
		}
	}

	static void getCopy() {
		newMicrobes = new int[N][N][4];
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ ) {
				if ( newMicrobes[i][j][0] == 0 ) continue;

				newMicrobes[i][j][0] = microbes[i][j][0];
				newMicrobes[i][j][1] = microbes[i][j][1];
			}
		}
	}

	static void init() throws NumberFormatException, IOException {
		if ( br == null ) {
			br = new BufferedReader( new InputStreamReader( System.in ) );
			bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
			T  = Integer.parseInt( br.readLine() );
		}

		StringTokenizer st = new StringTokenizer( br.readLine() );
		N        = Integer.parseInt( st.nextToken() );
		M        = Integer.parseInt( st.nextToken() );
		K        = Integer.parseInt( st.nextToken() );

		microbes = new int[N][N][2];

		for ( int k = 0; k < K; k++ ) {
			st = new StringTokenizer( br.readLine() );
			int y   = Integer.parseInt( st.nextToken() );
			int x   = Integer.parseInt( st.nextToken() );
			int num = Integer.parseInt( st.nextToken() );
			int dir = Integer.parseInt( st.nextToken() );
			microbes[y][x][0] = num;
			microbes[y][x][1] = dir;
		}

		dy = new int[]
			{
					-1, 1, 0, 0
			};
		dx = new int[]
			{
					0, 0, -1, 1
			};
	}
}
