package study_0511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16927_이다영 {
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sy = 0;
		int sx = 0;
		int ey = N-1;
		int ex = M-1;
		while(sy <= ey && sx <= ex) {
			int cnt = (ey-sy+1) * 2 + (ex-sx+1) * 2 - 4 ;
			rotate(sy, sx, ey, ex, R%cnt);
			sy ++;
			sx ++;
			ey --;
			ex --;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	public static void rotate(int sy, int sx, int ey, int ex, int cnt) {
		for (int t = 0; t < cnt; t++) {
			int tmp = map[sy][sx];
			for (int i = sx; i < ex; i++) {
				map[sy][i] = map[sy][i+1];
			}
			
			int tmp2 = map[ey][sx];
			for (int i = ey; i > sy; i--) {
				map[i][sx] = map[i-1][sx];
			}
			map[sy+1][sx] = tmp;
			
			tmp = map[ey][ex];
			for (int i = ex; i > sx+1; i--) {
				map[ey][i] = map[ey][i-1];
			}
			map[ey][sx+1] = tmp2;
			
			for (int i = sy; i < ey-1; i++) {
				map[i][ex] = map[i+1][ex];
			}
			map[ey-1][ex] = tmp;
		}
	}
}
