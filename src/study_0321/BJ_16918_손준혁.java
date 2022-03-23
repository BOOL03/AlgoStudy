package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16918_손준혁 {
	static int R,C,N;
	static int[] delta_x = { 0, 1, 0,-1};
	static int[] delta_y = {-1, 0, 1, 0};
	static char[][] map, past_map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		past_map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmps = br.readLine().toCharArray();
			map[i] = tmps;
			//past_map[i] = tmps;
		}
		boom();
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
		return;
	}
	static void boom() {
		for (int i = 1; i < N; i++) {
			if(i%2 == 1) { // 폭탄 심기 -> i&1 == 1
				copyMap();
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						map[y][x] = 'O';
					}
				}
			}
			else { // 폭탄 터트리기
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						if(past_map[y][x] == 'O') delta(x, y);
					}
				}
			}
		}
	}
	static void delta(int x, int y) {
		map[y][x] = '.';
		for (int i = 0; i < 4; i++) {
			int dx = x + delta_x[i];
			int dy = y + delta_y[i];
			if(dx < 0 || dx >= C || dy < 0 || dy >= R) continue;
			map[dy][dx] ='.'; 
		}
	}
	static void copyMap() {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				past_map[y][x] = map[y][x];
			}
		}
	}
}
