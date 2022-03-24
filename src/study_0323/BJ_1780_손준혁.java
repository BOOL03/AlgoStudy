package study_0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780_손준혁 {
	static int count_min = 0, count_zero = 0, count_one = 0, N_sqrt = 0;
	static int[][] board;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		N_sqrt = (int) Math.sqrt(N);
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0,N);
		System.out.println(count_min);
		System.out.println(count_zero);
		System.out.println(count_one);
		
	}
	static void dfs(int dp, int x, int y, int length) {
		if(dp > N_sqrt) {
			return;
		}
		boolean result = check(x,y,length);
		if(result) return;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				dfs(dp+1, x+j*(length/3), y+i*(length/3), length/3);
			}
		}
	}
	static boolean check(int x, int y, int length) {
		int data = board[y][x];
		for (int i = y; i < y+length; i++) {
			for (int j = x; j < x+length; j++) {
				if(board[i][j] != data) return false;
			}
		}
		switch(data) {
		case -1:
			count_min++;
			break;
		case 1:
			count_one++;
			break;
		case 0:
			count_zero++;
			break;
		}
		return true;
	}
}
