package study_0516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14600_이다영 {
	static int[][] map;
	static int N, X, Y;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 2*Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken())-1;
		Y = N-Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		if(N == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == Y && X == j) sb.append("-1 ");
					else sb.append("1 ");
				}
				sb.append('\n');
			}
			System.out.println(sb);
		}else {
			map[Y][X] = -1;
			divide();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}
	public static void divide() {
		 if (Y <= 1 && X <= 1) {//1사분면
			 map[1][2] = 3;
			 map[2][1] = 3;
			 map[2][2] = 3;
		 }
		 else if (Y <= 1 && X > 1) { // 2사분면
			 map[1][1] = 3;
			 map[2][1] = 3;
			 map[2][2] = 3;
		 }
		 else if (Y > 1 && X <= 1) { // 3사분면
			 map[1][1] = 3;
			 map[1][2] = 3;
			 map[2][2] = 3;
		 }else if (Y > 1 && X > 1) { // 4사분면
			 map[1][1] = 3;
			 map[1][2] = 3;
			 map[2][1] = 3;
		 }
		 tile(0, 0, 4);
		 tile(0, 2, 5);
		 tile(2, 0, 1);
		 tile(2, 2, 2);
	}
	public static void tile (int y, int x, int num) {
		for (int i = y; i < y+2; i++) {
			for (int j = x; j < x+2; j++) {
				if(map[i][j] == 0) map[i][j] = num;
			}
		}
	}
}
