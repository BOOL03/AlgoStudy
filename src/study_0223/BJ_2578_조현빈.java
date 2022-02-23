package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_조현빈 {
	static int[][] board;
	static int[][] coord;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		coord = new int[26][2];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j]   = num;
				coord[num][0] = i;
				coord[num][1] = j;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt = 0;
				int num = Integer.parseInt(st.nextToken());
				int y   = coord[num][0];
				int x   = coord[num][1];
				board[y][x]  = -1;
				cnt         += rCheck();
				cnt         += cCheck();
				cnt         += rlCheck();
				cnt         += lrCheck();
				if (cnt >= 3) {
					System.out.println((i * 5 + j) + 1);
					return;
				}
			}
		}

	}

	static int rCheck() {
		int cnt2 = 0;
		for (int i = 0; i < 5; i++) {
			int cnt1 = 0;
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == -1) cnt1++;
			}
			if (cnt1 == 5) {
				cnt2++;
			}
		}
		return cnt2;
	}

	static int cCheck() {
		int cnt2 = 0;
		for (int i = 0; i < 5; i++) {
			int cnt1 = 0;
			for (int j = 0; j < 5; j++) {
				if (board[j][i] == -1) cnt1++;
			}
			if (cnt1 == 5) {
				cnt2++;
			}
		}
		return cnt2;
	}

	static int lrCheck() {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][i] == -1) cnt1++;
		}
		if (cnt1 == 5) cnt2++;
		return cnt2;
	}

	static int rlCheck() {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][4 - i] == -1) cnt1++;
		}
		if (cnt1 == 5) cnt2++;
		return cnt2;
	}
}
