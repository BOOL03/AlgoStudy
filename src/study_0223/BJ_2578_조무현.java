package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_조무현 {
	static int[][] map = new int[5][5];
	static int[][] num = new int[5][5];
	static int[] row = new int[5];
	static int[] col = new int[5];
	static int dir1 = 0;
	static int dir2 = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int[] bingo = findIndex(num[i][j]);
				row[bingo[0]]++;
				col[bingo[1]]++;
				if(isDir(bingo[0], bingo[1])) { // 대각선 방향에 있을때
					if(bingo[0] == bingo[1]) {
						if(bingo[0] == 2) {
							dir1++;
							dir2++;							
						}
						else dir1++;
					}
					else dir2++;
				}
				cnt++;
				if(isBingo()) {
					System.out.println(cnt);
					return;
				}
			}
		}
		
		
	}
	static boolean isDir(int i, int j) {
		if(Math.abs(i-2) == Math.abs(j-2)) return true;
		return false;
	}
	static boolean isBingo() {
		int cnt = 0;
		if(dir1 == 5) cnt++;
		if(dir2 == 5) cnt++;
		for (int i = 0; i < 5; i++) {
			if(row[i] == 5)cnt++;
			if(col[i] == 5)cnt++;
		}
		if(cnt >= 3) return true;
		return false;
	}
	static int[] findIndex(int x) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == x) return new int[]{i, j};
			}
		}
		return null;
	}

}
