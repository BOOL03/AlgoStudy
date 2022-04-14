package study_0411;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_10836_조현빈 {
	static int   M, N;
	static int[] arr;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter  bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );

		M   = Integer.parseInt( st.nextToken() );
		N   = Integer.parseInt( st.nextToken() );
		arr = new int[M * 2 - 1];
		for ( int i = 0; i < M * 2 - 1; i++ ) {
			arr[i] = 1;
		}

		for ( int i = 0; i < N; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int zero = Integer.parseInt( st.nextToken() );
			int one  = Integer.parseInt( st.nextToken() );
			Integer.parseInt( st.nextToken() );

			for ( int j = zero; j < zero + one; j++ ) {
				arr[j] += 1;
			}

			for ( int j = zero + one; j < M * 2 - 1; j++ ) {
				arr[j] += 2;
			}
		}

		for ( int i = M - 1; i > -1; i-- ) {
			bw.write( String.format( "%d ", arr[i] ) );
			for ( int j = M; j < 2 * M - 1; j++ ) {
				bw.write( String.format( "%d ", arr[j] ) );
			}
			bw.write( "\n" );
		}

		bw.flush();
	}
}
