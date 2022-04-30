package study_0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12100_조현빈 {
	static int     N, max;
	static int[][] map;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		N   = Integer.parseInt( br.readLine() );
		map = new int[N][N];
		max = -1;

		for ( int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < N; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}

		dfs( 0, map );

		System.out.println( max );
	}

	static void dfs( int depth, int[][] newMap ) {
		if ( depth == 5 ) {
			findMax( newMap );
			return;
		}

		int[][] copiedMap = copyMap( newMap );
		up( copiedMap );
		dfs( depth + 1, copiedMap );

		copiedMap = copyMap( newMap );
		down( copiedMap );
		dfs( depth + 1, copiedMap );

		copiedMap = copyMap( newMap );
		left( copiedMap );
		dfs( depth + 1, copiedMap );

		copiedMap = copyMap( newMap );
		right( copiedMap );
		dfs( depth + 1, copiedMap );
	}

	static void up( int[][] copiedMap ) {
		boolean[][] flag = new boolean[N][N];
		for ( int j = 0; j < N; j++ ) {
			for ( int i = 1; i < N; i++ ) {
				if ( copiedMap[i][j] == 0 ) continue;
				int y = i;
				while ( true ) {
					if ( copiedMap[y - 1][j] == 0 ) {
						copiedMap[y - 1][j] = copiedMap[y][j];
						copiedMap[y][j]     = 0;
						flag[y - 1][j]      = flag[y][j];
						flag[y][j]          = false;
					} else {
						if ( copiedMap[y - 1][j] == copiedMap[y][j] && !flag[y - 1][j] && !flag[y][j] ) {
							copiedMap[y - 1][j] = copiedMap[y - 1][j] << 1;
							copiedMap[y][j]     = 0;
							flag[y - 1][j]      = true;
						}
					}
					y--;
					if ( y == 0 ) {
						break;
					}
				}
			}
		}
	}

	static void down( int[][] copiedMap ) {
		boolean[][] flag = new boolean[N][N];
		for ( int j = 0; j < N; j++ ) {
			for ( int i = N - 2; i > -1; i-- ) {
				if ( copiedMap[i][j] == 0 ) continue;
				int y = i;
				while ( true ) {
					if ( copiedMap[y + 1][j] == 0 ) {
						copiedMap[y + 1][j] = copiedMap[y][j];
						copiedMap[y][j]     = 0;
						flag[y + 1][j]      = flag[y][j];
						flag[y][j]          = false;
					} else {
						if ( copiedMap[y + 1][j] == copiedMap[y][j] && !flag[y + 1][j] && !flag[y][j] ) {
							copiedMap[y + 1][j] = copiedMap[y + 1][j] << 1;
							copiedMap[y][j]     = 0;
							flag[y + 1][j]      = true;
						}
					}
					y++;
					if ( y == N - 1 ) {
						break;
					}
				}
			}
		}
	}

	static void left( int[][] copiedMap ) {
		boolean[][] flag = new boolean[N][N];
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 1; j < N; j++ ) {
				if ( copiedMap[i][j] == 0 ) continue;
				int x = j;
				while ( true ) {
					if ( copiedMap[i][x - 1] == 0 ) {
						copiedMap[i][x - 1] = copiedMap[i][x];
						copiedMap[i][x]     = 0;
						flag[i][x - 1]      = flag[i][x];
						flag[i][x]          = false;
					} else {
						if ( copiedMap[i][x - 1] == copiedMap[i][x] && !flag[i][x - 1] && !flag[i][x] ) {
							copiedMap[i][x - 1] = copiedMap[i][x - 1] << 1;
							copiedMap[i][x]     = 0;
							flag[i][x - 1]      = true;
						}
					}
					x--;
					if ( x == 0 ) {
						break;
					}
				}
			}
		}
	}

	static void right( int[][] copiedMap ) {
		boolean[][] flag = new boolean[N][N];
		for ( int i = 0; i < N; i++ ) {
			for ( int j = N - 2; j > -1; j-- ) {
				if ( copiedMap[i][j] == 0 ) continue;
				int x = j;
				while ( true ) {
					if ( copiedMap[i][x + 1] == 0 ) {
						copiedMap[i][x + 1] = copiedMap[i][x];
						copiedMap[i][x]     = 0;
						flag[i][x + 1]      = flag[i][x];
						flag[i][x]          = false;
					} else {
						if ( copiedMap[i][x + 1] == copiedMap[i][x] && !flag[i][x + 1] && !flag[i][x] ) {
							copiedMap[i][x + 1] = copiedMap[i][x + 1] << 1;
							copiedMap[i][x]     = 0;
							flag[i][x + 1]      = true;
						}
					}
					x++;
					if ( x == N - 1 ) {
						break;
					}
				}
			}
		}
	}

	static int[][] copyMap( int[][] newMap ) {
		int[][] copiedMap = new int[N][N];

		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ ) {
				copiedMap[i][j] = newMap[i][j];
			}
		}
		return copiedMap;
	}

	static void findMax( int[][] newMap ) {
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ ) {
				if ( newMap[i][j] != 0 ) {
					max = Math.max( max, newMap[i][j] );
				}
			}
		}
	}
}
