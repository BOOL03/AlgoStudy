package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ_2578_손준혁 {
	static int bingo, X,Y;
	static int[][] board, visited;
	
	static int[] delta_x = { 0, 1, 1, 1, 0,-1,-1,-1};
	static int[] delta_y = { 1, 1, 0,-1,-1,-1, 0, 1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		board = new int[5][5];
		visited = new int[5][5];
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int result = find(Integer.parseInt(st.nextToken()));
				if(result != -1) bingo = check();
				
				if(bingo >= 3) {
					System.out.println(i+" "+j);
					int count = (i*5)+(j+1);
					System.out.println(count);
					return;
				}
			}
		}
	}
	static int find(int data) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(board[i][j] == data) {
					visited[i][j] = 1;
					X = j;
					Y = i;
					return i;
				}
			}
		}
		return -1;
	}
	static int check() {
		int cnt = 0;
		// 가로 
		for (int i = 0; i < 5; i++) {
			int rcnt = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == 1) rcnt++;
			}
			if (rcnt == 5) cnt++;
		}

		// 세로 
		for (int i = 0; i < 5; i++) {
			int ccnt = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[j][i] == 1) ccnt++;
			}
			if (ccnt == 5) cnt++;
		}
		// 우상향
		int ccnt = 0;
		for (int i = 4; i >= 0; i--) {

			if (visited[4-i][i] == 1) ccnt++;
			if (ccnt == 5) cnt++;
		}

		// 우하향
		ccnt= 0;
		for ( int i=0; i<5; i++) {
			if ( visited[i][i] == 1 ) ccnt++;
			if (ccnt == 5) cnt ++;
		}
		return cnt;
	}
}
