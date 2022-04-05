package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_조무현 {
	static int R, C, N;
	static int[][] board;
	static int[][] spreadmise;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] cleaner = new int[2];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		spreadmise = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cindex = 0;
		for (int i = 0; i < R; i++) {
			if(board[i][0] == -1) cleaner[cindex++] = i;
		}
		
		for (int i = 0; i < N; i++) {
			spread();
//			printboard();
			clean();
//			printboard();
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j] != -1) sum += board[i][j];
			}
		}		
		System.out.println(sum);
		
	}
	
	static void printboard() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	// 공기 청정기 바람
	static void clean() {
		
		int [][]tmp_board = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp_board[i][j] = board[i][j];
			}
		}
		
		int r = cleaner[0];
		// 오른쪽
		for (int i = C-1; i >= 2; i--) {
			tmp_board[r][i] = board[r][i-1];
		}
		tmp_board[r][1] = 0;
		// 위
		for (int i = 0; i <= r-1; i++) {
			tmp_board[i][C-1] = board[i+1][C-1];
		}
		
		// 왼쪽
		for (int i = 0; i <= C-2; i++) {
			tmp_board[0][i] = board[0][i+1];
		}
		
		// 아래
		for (int i = r-1; i >= 1; i--) {
			tmp_board[i][0] = board[i-1][0];
		}
		
		r = cleaner[1];
		// 오른쪽
		for (int i = C-1; i >= 2; i--) {
			tmp_board[r][i] = board[r][i-1];
		}
		tmp_board[r][1] = 0;
		// 아래
		for (int i = R-1; i >= r+1; i--) {
			tmp_board[i][C-1] = board[i-1][C-1];
		}
		// 왼쪽
		for (int i = 0; i <= C-2; i++) {
			tmp_board[R-1][i] = board[R-1][i+1];
		}
		// 위
		for (int i = r+1; i <= R-2; i++) {
			tmp_board[i][0] = board[i+1][0];
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = tmp_board[i][j];
			}
		}
		
		
	}
	
	
	// 확산
	static void spread() {
		// 배열 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				spreadmise[i][j] = 0;
			}
		}
		
		// 현재 위치의 미세먼지 계산
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(board[i][j] > 0) {
					int valid_dir = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nc < 0 || nr >= R || nc >= C || board[nr][nc] == -1) continue;
						valid_dir++;
						spreadmise[nr][nc] += (board[i][j] / 5);
					}
					board[i][j] -= (board[i][j]/5) * valid_dir;					
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] += spreadmise[i][j];
			}
		}
		
	}

}
