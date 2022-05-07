package study_0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_이다영 {
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		final int INF = 100000*N+1;
		
		map = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 시작
			int end = Integer.parseInt(st.nextToken()); // 도착
			int cost = Integer.parseInt(st.nextToken()); // 비용
			if (map[start][end] != 0) map[start][end] = Math.min(map[start][end], cost);
			else map[start][end] = cost;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == 0) map[i][j] = INF;
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("===============");
		
		// 경 출 도
		for (int k = 1; k <= N ; k++) {
			for (int i = 1; i <= N; i++) {
				if(k == i) continue;
				for (int j = 1; j <= N; j++) {
					if( k == j || i == j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
 			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(map[i][j] == INF ? "0 " : map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
}
