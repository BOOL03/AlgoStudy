package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1446_조현빈 {
	public static void main( String[] args ) throws Exception {
		BufferedReader  br  = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st  = new StringTokenizer( br.readLine() );
		int             N   = Integer.parseInt( st.nextToken() );
		int             D   = Integer.parseInt( st.nextToken() );
		int[][]         arr = new int[N][3];
		int[]           dp  = new int[D + 2];

		for ( int i = 0; i < N; i++ ) {
			st        = new StringTokenizer( br.readLine() );
			arr[i][0] = Integer.parseInt( st.nextToken() );
			arr[i][1] = Integer.parseInt( st.nextToken() );
			arr[i][2] = Integer.parseInt( st.nextToken() );
		}

		// 그냥 고속도로 달릴때 거리들
		for ( int i = 0; i < D + 2; i++ ) {
			dp[i] = i;
		}

		// 출발점 기준으로 정렬
		Arrays.sort( arr, ( o1, o2 ) -> Integer.compare( o1[0], o2[0] ) );

		for ( int i = 0; i < N; i++ ) {
			int from = arr[i][0];
			int to   = arr[i][1];
			int dist = arr[i][2];
			// 역주행 못한대
			if ( to > D ) {
				continue;
			}
			// 도착점이 출발점 + 지름길 거리 보다 크면
			if ( dp[to] > dp[from] + dist ) {
				// 갱신
				dp[to] = dp[from] + dist;
				// 그 뒤로 쭉 갱신 시켜줌
				for ( int j = to + 1; j < D + 2; j++ ) {
					dp[j] = Math.min( dp[j - 1] + 1, dp[j] );
				}
			}
		}

		System.out.println( dp[D] );
	}
}
