package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3085_조무현 {
	static int N;
	static char[][] board;
	static int[] dy = {0, -1}; // 우 하
	static int[] dx = {1, 0};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				swap(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	static void swap(int i, int j) {
		for (int k = 0; k < 2; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(board[i][j] != board[ny][nx]) { // 인접한 다른 사탕이라면 바꾼다
				char tmp = board[i][j];
				board[i][j] = board[ny][nx];
				board[ny][nx] = tmp;
				findMax();
				tmp = board[i][j];
				board[i][j] = board[ny][nx];
				board[ny][nx] = tmp;
			}
		}
	}
	
	static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int right_count = 1;
				char cur = board[i][j];
				int ny = i;
				int nx = j;
				while(true) {
					ny += dy[0];
					nx += dx[0];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) break;
					if(board[ny][nx] == cur) {
						right_count++;
					}
					else break;
				}
				ans = Math.max(ans, right_count);
				
				int y = i;
				int x = j;
				int down_count = 1;
				while(true) {
					y += dy[1];
					x += dx[1];
					if(y < 0 || x < 0 || y >= N || x >= N) break;
					if(board[y][x] == cur) {
						down_count++;
					}
					else break;
				}
				ans = Math.max(ans, down_count);
			}
		}
	}

}
