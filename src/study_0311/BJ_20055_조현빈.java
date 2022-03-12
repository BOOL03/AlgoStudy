package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_20055_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader  br    = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st    = new StringTokenizer( br.readLine() );
		int             N     = Integer.parseInt( st.nextToken() );
		int             K     = Integer.parseInt( st.nextToken() );
		int             count = 0;
		List< Integer > belt  = new ArrayList< Integer >();
		List< Boolean > robot = new ArrayList< Boolean >();

		st = new StringTokenizer( br.readLine() );

		for ( int i = 0; i < 2 * N; i++ ) {
			belt.add( Integer.parseInt( st.nextToken() ) );
		}

		for ( int i = 0; i < 2 * N; i++ ) {
			robot.add( false );
		}

		while ( true ) {
			int zero = 0;
			for ( int i = 0; i < 2 * N; i++ ) {
				if ( belt.get( i ) == 0 ) {
					zero++;
				}
			}
			if ( zero >= K ) break;

			count++;

			belt.add( 0, belt.get( 2 * N - 1 ) );
			belt.remove( 2 * N );

			robot.add( 0, robot.get( 2 * N - 1 ) );
			robot.remove( 2 * N );
			if ( robot.get( N ) == true ) robot.set( N, false );

			for ( int i = N - 1; i > -1; i-- ) {
				if ( i == N - 1 && robot.get( i ) == true ) {
					robot.set( i, false );
				} else if ( i != N - 1 && robot.get( i ) == true ) {
					if ( belt.get( i + 1 ) > 0 && !robot.get( i + 1 ) ) {
						belt.set( i + 1, belt.get( i + 1 ) - 1 );
						robot.set( i + 1, true );
						robot.set( i, false );
					}
				}
			}

			if ( belt.get( 0 ) > 0 && !robot.get( 0 ) ) {
				belt.set( 0, belt.get( 0 ) - 1 );
				robot.set( 0, true );
			}
		}

		System.out.println( count );
	}
}
