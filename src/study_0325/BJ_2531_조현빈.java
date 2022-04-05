package study_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531_조현빈 {

	public static void main( String[] args ) throws IOException {
		BufferedReader  br  = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		int             max = 0;

		st = new StringTokenizer( br.readLine() );

		int   N     = Integer.parseInt( st.nextToken() );
		int   d     = Integer.parseInt( st.nextToken() );
		int   k     = Integer.parseInt( st.nextToken() );
		int   c     = Integer.parseInt( st.nextToken() );

		int[] sushi = new int[N];
		for ( int i = 0; i < N; i++ ) {
			sushi[i] = Integer.parseInt( br.readLine() );
		}

		int[] check = new int[d + 1];
		int   count = 0;

		for ( int i = 0; i < k; i++ ) {
			if ( check[sushi[i]] == 0 ) count++;
			check[sushi[i]]++;
		}

		max = count;
		int start = 1, end = k;
		while ( true ) {

			if ( check[sushi[start - 1]] == 1 ) count--;
			check[sushi[start - 1]]--;

			if ( check[sushi[end]] == 0 ) count++;
			check[sushi[end]]++;

			if ( check[c] == 0 ) max = Math.max( max, count + 1 );
			else max = Math.max( max, count );

			start++;
			end++;
			if ( end == N ) end = 0;
			if ( start == N ) break;
		}

		System.out.println( max );

	}

}
