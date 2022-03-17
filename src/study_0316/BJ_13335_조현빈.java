package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_13335_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader        br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer       st = new StringTokenizer( br.readLine() );
		int                   N  = Integer.parseInt( st.nextToken() );
		int                   L  = Integer.parseInt( st.nextToken() );
		int                   W  = Integer.parseInt( st.nextToken() );
		ArrayDeque< Integer > dq = new ArrayDeque< Integer >();
		st = new StringTokenizer( br.readLine() );
		for ( int i = 0; i < N; i++ ) {
			dq.offer( Integer.parseInt( st.nextToken() ) );
		}

		int                     sumWeight  = 0;
		int                     truckCount = 0;
		LinkedList< Integer[] > list       = new LinkedList< Integer[] >();
		int                     time       = 0;
		while ( !dq.isEmpty() || !list.isEmpty() ) {
			if ( !dq.isEmpty() && sumWeight + dq.peekFirst() >= W && list.size() + 1 >= L ) {
				for ( int i = 0; i < list.size(); i++ ) {
					list.get( i )[1]++;
					if ( list.get( i )[1] == L ) {
						sumWeight -= list.get( i )[0];
						list.remove( i );
						i--;
					}
				}
			} else {
				list.add( new Integer[]
					{
							dq.pollFirst(), 0
					} );
				sumWeight += list.get( list.size() - 1 )[0];
			}
			time++;
		}
		System.out.println( time );
	}
}
