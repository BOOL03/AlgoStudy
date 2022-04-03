package study_0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2023_조현빈 {
	static int            N;
	static BufferedWriter bw;
	static int[]          prime;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		N     = Integer.parseInt( new BufferedReader( new InputStreamReader( System.in ) ).readLine() );
		bw    = new BufferedWriter( new OutputStreamWriter( System.out ) );
		prime = new int[]
			{
					2, 3, 5, 7
			};
		for ( int i = 0; i < 4; i++ ) {
			dfs( prime[i], 0 );
		}

		bw.flush();
	}

	static void dfs( int num, int depth ) throws IOException {
		if ( depth == N - 1 ) {
			if ( isPrime( num ) ) {
				bw.write( String.format( "%d\n", num ) );
			}
		}

		for ( int i = 1; i < 10; i += 2 ) {
			if ( i == 5 ) continue;
			if ( isPrime( num * 10 + i ) ) {
				dfs( num * 10 + i, depth + 1 );
			}
		}
	}

	public static boolean isPrime( int num ) {
		for ( int i = 2; i * i <= num; i++ ) {
			if ( num % i == 0 ) return false;
		}
		return true;
	}
}
