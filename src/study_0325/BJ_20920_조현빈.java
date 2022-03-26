package study_0325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_20920_조현빈 {

	public static void main( String[] args )
			throws NumberFormatException, IOException {

		BufferedReader             br    = new BufferedReader(
				new InputStreamReader( System.in )
		);
		BufferedWriter             bw    = new BufferedWriter(
				new OutputStreamWriter( System.out )
		);

		StringTokenizer            st    = new StringTokenizer( br.readLine() );
		int                        N     = Integer.parseInt( st.nextToken() );
		int                        M     = Integer.parseInt( st.nextToken() );

		ArrayList< String >        words = new ArrayList< String >();
		HashMap< String, Integer > map   = new HashMap< String, Integer >( M );

		for ( int n = 0; n < N; n++ ) {
			String word = br.readLine();
			if ( word.length() < M ) continue;
			if ( map.get( word ) == null ) {
				words.add( word );
				map.put( word, 1 );
			} else {
				map.put( word, map.get( word ) + 1 );
			}
		}

		Collections.sort( words, new Comparator< String >() {
			@Override
			public int compare( String s1, String s2 ) {
				Integer a = map.get( s1 );
				Integer b = map.get( s2 );
				if ( a == b ) {
					if ( s1.length() == s2.length() ) {
						return s1.compareTo( s2 );
					} else {
						return ( (Integer) s2.length() ).compareTo( (Integer) s1.length() );
					}
				} else {
					return b.compareTo( a );
				}
			}
		} );

		for ( int m = 0; m < words.size(); m++ ) {
			bw.write( words.get( m ) + "\n" );
		}
		bw.flush();
	}
}
