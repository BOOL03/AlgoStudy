package study_0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_이다영 {
	static int N, M, x, y, K;
	static int[][] map;
	
	static int[] dy = {0, 0, -1, 1 }; // 동서북남
	static int[] dx = {1, -1, 0, 0};
	
	static int[] row; // 가로
	static int[] col; // 세로
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		row = new int[4];
		col = new int[4];
		
		for (int i = 0; i < 4; i++) {
			row[i] = 0;
			col[i] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(st.nextToken());
			// System.out.println("========" + k + "==========");
			// System.out.println("y : "  + y + "  , x " + x);
			int ny = y + dy[dir-1];
			int nx = x + dx[dir-1];
			// System.out.println("ny : "  + ny + "  , nx " + nx);
			
			if(ny >= N || nx >= M || ny <0 || nx < 0) continue;
			
			dice(dir);
			
			if(map[ny][nx] == 0) {
				map[ny][nx] = row[3];
			}else {
				row[3] = map[ny][nx];
				col[3] = map[ny][nx];
				map[ny][nx] = 0;
			}
			
			// System.out.println(row[1]);
			 sb.append(row[1] + "\n");
			
			y = ny;
			x = nx;
		}
		 System.out.println(sb.toString());
	}
	
	public static void dice(int dir) {
		
		switch(dir) {
			case 1 : { // 동
				int temp = row[3];
				for (int i = 3; i > 0; i--) {
					row[i] = row[i-1]; 
				}
				
				row[0] = temp;
				
				col[1] = row[1];
				col[3] = row[3];
				
				break;
			}
			
			case 2 : { // 서
				int temp = row[0];
				for (int i = 0; i < 3; i++) {
					row[i] = row[i+1];
				}
				row[3] = temp;
				
				col[1] = row[1];
				col[3] = row[3];
				break;
			}
			
			case 3 : { // 북
				int temp = col[0];
				for (int i = 0; i < 3; i++) {
					col[i] = col[i+1];
				}
				col[3] = temp;
				
				row[1] = col[1];
				row[3] = col[3];
				break;
			}
			
			case 4 : { // 남
				int temp = col[3];
				for (int i = 3; i > 0;  i--) {
					col[i] = col[i-1];
				}
				col[0] = temp;
				
				row[1] = col[1];
				row[3] = col[3];
				break;
			}
		}
	}
}