package study_0509;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_18809_이다영 {
	static int N, M, G, R;
	static int [][] map;
	static boolean[][] visit;
//	static List<>
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	// 조합으로 배양액을 뿌릴 땅 고름
	// 조합완성 => 부분집합을 통해 G, R 그룹나눔
	// 나눈 그룹을 통해 BFS탐색
	public static void subset(int tgtIdx) {
		
	}
	
	public static class Node{
		int y;
		int x;
		int color; //초록 1, 빨간 1
		int d;
		boolean isFlower;
	}
}