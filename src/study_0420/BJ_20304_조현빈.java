package study_0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_20304_조현빈 {
	static int            N, M;
	static int            visit[];
	static Deque< int[] > dq;

	public static void main( String[] args ) throws Exception {
		BufferedReader  br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = null;

		N     = Integer.parseInt( br.readLine() );
		M     = Integer.parseInt( br.readLine() );
		visit = new int[N + 1];

		Arrays.fill( visit, -1 );

		dq = new ArrayDeque<>();
		st = new StringTokenizer( br.readLine() );

		for ( int i = 0; i < M; i++ ) {
			int num = Integer.parseInt( st.nextToken() );
			dq.offerLast( new int[]
				{
						num, 0
				} );
			visit[num] = 0;
		}

		System.out.println( bfs() );
	}

	static int bfs() {
		int ans = 0;
		while ( !dq.isEmpty() ) {
			int[] arr = dq.pollFirst();
			int   num = arr[0];
			int   cnt = arr[1];

			ans = Math.max( ans, cnt );

			for ( int i = 1; i <= N; i = i << 1 ) {
				int bit = num & i;

				if ( bit > 0 ) {
					if ( visit[num - i] != -1 ) continue;
					dq.offerLast( new int[]
						{
								num - i, cnt + 1
						} );
					visit[num - i] = cnt + 1;
				} else {
					if ( num + i > N ) continue;
					if ( visit[num + i] != -1 ) continue;
					dq.offerLast( new int[]
						{
								num + i, cnt + 1
						} );
					visit[num + i] = cnt + 1;
				}
			}
		}

		return ans;
	}
}
