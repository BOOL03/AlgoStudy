package study_0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_손준혁 {
	static int N,M;
	static int[][] map, melt_map;
	
	static boolean[][] selected;
	
	static int[] delta_x = {-1,0,1,0};
	static int[] delta_y = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		melt_map = new int[N][M];
		selected = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int repeat = 1; repeat < Integer.MAX_VALUE; repeat++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) melting(j,i);
				}
			}
			copyMap();
			int result = checkBFS();
			switch(result) {
			case -1:
				System.out.println(0);
				return;
			case 0:
				System.out.println(repeat);
				return;
			}
		}
	}

	static void melting(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int dx = x + delta_x[i];
			int dy = y + delta_y[i];
			
			if(dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
			if(map[dy][dx] == 0) count++;
		}
		melt_map[y][x] = map[y][x] - count;
		if(melt_map[y][x] < 0 ) melt_map[y][x] = 0;
	}
	
	static int checkBFS() {
		int count = 0, allMelt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0 && !selected[i][j]) {
					allMelt = 1;
					Queue<int[]> list = new LinkedList<>();
					list.offer(new int[] {i,j});
					selected[i][j] = true;
					boolean check = false;
					while(!list.isEmpty()) {
						int size = list.size();
						check = true;
						for (int r = 0; r < size; r++) {
							int[] tmp = list.poll();
							for (int d = 0; d < 4; d++) {
								int dx = tmp[1] + delta_x[d];
								int dy = tmp[0] + delta_y[d];
								if(dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
								if(selected[dy][dx]) continue;
								if(map[dy][dx] > 0) {
									list.offer(new int[] {dy,dx});
									selected[dy][dx] = true;
								}
							}
						}
					}
					if(check) count++;
				}
			}
		}
		selected = new boolean[N][M];
		if(count > 1) return 0;
		else if(allMelt == 0 && count < 2) return -1;
		else return 1;
	}
	
	static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = melt_map[i][j];
			}
		}
		melt_map = new int[N][M];
	}
}
