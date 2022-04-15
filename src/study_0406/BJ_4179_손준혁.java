package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_손준혁 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[C][R];
		visited = new boolean[C][R];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if(map[i][j] == 'J') {
					int result = Run(j,i);
					if(result == -1) {
						System.out.println("IMPOSSIBLE");
					}
					else {
						System.out.println(result);
					}
					return;
				}
			}
		}
		
	}
	static void SpreadFire() {
		Queue<int[]> fire = new LinkedList<>();
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if(map[i][j] == 'F') fire.offer(new int[]{i,j});
			}
		}
		while(!fire.isEmpty()) {
			int[] f = fire.poll();
			for (int i = 0; i < 4; i++) {
				int dx = f[1] + delta_x[i];
				int dy = f[0] + delta_y[i];
				if(dx < 0 || dx >= R || dy < 0 || dy >= C) continue;
				if(map[dy][dx] == 'F' || map[dy][dx] == '#') continue;
				map[dy][dx] = 'F';
			}
		}
	}
	static int Run(int x, int y) {
		int count = 0;
		Queue<int[]> jihoon = new LinkedList<>();
		jihoon.offer(new int[] {y,x});
		visited[y][x] = true;
		while(!jihoon.isEmpty()) {
			count++;
			SpreadFire();
			int j_size = jihoon.size();
			while(j_size>=0) {
				j_size--;
				int[] j = jihoon.poll();
				if(j[0] == 0 || j[0] == C-1 || j[1] == 0 || j[1] == R-1) return count;
				for (int i = 0; i < 4; i++) {
					int dx = j[1] + delta_x[i];
					int dy = j[0] + delta_y[i];
					if(dx < 0 || dx >= R || dy < 0 || dy >= C) continue;
					if(map[dy][dx] != '.' || visited[dy][dx]) continue;
					visited[dy][dx] = true;
					jihoon.offer(new int[] {dy,dx});
				}
			}
		}
		return -1;
	}
}

