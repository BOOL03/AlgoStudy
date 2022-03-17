package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_손준혁 {
	static int count,N,M;
	static int[] delta_x = {0,-1,0,1};
	static int[] delta_y = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
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
		DFS(x,y,dir);
		System.out.println(count);
	}
	static void DFS(int x, int y, int dir) {
		visited[y][x] = true;
		count++;
		boolean result = false;
		for (int i = 0; i < 4; i++) {
			int dx = x + delta_x[(dir+i)%4];
			int dy = y + delta_y[(dir+i)%4];
			if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
			if(visited[dy][dx] && i < 3) continue;
			if(visited[dy][dx] && i == 3) {
				dx = x;
				dy = y+delta_y[dir];
				if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
				if(map[dy][dx] == 1) continue;
			}
			DFS(dx, dy, (dir+i)%4);
		}
		return;
	}

}
