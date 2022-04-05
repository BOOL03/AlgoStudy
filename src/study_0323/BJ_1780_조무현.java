package study_0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780_조무현 {
	static int N;
	static int[][] board;
	static int[] cnt = new int[3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		split(0, 0, N);
		for (int c : cnt) {
			System.out.println(c);
		}
	}
	
	static void split(int r, int c, int L) {
		boolean valid = true;
		int st = board[r][c];
		if(L == 1) {
			cnt[st+1]++;
			return;
		}
		for (int i = r; i < r+L; i++) {
			for (int j = c; j < c+L; j++) {
				if(st != board[i][j]) {
					valid = false;
					split(r, c, L/3);
					split(r, c + L/3, L/3);
					split(r, c + (2*L)/3, L/3);
					
					split(r + L/3, c, L/3);
					split(r + L/3, c + L/3, L/3);
					split(r + L/3, c + (2*L)/3, L/3);
					
					split(r + (2*L)/3, c, L/3);
					split(r + (2*L)/3, c + L/3, L/3);
					split(r + (2*L)/3, c + (2*L)/3, L/3);
					return;
				}
			}
		}
		if(valid) {
			cnt[st+1]++;
		}
	}

	
}
