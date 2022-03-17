package study_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2644_조현빈 {
	static ArrayList< Integer >[] relation;
	static boolean[]              visit;
	static int                    count = -1;

	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		int            n  = Integer.parseInt( br.readLine() );
		relation = new ArrayList[n + 1];
		visit    = new boolean[n + 1];
		for ( int i = 1; i < n + 1; i++ ) {
			relation[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int             a  = Integer.parseInt( st.nextToken() );
		int             b  = Integer.parseInt( st.nextToken() );
		int             m  = Integer.parseInt( br.readLine() );

		for ( int i = 0; i < m; i++ ) {
			st = new StringTokenizer( br.readLine() );
			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );
			relation[x].add( y );
			relation[y].add( x );
		}

		dfs( a, b, 0 );
		System.out.println( count );
	}

	static void dfs( int a, int b, int cnt ) {
		if ( a == b ) {
			count = cnt;
			return;
		}

		visit[a] = true;
		for ( int i = 0; i < relation[a].size(); i++ ) {
			int next = relation[a].get( i );
			if ( !visit[next] ) {
				dfs( next, b, cnt + 1 );
			}
		}
	}
}
