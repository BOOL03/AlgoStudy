package study_0418;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11404_조현빈 {
	static int       N, M;
	static int[][]   buses;
	static int[][]   matrix;
	static final int INF = 100_000_000;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		init();
		floydWarshall();
		print();
	}

	static void floydWarshall() {
		for ( int k = 1; k <= N; k++ ) { // 경
			for ( int i = 1; i <= N; i++ ) { // 출
				if ( k == i ) continue;
				for ( int j = 1; j <= N; j++ ) { // 도
					if ( i == j ) continue;
					if ( matrix[i][k] == INF || matrix[k][j] == INF ) continue;

					matrix[i][j] = Math.min( matrix[i][k] + matrix[k][j], matrix[i][j] );
				}
			}
		}
	}

	static void print() throws IOException {
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		for ( int i = 1; i <= N; i++ ) {
			for ( int j = 1; j <= N; j++ ) {
				if ( matrix[i][j] == INF ) bw.write( "0 " );
				else bw.write( String.format( "%d ", matrix[i][j] ) );
			}
			bw.write( "\n" );
		}
		bw.flush();
	}

	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		N      = Integer.parseInt( br.readLine() );
		M      = Integer.parseInt( br.readLine() );
		matrix = new int[101][101];

		for ( int i = 0; i < M; i++ ) {
			StringTokenizer st         = new StringTokenizer( br.readLine() );
			int             departCity = Integer.parseInt( st.nextToken() );
			int             arriveCity = Integer.parseInt( st.nextToken() );
			int             cost       = Integer.parseInt( st.nextToken() );

			if ( matrix[departCity][arriveCity] != 0 ) {
				matrix[departCity][arriveCity] = Math.min( matrix[departCity][arriveCity], cost );
			} else {
				matrix[departCity][arriveCity] = cost;
			}
		}

		for ( int i = 1; i <= N; i++ ) {
			for ( int j = 1; j <= N; j++ ) {
				if ( i != j && matrix[i][j] == 0 ) matrix[i][j] = INF;
			}
		}
	}
}
