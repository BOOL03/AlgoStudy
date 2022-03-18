package study_0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_조현빈 {
	static int min = Integer.MAX_VALUE;

	public static void main( String[] args ) throws Exception {
		StringTokenizer st = new StringTokenizer(
				new BufferedReader( new InputStreamReader( System.in ) ).readLine()
		);

		dfs( Long.parseLong( st.nextToken() ), Long.parseLong( st.nextToken() ), 1 );

		System.out.println( min == Integer.MAX_VALUE ? -1 : min );
	}

	public static void dfs( long current, long target, int count ) {
		if ( current > target ) {
			return;
		} else {
			if ( current * 2 == target ) {
				min = Math.min( min, count + 1 );
			} else if ( current * 10 + 1 == target ) {
				min = Math.min( min, count + 1 );
			} else {
				dfs( current * 2, target, count + 1 );
				dfs( current * 10 + 1, target, count + 1 );
			}
		}
	}
}
