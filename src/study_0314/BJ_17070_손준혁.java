package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_손준혁 {
	static int count =0, N;
	static int[] delta_x = {1,0,1};
	static int[] delta_y = {0,1,1};
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(map[N-1][N-1] == 1) {
			System.out.println(0);
			return;
		}
		//DFS(1,1,0);
		DFS2(0,1,0);
		System.out.println(count);
	}
	public static void DFS2(int x, int y, int d) {
		if(x == N-1 && y == N-1 && map[x][y] != 1) {
			count++;
			return;
		}
		
		// 현재 놓여있는 막대가 가로일 때
		if(d == 0) {
			// 오른쪽으로 한칸 움직이기
			if(check(x, y+1) && map[x][y+1] == 0) {
				DFS2(x, y+1, 0);
			}
			
			// 오른쪽 아래 대각선으로 움직이기
			if(check(x+1, y+1) && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0) {
				DFS2(x+1, y+1, 2); 
			}
			
		} else if(d == 1) { // 막대가 세로 일 때
			// 밑으로 움직이기
			if(check(x+1, y) && map[x+1][y] == 0) {
				DFS2(x+1, y, 1);
			}
			
			// 오른쪽 아래로 움직이기
			if(check(x+1, y+1) && map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0) {
				DFS2(x+1, y+1, 2);
			}
			
		} else if(d == 2) {	// 막대가 대각선일 때
			// 가로로 움직이기
			if(check(x, y+1) && map[x][y+1] == 0) {
				DFS2(x, y+1, 0);
			}
			
			// 세로로 움직이기
			if(check(x+1, y) && map[x+1][y] == 0) {
				DFS2(x+1,y, 1);
			}
			
			// 대각선으로 움직이기
			if(check(x+1, y+1) && map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0) {
				DFS2(x+1,y+1,2);
			}	
		}
	}
	
	public static boolean check(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
//	static void DFS(int dir, int x, int y) {
//	if(x == N && y == N) {
//		count++;
//		return;
//	}
//	
//	int dx = 0, dy = 0;
//	int continue_num = -1;
//	switch(dir) {
//	case 1:
//		continue_num = 1;
//		break;
//	case 2:
//		continue_num = 0;
//		break;
//	case 3:
//		continue_num = -1;
//		break;
//	}
//	for (int i = 0; i < 3; i++) {
//		if(continue_num == i) continue;
//		boolean check = true;
//		if(i == 2) {
//			for (int j = 0; j < 3; j++) {
//				dx = x + delta_x[j];
//				dy = y + delta_y[j];
//				if(dx < 0 || dx > N || dy < 0 || dy > N || map[dy][dx] == 1) {
//					check = false;
//					break;
//				}
//			}
//		}
//		else {
//			dx = x + delta_x[i];
//			dy = y + delta_y[i];
//			if(dx < 0 || dx > N || dy < 0 || dy > N || map[dy][dx] == 1) check = false;
//		}
//		if(!check) continue;
//		DFS(i+1, dx, dy);
//	}
//}
}
