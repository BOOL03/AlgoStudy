package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader  br         = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st         = new StringTokenizer( br.readLine() );
		int             R          = Integer.parseInt( st.nextToken() );
		int             C          = Integer.parseInt( st.nextToken() );
		int             T          = Integer.parseInt( st.nextToken() );
		int[][]         map        = new int[R][C];
		int[][]         afterMap   = new int[R][C];
		int             count      = 0;
		int[]           dy         =
			{
					-1, 0, 1, 0
			};
		int[]           dx         =
			{
					0, 1, 0, -1
			};
		int[]           airCleaner = new int[2];
		int             index      = 0;

		for ( int i = 0; i < R; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < C; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
				if ( map[i][j] == -1 ) {
					airCleaner[index++] = i;
				}
			}
		}

		while ( count < T ) {
			count++;

			for ( int i = 0; i < R; i++ ) {
				for ( int j = 0; j < C; j++ ) {
					if ( map[i][j] != 0 ) {
						int spreadCount  = 0;
						int spreadAmount = map[i][j] / 5;

						for ( int k = 0; k < 4; k++ ) {
							int ny = i + dy[k];
							int nx = j + dx[k];
							if ( -1 < ny && ny < R && -1 < nx && nx < C && map[ny][nx] != -1 ) {
								spreadCount++;
								afterMap[ny][nx] += spreadAmount;
							}
						}

						map[i][j] = map[i][j] - ( spreadAmount * spreadCount );
					}
				}
			}

			for ( int i = 0; i < R; i++ ) {
				for ( int j = 0; j < C; j++ ) {
					map[i][j]      += afterMap[i][j];
					afterMap[i][j]  = 0;
				}
			}

			// 윗쪽
			// 좌
			for ( int i = airCleaner[0] - 1; i > 0; i-- ) {
				map[i][0] = map[i - 1][0];
			}
			// 상
			for ( int i = 0; i < C - 1; i++ ) {
				map[0][i] = map[0][i + 1];
			}
			// 우
			for ( int i = 0; i < airCleaner[0]; i++ ) {
				map[i][C - 1] = map[i + 1][C - 1];
			}
			// 하
			for ( int i = C - 1; i > 1; i-- ) {
				map[airCleaner[0]][i] = map[airCleaner[0]][i - 1];
			}

			map[airCleaner[0]][1] = 0;

			// 아랫쪽
			// 좌
			for ( int i = airCleaner[1] + 1; i < R - 1; i++ ) {
				map[i][0] = map[i + 1][0];
			}
			// 하
			for ( int i = 0; i < C - 1; i++ ) {
				map[R - 1][i] = map[R - 1][i + 1];
			}
			// 우
			for ( int i = R - 1; i > airCleaner[1]; i-- ) {
				map[i][C - 1] = map[i - 1][C - 1];
			}
			// 상
			for ( int i = C - 1; i > 1; i-- ) {
				map[airCleaner[1]][i] = map[airCleaner[1]][i - 1];
			}

			map[airCleaner[1]][1] = 0;

		}

		int result = 0;
		for ( int i = 0; i < R; i++ ) {
			for ( int j = 0; j < C; j++ ) {
				if ( map[i][j] != -1 ) result += map[i][j];
			}
		}

		System.out.println( result );
	}
}
