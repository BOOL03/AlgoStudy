package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16918_조무현 {
	static int R, C, N;
	static char[][] board;
	static int[][] time;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 초기 상태
		board = new char[R][C];
		time = new int[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				time[i][j] = 0;
			}
		}
		// N만큼
		int cnt = 0;
		while(true) {
			cnt++;
			second();
			if(cnt == N+1) break;
			
			// 각 초별로 행동
			if(cnt == 1) continue;
			else if( cnt == 2) {
				fill();
			}
			
			else if( cnt == 3 ) {
				boom();
			}
			
			else if( cnt > 3 && cnt % 2 == 0) {
				fill();
			}
			else {
				boom();
			}
			
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	// 초별로 board 상태 변화
	// 시간 증가
	static void second() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j] == 'O') {
					time[i][j]++;
				}
			}
		}
	}
	//남은 칸 폭탄 채우기
	static void fill() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j] == '.') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	// 폭발
	static void boom() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j] == 'O' && time[i][j] == 3) {
					board[i][j] = '.';
					time[i][j] = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nc < 0 || nr >= R || nc >= C || (board[nr][nc] == 'O' && time[nr][nc] == 3)) continue;
						board[nr][nc] = '.';
						time[nr][nc] = 0;
					}
				}
			}
		}
	}

}
