package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_이다영 {
	static int N, M, ans;
	static int[][] map;
	
	static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(y, x, dir);
		
		System.out.println(ans);

	}
	public static void clean(int y, int x, int dir) {
		ans++;
		// 1. 현재 위치를 청소한다.
		map[y][x] = 3;
		int direction = dir;
		while(true) {
			for (int d = 0; d < 4; d++) {
				direction = direction==0? 3: direction-1;
				int ny = y + dy[direction];
				int nx = x + dx[direction];
				
				if(ny <= 0 || nx <= 0 || ny >= N-1 || nx >=M-1 ) continue;
				if(map[ny][nx] == 0) {
					clean(ny, nx, direction);
					return;
				}
			}
			int ny = y - dy[direction];
			int nx = x - dx[direction];
			if(ny <= 0 || nx <= 0 || ny >= N-1 || nx >=M-1 ) return;
			if(map[ny][nx] == 1) return;
			y = ny;
			x = nx;
		}
	}
} 
