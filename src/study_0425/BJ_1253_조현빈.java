package study_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_조현빈 {
	static int N, cnt, arr[];

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		N   = Integer.parseInt( br.readLine() );
		arr = new int[N];

		StringTokenizer st = new StringTokenizer( br.readLine() );

		for ( int i = 0; i < N; i++ ) {
			arr[i] = Integer.parseInt( st.nextToken() );
		}

		Arrays.sort( arr );

		for ( int i = 0; i < N; i++ ) {
			int num = arr[i];
			int j   = 0;
			int k   = N - 1;

			while ( true ) {
				if ( j == i ) j++;
				if ( k == i ) k--;
				if ( k < 0 || j > N - 1 ) break;
				if ( j == k ) break;
				int sum = arr[j] + arr[k];
				if ( sum > num ) k--;
				else if ( sum < num ) j++;
				else {
					cnt++;
					break;
				}
			}
		}
		System.out.println( cnt );
	}
}
