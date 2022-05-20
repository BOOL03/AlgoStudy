package study_0516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_20947_손준혁 {
	static int N;
	
	static char[][] map;
	static int[][][] mapCalc;
	
	static int[] delta_x = {0,0,1,0,-1};
	static int[] delta_y = {0,1,0,-1,0};
	
	static List<point> list = new ArrayList<>();
	static List<point> bomb = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		mapCalc = new int[N][N][2]; // . . 0 : 방향 | . . 1 : 중복 카운트
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j];
				if(tmp[j] == 'X') {
					list.add(new point(j,i));
				}
			}
		}
		addBomb();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				//System.out.print(map[i][j]+" ");
//				System.out.print(mapCalc[i][j][1]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		removeBomb();
		for (int i = 0; i < bomb.size(); i++) {
			map[bomb.get(i).y][bomb.get(i).x] = 'B';
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.print(map[i][j]+" ");
				if(mapCalc[i][j][1] > 1) {
					System.out.print("B ");
				}
				else {
					System.out.print(map[i][j]+" ");
				}
				//System.out.print(mapCalc[i][j][1]+" ");
			}
			System.out.println();
		}
	}
	static void addBomb() {
		for (int i = 0; i < list.size(); i++) {
			for (int d = 1; d < 5; d++) {
				int dx = list.get(i).x + delta_x[d];
				int dy = list.get(i).y + delta_y[d];
				if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
				if(map[dy][dx] != '.') continue;
				if(mapCalc[dy][dx][0] == (d+2)%4) continue;
				
				int cx = dx;
				int cy = dy;
				while(true) {
					if(cx < 0 || cx >= N || cy < 0 || cy >= N) break;
					if(map[cy][cx] == 'O' || map[cy][cx] == 'X') break;
					mapCalc[cy][cx][1]++;
					cx += delta_x[d];
					cy += delta_y[d];
					
				}
			}
			
		}
	}
	static void removeBomb() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'O') {
					for (int d = 1; d < 5; d++) {
						int dx = j + delta_x[d];
						int dy = i + delta_y[d];
						if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
						if(mapCalc[dy][dx][1] == 0) continue;
						
						int cx = dx;
						int cy = dy;
						while(true) {
							if(cx < 0 || cx >= N || cy < 0 || cy >= N) break;
							if(mapCalc[cy][cx][1] == 0) break;
							mapCalc[cy][cx][1]--;
							cx += delta_x[d];
							cy += delta_y[d];
						}
					}
				}
			}
		}
	}
	static class point{
		int x;
		int y;
		public point() {}
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
