package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_조무현 {
	static int N;
	static int[][] map;
	static int cnt = 0;
	static int mydir = 0;
	static int[] dy = {0, 1, 1}; // 오른쪽이랑 아래만
	static int[] dx = {1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 1,1부터 시작
		map = new int[N+1][N+1];
		StringTokenizer st = null;
		// 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 2, mydir);
		System.out.println(cnt);
	}
	
	static void dfs(int y, int x, int dir) {
		if(y == N && x == N) {
			cnt++;
			return;
		}
		int tmp_y = y;
		int tmp_x = x;
		int ny, nx;
		// 위아래 방향
		for (int i = 0; i < 2; i++) {
			ny = dy[i] + tmp_y;
			nx = dx[i] + tmp_x;
			if(ny < 0 || nx < 0 || ny > N || nx > N || map[ny][nx] == 1 ) continue;
			if(dir != 2 && dir != i) continue;
			mydir = i;
			dfs(ny, nx, mydir);
		}
		// 아래 대각선 방향
		boolean valid = true;
		for (int i = 0; i < 3; i++) {
			ny = dy[i] + tmp_y;
			nx = dx[i] + tmp_x;
			if(ny < 0 || nx < 0 || ny > N || nx > N || map[ny][nx] == 1) {
				valid = false;
				break;
			}
		}
		if(valid) {
			mydir = 2;
			dfs(dy[2] + tmp_y, dx[2] + tmp_x, mydir);
		}
	}

}
