package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_이다영 {
	static int N, ans;
	static int[][] map;
	
	static int[] dy = {0, 1, 1}; //가로, 세로, 대각선
	static int[] dx = {1, 0, 1};

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
		pipe(0, 1, 1);
		
		System.out.println(ans);
		
		
	}
	public static boolean pipe(int y, int x, int dir) {
		// 도착한 경우 return
		if(y == N-1 && x == N-1) {
			ans++;
			return true;
		}
		
		if(dir == 1) {// 가로인 경우
			// 가로
			int ny = y + dy[0];
			int nx = x + dx[0];
			if(ny < N && nx < N && map[ny][nx] == 0) pipe(ny, nx, 1);
			
			// 대각선
			for (int d = 0; d < 3; d++) {
				int tmpy = y + dy[d];
				int tmpx = x + dx[d];
				
				if(tmpy >= N || tmpx >= N || map[tmpy][tmpx] == 1) return false;
			}
			ny = y + dy[2];
			nx = x + dx[2];
			pipe(ny, nx, 3);
		}
		
		else if(dir == 2) {// 세로인 경우
			// 세로
			int ny = y + dy[1];
			int nx = x + dx[1];
			if(ny < N && nx < N && map[ny][nx] == 0) pipe(ny, nx, 2);
			
			// 대각선
			for (int d = 0; d < 3; d++) {
				int tmpy = y + dy[d];
				int tmpx = x + dx[d];
				
				if(tmpy >= N || tmpx >= N || map[tmpy][tmpx] == 1) return false;
			}
			ny = y + dy[2];
			nx = x + dx[2];
			pipe(ny, nx, 3);
		}
		
		else if(dir == 3) {// 대각선인 경우
			// 세로, 가로
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < N && nx < N && map[ny][nx] == 0) pipe(ny, nx, d+1);
			}
			
			// 대각선
			for (int d = 0; d < 3; d++) {
				int tmpy = y + dy[d];
				int tmpx = x + dx[d];
				
				if(tmpy >= N || tmpx >= N || map[tmpy][tmpx] == 1) return false;
			}
			int ny = y + dy[2];
			int nx = x + dx[2];
			pipe(ny, nx, 3);
		}
		return false;
	}
}
