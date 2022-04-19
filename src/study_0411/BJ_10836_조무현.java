package study_0411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10836_조무현 {
	static int M, N;
	static int[][] map;
	static int[][] growth;
	static int[][] order;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][M];
		growth = new int[M][M];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 1;
			}
		}
		order = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken());
			order[i][1] = Integer.parseInt(st.nextToken());
			order[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			day(i);
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[j][k] + " ");
				}
			System.out.println();
			}
			System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void day(int d) {
		int[] order_day = order[d];
		// 왼쪽 아래부터 위로
		// 왼쪽 아래(M-1, 0), 왼쪽 위 (0, 0), 오른쪽 끝(0, M-1)
		int zero = order_day[0];
		int one = order_day[1];
		int two = order_day[2];
		
		for (int i = M-1; i >= 0; i--) {
			if(zero > 0) {
				growth[i][0] = 0;
				zero--;
				continue;
			}
			
			if(one > 0) {
				map[i][0] += 1;
				growth[i][0] = 1;
				one--;
				continue;
			}
			
			if(two > 0) {
				map[i][0] += 2;
				growth[i][0] = 2;
				two--;
				continue;
			}
			
			
		}
		
		for (int i = 1; i <= M-1; i++) {
			if(zero > 0) {
				growth[0][i] = 0;
				zero--;
				continue;
			}
			
			if(one > 0) {
				growth[0][i] = 1;
				map[0][i] += 1;
				one--;
				continue;
			}
			
			if(two > 0) {
				growth[0][i] = 2;
				map[0][i] += 2;
				two--;
				continue;
			}
			
			
		}
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(growth[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				int tmp = Math.max(Math.max(growth[i][j-1], growth[i-1][j-1]), growth[i-1][j]);
				growth[i][j] = tmp;
				map[i][j] += tmp;
			}
		}
	}

}
