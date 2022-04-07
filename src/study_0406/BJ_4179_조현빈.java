package study_0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Coord {
	int     y;
	int     x;
	boolean isJihun;
	int     count;

	public Coord( int y, int x, boolean isJihun, int count ) {
		super();
		this.y       = y;
		this.x       = x;
		this.isJihun = isJihun;
		this.count   = count;
	}
}

public class BJ_4179_조현빈 {
	static int            R;
	static int            C;
	static char[][]       map;
	static Deque< Coord > dq;
	static int[]          dy;
	static int[]          dx;

	public static void main( String[] args ) throws IOException {
		init();
		bfs();
	}

	static void bfs() {
		boolean flag = false;

		breakPoint : while ( !dq.isEmpty() ) {
			Coord coord = dq.pollFirst();

			if ( coord.isJihun && map[coord.y][coord.x] == 'F' ) continue;

			for ( int i = 0; i < 4; i++ ) {
				int ny = coord.y + dy[i];
				int nx = coord.x + dx[i];

				if ( ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1 ) {
					if ( coord.isJihun ) {
						System.out.println( coord.count + 1 );
						flag = true;
						break breakPoint;
					}

					continue;
				}

				if ( map[ny][nx] == '#' || map[ny][nx] == 'F' ) continue;
				if ( coord.isJihun && map[ny][nx] == '.' ) {
					map[ny][nx] = 'J';
					dq.offerLast(
							new Coord(
									ny,
									nx,
									true,
									coord.count + 1
							)
					);
				}

				if ( !coord.isJihun ) {
					map[ny][nx] = 'F';
					dq.offerLast(
							new Coord(
									ny,
									nx,
									false,
									coord.count + 1
							)
					);
				}

			}
		}

		if ( !flag ) {
			System.out.println( "IMPOSSIBLE" );
		}
		return;
	}

	static void init() throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );

		R   = Integer.parseInt( st.nextToken() );
		C   = Integer.parseInt( st.nextToken() );

		map = new char[R][C];
		dq  = new ArrayDeque<>();

		dy  = new int[]
			{
					-1, 0, 1, 0
			};
		dx  = new int[]
			{
					0, 1, 0, -1
			};

		for ( int i = 0; i < R; i++ ) {
			map[i] = br.readLine().toCharArray();
			if ( dq.size() == 0 ) {
				for ( int j = 0; j < C; j++ ) {
					if ( map[i][j] == 'J' ) {
						dq.add(
								new Coord(
										i,
										j,
										true,
										0
								)
						);
					}
				}
			}
		}

		for ( int i = 0; i < R; i++ ) {
			for ( int j = 0; j < C; j++ ) {
				if ( map[i][j] == 'F' ) {
					dq.add(
							new Coord(
									i,
									j,
									false,
									0
							)
					);
				}
			}
		}

		br.close();

		return;
	}
}
