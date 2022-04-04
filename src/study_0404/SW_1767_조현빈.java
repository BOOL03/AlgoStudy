package study_0404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coordinate {
	int     y;
	int     x;
	boolean check;

	public Coordinate( int y, int x ) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class SW_1767_조현빈 {
	static int                     T, N, minLine, maxCore;
	static int[][]                 arr;
	static ArrayList< Coordinate > arrayList;
	static int[]                   dy =
		{
				-1, 0, 1, 0
		};
	static int[]                   dx =
		{
				0, 1, 0, -1
		};

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter  bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		StringTokenizer st = null;
		T = Integer.parseInt( br.readLine() );

		for ( int t = 1; t <= T; t++ ) {
			N         = Integer.parseInt( br.readLine() );
			arr       = new int[N][N];
			minLine   = Character.MAX_VALUE;
			maxCore   = 0;
			arrayList = new ArrayList< Coordinate >();

			for ( int i = 0; i < N; i++ ) {
				st = new StringTokenizer( br.readLine() );
				for ( int j = 0; j < N; j++ ) {
					arr[i][j] = Integer.parseInt( st.nextToken() );
					if ( i != 0 && j != 0 && i != N - 1 && j != N - 1 && arr[i][j] == 1 ) {
						arrayList.add(
								new Coordinate(
										i,
										j
								)
						);
					}
				}
			}

			dfs( 0, 0, 0 );

			bw.write( String.format( "#%d %d\n", t, minLine ) );
		}

		bw.flush();
	}

	static void dfs( int index, int coreCount, int lineCount ) {
		if ( index == arrayList.size() ) {
			if ( maxCore < coreCount ) {
				maxCore = coreCount;
				minLine = lineCount;
			} else if ( maxCore == coreCount ) {
				minLine = Math.min( minLine, lineCount );
			}
			return;
		}

		// 연결하는 경우
		int y = arrayList.get( index ).y;
		int x = arrayList.get( index ).x;
		for ( int i = 0; i < 4; i++ ) {
			int     ty   = y;
			int     tx   = x;
			int     ny   = 0;
			int     nx   = 0;
			boolean flag = false;
			while ( true ) {
				ny = ty + dy[i];
				nx = tx + dx[i];
				if ( ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1 ) {
					break;
				}
				if ( arr[ny][nx] != 0 ) {
					flag = true;
					break;
				}
				ty = ny;
				tx = nx;
			}

			if ( flag ) continue;

			ty = y;
			tx = x;
			ny = 0;
			nx = 0;
			int cnt = 0;
			while ( true ) {
				ny = ty + dy[i];
				nx = tx + dx[i];
				if ( ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1 ) {
					ty = ny;
					tx = nx;
					break;
				}
				cnt++;
				arr[ny][nx] = 2;
				ty          = ny;
				tx          = nx;
			}
			dfs( index + 1, coreCount + 1, lineCount + cnt );
			while ( true ) {
				ny = ty - dy[i];
				nx = tx - dx[i];
				if ( ny == y && nx == x ) {
					break;
				}
				arr[ny][nx] = 0;
				ty          = ny;
				tx          = nx;
			}
		}

		// 연결안하는 경우
		dfs( index + 1, coreCount, lineCount );
	}
}
