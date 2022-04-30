package study_0429;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_14499_조현빈 {
	static int            N, M, x, y, k;
	static int[][]        map;
	static int[]          dice = new int[7];
	static BufferedWriter bw;

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );

		N   = Integer.parseInt( st.nextToken() );
		M   = Integer.parseInt( st.nextToken() );
		x   = Integer.parseInt( st.nextToken() ) + 1;
		y   = Integer.parseInt( st.nextToken() ) + 1;
		k   = Integer.parseInt( st.nextToken() );

		map = new int[N + 1][M + 1];

		for ( int i = 1; i <= N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 1; j <= M; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		st = new StringTokenizer( br.readLine() );

		int[] command = new int[k];

		for ( int i = 0; i < k; i++ ) {
			command[i] = Integer.parseInt( st.nextToken() );
		}

		for ( int i = 0; i < k; i++ ) {
			moveDice( command[i] );
		}

		bw.flush();

	}

	static void moveDice( int order ) throws IOException {
		// 주사위 굴리기
		int temp;
		switch ( order ) {
			case 1:
				if ( y + 1 < M + 1 ) {
					temp     = dice[5];
					dice[5]  = dice[3];
					dice[3]  = dice[6];
					dice[6]  = dice[1];
					dice[1]  = temp;
					y       += 1;
					check();
					bw.write( String.format( "%d\n", dice[1] ) );
				}
				break;
			case 2:
				if ( y - 1 > 0 ) {
					temp     = dice[1];
					dice[1]  = dice[6];
					dice[6]  = dice[3];
					dice[3]  = dice[5];
					dice[5]  = temp;
					y       -= 1;
					check();
					bw.write( String.format( "%d\n", dice[1] ) );
				}
				break;
			case 3:
				if ( x - 1 > 0 ) {
					temp     = dice[1];
					dice[1]  = dice[2];
					dice[2]  = dice[3];
					dice[3]  = dice[4];
					dice[4]  = temp;
					x       -= 1;
					check();
					bw.write( String.format( "%d\n", dice[1] ) );
				}
				break;
			case 4:
				if ( x + 1 < N + 1 ) {
					temp     = dice[1];
					dice[1]  = dice[4];
					dice[4]  = dice[3];
					dice[3]  = dice[2];
					dice[2]  = temp;
					x       += 1;
					check();
					bw.write( String.format( "%d\n", dice[1] ) );
				}
				break;
		}
	}

	static void check() {
		if ( map[x][y] == 0 ) map[x][y] = dice[3];
		else {
			dice[3]   = map[x][y];
			map[x][y] = 0;
		}
	}
}
