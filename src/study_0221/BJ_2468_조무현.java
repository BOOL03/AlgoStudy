package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_조무현 {
	static int N;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(max);
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for (int h = 0; h <= 100; h++) {
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			queue.clear();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > h && !visited[i][j]) {
						visited[i][j] = true;
						queue.offer(new int[] {i, j});
						while(!queue.isEmpty()) {
							int[] temp = queue.poll();
							for (int k = 0; k < 4; k++) {
								int ny = temp[0] + dy[k];
								int nx = temp[1] + dx[k];
								if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
								if(map[ny][nx] > h && !visited[ny][nx]) {
									visited[ny][nx] = true;
									queue.offer(new int[] {ny, nx});
								}
							}
						}
						cnt++;
					}
					
				}
			}
			max = Math.max(max, cnt);
		}
		
	}

}
