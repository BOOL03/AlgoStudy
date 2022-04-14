package study_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Taxi {
	int y, x;

	public Taxi( int y, int x ) {
		this.y = y;
		this.x = x;
	}
}

class Customer {
	int num;
	int sy, sx;
	int ay, ax;

	public Customer( int num, int sy, int sx, int ay, int ax ) {
		super();
		this.num = num;
		this.sy  = sy;
		this.sx  = sx;
		this.ay  = ay;
		this.ax  = ax;
	}
}

public class BJ_19238_조현빈 {
	static int        N, M, G;
	static int[][]    map;
	static Customer[] customer;
	static Taxi       taxi;
	static int[]      dx =
		{
				-1, 0, 1, 0
		};
	static int[]      dy =
		{
				0, 1, 0, -1
		};
	static int        cnt;

	public static void main( String[] args ) throws IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		N        = Integer.parseInt( st.nextToken() );
		M        = Integer.parseInt( st.nextToken() );
		G        = Integer.parseInt( st.nextToken() );
		map      = new int[N + 1][N + 1];
		customer = new Customer[M + 1];

		for ( int i = 1; i <= N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 1; j <= N; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );

				if ( map[i][j] == 1 ) {
					map[i][j] = -1;
				}

			}
		}

		st   = new StringTokenizer( br.readLine() );

		taxi = new Taxi(
				Integer.parseInt( st.nextToken() ),
				Integer.parseInt( st.nextToken() )
		);

		for ( int i = 1; i <= M; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int sy = Integer.parseInt( st.nextToken() );
			int sx = Integer.parseInt( st.nextToken() );
			int ay = Integer.parseInt( st.nextToken() );
			int ax = Integer.parseInt( st.nextToken() );

			customer[i] = new Customer(
					i,
					sy,
					sx,
					ay,
					ax
			);

			map[sy][sx] = i;
		}

		for ( int i = 0; i < M; i++ ) {
			drive();
		}

		System.out.println( cnt == M ? G : -1 );
	}

	private static void drive() {
		int ty = taxi.y;
		int tx = taxi.x;
		if ( map[ty][tx] > 0 ) {
			Customer cur = customer[map[ty][tx]];
			arrive( cur );
			return;
		}

		boolean[][]               visit = new boolean[N + 1][N + 1];

		PriorityQueue< Customer > list  = new PriorityQueue<>( ( c1, c2 ) -> {
																			if ( c1.sy == c2.sy ) {
																				return c1.sx - c2.sx;
																			} else {
																				return c1.sy - c2.sy;
																			}

																		} );
		Deque< Taxi >             q     = new LinkedList<>();
		q.add(
				new Taxi(
						ty,
						tx
				)
		);
		visit[ty][tx] = true;
		int dist = 1;
		while ( !q.isEmpty() ) {
			int len = q.size();
			for ( int i = 0; i < len; i++ ) {
				Taxi cur = q.poll();
				int  y   = cur.y;
				int  x   = cur.x;
				for ( int j = 0; j < 4; j++ ) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if ( nx < 1 || ny < 1 || nx > N || ny > N ) continue;
					if ( map[ny][nx] == -1 ) continue;
					if ( visit[ny][nx] ) continue;
					visit[ny][nx] = true;

					if ( map[ny][nx] == 0 ) {
						q.add(
								new Taxi(
										ny,
										nx
								)
						);
					} else if ( map[ny][nx] > 0 ) {
						list.add( customer[map[ny][nx]] );
					}
				}

			}

			if ( list.size() != 0 ) break;
			dist++;
		}

		if ( list.size() == 0 ) return;
		if ( G - dist < 0 ) return;
		G -= dist;
		arrive( list.poll() );

	}

	private static void arrive( Customer cur ) {

		boolean[][]   visit = new boolean[N + 1][N + 1];
		Queue< Taxi > q     = new LinkedList<>();
		q.add(
				new Taxi(
						cur.sy,
						cur.sx
				)
		);
		map[cur.sy][cur.sx] = 0;

		int cost = 1;
		while ( !q.isEmpty() ) {

			int len = q.size();

			if ( cost > G ) {
				System.out.println( -1 );
				System.exit( 0 );
			}
			for ( int i = 0; i < len; i++ ) {
				Taxi t = q.poll();
				int  y = t.y;
				int  x = t.x;

				for ( int j = 0; j < 4; j++ ) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if ( nx < 1 || ny < 1 || nx > N || ny > N ) continue;
					if ( visit[ny][nx] ) continue;
					if ( map[ny][nx] == -1 ) continue;

					if ( ny == cur.ay && nx == cur.ax ) {
						cnt    += 1;
						taxi.y  = ny;
						taxi.x  = nx;
						G      += cost;
						return;
					} else {
						q.add(
								new Taxi(
										ny,
										nx
								)
						);
						visit[ny][nx] = true;
					}
				}
			}
			cost += 1;
		}
	}
}
