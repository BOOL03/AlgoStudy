package study_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1347_조현빈 {
	public static void main( String[] args )
			throws NumberFormatException, IOException {
		BufferedReader br     = new BufferedReader(
				new InputStreamReader( System.in )
		);

		int            length = Integer.parseInt( br.readLine() );
		String         str    = br.readLine();

		char[][]       maze   = new char[100][100];
		int            minX   = 50;
		int            minY   = 50;
		int            maxX   = 50;
		int            maxY   = 50;
		int            curX   = 50;
		int            curY   = 50;
		int            dir    = 2;

		for ( int i = 0; i < 100; i++ ) {
			for ( int j = 0; j < 100; j++ ) {
				maze[i][j] = '#';
			}
		}

		for ( int i = 0; i < length; i++ ) {
			maze[curY][curX] = '.';
			char note = str.charAt( i );
			switch ( note ) {
				case 'R':
					dir = ( dir + 1 ) % 4;
					break;
				case 'L':
					dir -= 1;
					if ( dir == -1 ) dir = 3;
					break;
				case 'F':
					if ( dir == 0 ) {
						curY -= 1;
						minY  = minY > curY ? curY : minY;
					} else if ( dir == 1 ) {
						curX += 1;
						maxX  = maxX < curX ? curX : maxX;
					} else if ( dir == 2 ) {
						curY += 1;
						maxY  = maxY < curY ? curY : maxY;
					} else if ( dir == 3 ) {
						curX -= 1;
						minX  = minX > curX ? curX : minX;
					}
					break;
			}
		}
		maze[curY][curX] = '.';

		for ( int i = minY; i <= maxY; i++ ) {
			for ( int j = minX; j <= maxX; j++ ) {
				System.out.print( maze[i][j] );
			}
			System.out.println();
		}
	}
}
