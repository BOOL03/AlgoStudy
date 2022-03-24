package study_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16113_조현빈 {
	public static void main( String[] args )
			throws NumberFormatException, IOException {
		BufferedReader br           = new BufferedReader(
				new InputStreamReader( System.in )
		);
		StringBuilder  sb           = new StringBuilder();

		int[][]        number       =
			{
					{
							5, 2, 5
					},
					{
							5, 0, 0
					},
					{
							4, 3, 4
					},
					{
							3, 3, 5
					},
					{
							3, 1, 5
					},
					{
							4, 3, 4
					},
					{
							5, 3, 4
					},
					{
							1, 1, 5
					},
					{
							5, 3, 5
					},
					{
							4, 3, 5
					}
			};

		int            N            = Integer.parseInt( br.readLine() );
		String         signalString = br.readLine();
		int            row          = 5;
		int            col          = N / 5;
		char[][]       signal       = new char[row][col];

		for ( int i = 0; i < row; i++ ) {
			for ( int j = 0; j < col; j++ ) {
				signal[i][j] = signalString.charAt( i * col + j );
			}
		}
		int first  = -1;
		int blank  = -1;
		int second = -1;
		int third  = -1;
		int cnt1   = 0;
		int cnt2   = 0;
		int blank2 = -1;
		for ( int i = 0; i < col; i++ ) {
			int j;
			for ( j = 0; j < row; j++ ) {
				if ( signal[j][i] == '#' ) {
					cnt1++;
				} else {
					blank = j;
				}
			}
			if ( first == -1 && cnt1 == 0 ) {
				cnt2 = 0;
				continue;
			}
			if ( j == row && cnt2 == 0 && first == -1 ) {
				first = cnt1;
				if ( cnt1 == 4 ) blank2 = blank;
				cnt1 = 0;
			} else if ( j == row && cnt2 == 1 && second == -1 ) {
				second = cnt1;
				cnt1   = 0;
			} else if ( j == row && cnt2 == 2 && third == -1 ) {
				third = cnt1;
				cnt1  = 0;
			}

			cnt2++;
			if ( second == 0 || ( first == 5 && second == -1 && i == col - 1 ) ) {
				sb.append( 1 );
				cnt2   = 0;
				first  = -1;
				second = -1;
			}
			if ( cnt2 == 3 ) {
				for ( j = 0; j < 10; j++ ) {
					if ( first == number[j][0] && second == number[j][1]
							&& third == number[j][2] ) {
						break;
					}
				}

				if ( j == 2 ) {
					if ( blank2 == 1 ) {
						sb.append( 2 );
						blank = -1;
					} else {
						sb.append( 5 );
						blank = -1;
					}
				} else {
					if ( j != 10 ) {
						sb.append( j );
					}
				}
				first  = -1;
				second = -1;
				third  = -1;
				cnt2   = 0;
			}
		}

		System.out.println( sb.toString() );
	}
}
