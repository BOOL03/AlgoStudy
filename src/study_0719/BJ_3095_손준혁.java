package study_0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3095_손준혁 {

	static char[][] map;
	static boolean[][] visited;
	
	static int[] delta_x = {-1,1};
	
	static int result = 0, N;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					calc(i,j);
				}
			}
		}
		System.out.println(result);
	}
	static void calc(int y, int x) {
		for (int i = y; i < N-y; i++) {
			int sideCheck = 0;
			for (int d = 0; d < 2; d++) {
				int dx = x + delta_x[d];
				if(dx < 0 || dx >= N) break;
				if(map[i][dx] == '1') sideCheck++;
			}
			if(sideCheck == 2) {
				int len = i-y;
				while(len > 0) {
					if(x + len >= N || x - len < 0) {
						len--;
						continue;
					}
					if(i+len >= N) {
						len--;
						continue;
					}
					
					if(check(y,x-(i-y),len,(i-y))) {
						result++;
						while(len > 1) {
							len--;
							result++;
						}
						break;
					}
					len--;
				}

			}
		}
	}
	static boolean check(int y, int x, int len, int cross) {
		int middle_y = y+cross;
		int middle_x = x+cross;
		if(middle_y+len > N || middle_x+len > N) return false; 
		
		for (int i = y; i < middle_y+len; i++) {
			for (int j = x; j < middle_x+len; j++) {
				if(i == middle_y || j == middle_x) {
					if(!(map[i][j] == '1')) return false;
				}
				else {
					if(!(map[i][j] == '0')) return false;
				}
			}
		}
		for (int i = y; i < middle_y+len; i++) {
			for (int j = x; j < middle_x+len; j++) {
				visited[i][j] = true;
			}
		}
		return true;
	}

}
