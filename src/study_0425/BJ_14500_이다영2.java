package study_0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_이다영2 {
	static int N, M, K = 4, max;
	static int[][] map;
	static boolean[][] visit;
	
	static int [] dy = {1, 0, 0, -1, -1, -1, 1};
	static int [] dx = {0, -1, 1, -1, 1, -1, -1};
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		max = 0;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visit[i][j] =false;
			}
		}
		System.out.println(max);
	}
	
	static void dfs(int y, int x, int k, int sum) {
		
		if(k == K) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
			
			visit[ny][nx] = true;
			dfs(ny, nx, k+1, sum+map[ny][nx]);
			visit[ny][nx] = false;
		}
		
		if(k==3) {
			int tempy = y - 1;
			int tempx = x;
			if(tempy >= 0 && visit[tempy][tempx]) {
				for (int d = 3; d < 5; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
					visit[ny][nx] = true;
					dfs(ny, nx, k+1, sum+map[ny][nx]);
					visit[ny][nx] = false;
				}
			}
			tempy = y;
			tempx = x - 1;
			if(tempx >= 0 && visit[tempy][tempx]) {
				for (int d = 5; d < 7; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
					visit[ny][nx] = true;
					dfs(ny, nx, k+1, sum+map[ny][nx]);
					visit[ny][nx] = false;
				}
			}
		}
	}
}
