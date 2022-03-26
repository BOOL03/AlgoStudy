package study_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1522_조현빈 {
	public static void main( String[] args ) throws IOException {
		String str    = new BufferedReader( new InputStreamReader( System.in ) )
				.readLine();
		int    aCount = 0;
		int    bCount = 0;
		int    change = 0;
		for ( int i = 0; i < str.length(); i++ ) {
			char cur = str.charAt( i );
			if ( cur == 'a' ) {
				aCount++;
			}
		}

		for ( int i = 0; i < aCount; i++ ) {
			char cur = str.charAt( i );
			if ( cur == 'b' ) {
				bCount++;
			}
		}

		change = bCount;
		for ( int i = 1; i < str.length(); i++ ) {
			char cur     = str.charAt( i - 1 );
			int  pointer = i - 1 + aCount;
			if ( cur == 'b' ) bCount--;
			if ( pointer >= str.length() ) pointer -= str.length();
			cur = str.charAt( pointer );
			if ( cur == 'b' ) bCount++;
			change = Math.min( change, bCount );
		}

		System.out.println( change );
	}
}
