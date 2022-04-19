package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096_조무현 {
	static int N;
	static int[][] map;
	static int[][] DP;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		DP = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DP[0][0] = map[0][0];
		DP[0][1] = map[0][1];
		DP[0][2] = map[0][2];
		
		for (int i = 1; i < N; i++) {
			DP[i][0] = Math.min(DP[i-1][0], DP[i-1][1]) + map[i][0];
			DP[i][1] = Math.min(DP[i-1][0], Math.min(DP[i-1][1], DP[i-1][2])) + map[i][1];
			DP[i][2] = Math.min(DP[i-1][1], DP[i-1][2]) + map[i][2];
		}
		
		int min = Math.min(DP[N-1][0], Math.min(DP[N-1][1], DP[N-1][2]));
		
		for (int i = 1; i < N; i++) {
			DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]) + map[i][0];
			DP[i][1] = Math.max(DP[i-1][0], Math.max(DP[i-1][1], DP[i-1][2])) + map[i][1];
			DP[i][2] = Math.max(DP[i-1][1], DP[i-1][2]) + map[i][2];
		}
		
		int max = Math.max(DP[N-1][0], Math.max(DP[N-1][1], DP[N-1][2]));
		
		System.out.print(max + " " + min);

	}

}
