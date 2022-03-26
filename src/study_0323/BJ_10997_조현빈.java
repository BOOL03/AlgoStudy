package study_0323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10997_조현빈 {
	public static void main( String[] args )
			throws NumberFormatException, IOException {
		int            N  = Integer.parseInt(
				new BufferedReader( new InputStreamReader( System.in ) ).readLine()
		);
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter( System.out )
		);

		if ( N == 1 ) {
			System.out.println( '*' );
			return;
		}

		int      col = 4 * N - 3;
		int      row = col + 2;
		char[][] arr = new char[row][col];

		for ( int i = 0; i < row; i++ ) {
			for ( int j = 0; j < col; j++ ) {
				arr[i][j] = ' ';
			}
		}

		int y = 4 * N - 4;
		int x = 0;

		dfs( N, x, y, arr );

		for ( int i = 0; i < row; i++ ) {
			if ( i == 1 ) {
				bw.write( "*\n" );
				continue;
			}
			for ( int j = 0; j < col; j++ ) {
				bw.write( String.format( "%c", arr[i][j] ) );
			}
			bw.write( "\n" );jsWo
		}
		bw.flush();

	}

	static void dfs( int N, int y, int x, char[][] arr ) {

		int width  = 4 * N - 3;
		int height = width + 2;

		for ( int i = 1; i < width; i++ )
			arr[y][x--] = '*';
		for ( int i = 1; i < height; i++ )
			arr[y++][x] = '*';
		for ( int i = 1; i < width; i++ )
			arr[y][x++] = '*';
		for ( int i = 1; i < height - 2; i++ )
			arr[y--][x] = '*';

		arr[y][x--] = '*';
		arr[y][x]   = '*';

		if ( N == 2 ) {
			arr[y][x - 1]     = '*';
			arr[y + 1][x - 1] = '*';
			arr[y + 2][x - 1] = '*';
			return;
		}

		dfs( N - 1, y, x - 1, arr );
	}
}
