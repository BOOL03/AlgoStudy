package study_0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_조무현 {
	static int N, M;
	static int[][] dist;
	static int INF = 10000001;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		// 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[from-1][to-1] = Math.min(dist[from-1][to-1], v);
		}
		
		for (int i = 0; i < N; i++) {
			dist[i][i] = 0;
		}
		
		
		// 플로이드 와샬
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k == i) continue;
				for (int j = 0; j < N; j++) {
					if(k == j || i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dist[i][j] == INF) {
					System.out.println("0 ");
				}else {
					System.out.print(dist[i][j] + " ");					
				}
			}
			System.out.println();
		}
	}

}
