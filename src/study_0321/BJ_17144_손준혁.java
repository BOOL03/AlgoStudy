package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_손준혁 {
	static int R,C,N;
	static int[] cleaner = new int[2];
	static int[] delta_x = { 0, 1, 0,-1};
	static int[] delta_y = {-1, 0, 1, 0};
	static int[][] map, dust_map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		dust_map = new int[R][C];
		int cleaner_count = 0;
		for (int y = 0; y < R; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < C; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				dust_map[y][x] = map[y][x];
				if(map[y][x] == -1) cleaner[cleaner_count++] = y;
			}
		}
		for (int i = 0; i < N; i++) {
			spreaddust();
			spinTop();
			spinBottom();
			copyMap();
		}
		System.out.println(countDust());
	}
	static void spinTop() {
		for (int y = cleaner[0]; y > 0; y--) {
			map[y][0] = map[y-1][0];
		}
		for (int x = 0; x < C-1; x++) {
			map[0][x] = map[0][x+1];
		}
		for (int y = 0; y < cleaner[0]; y++) {
			map[y][C-1] = map[y+1][C-1];
		}
		for (int x = C-1; x > 1; x--) {
			map[cleaner[0]][x] = map[cleaner[0]][x-1];
		}
		map[cleaner[0]][1] = 0;
		map[cleaner[0]][0] = -1;
	}
	static void spinBottom() {
		for (int y = cleaner[1]; y < R-1; y++) {
			map[y][0] = map[y+1][0];
		}
		for (int x = 0; x < C-1; x++) {
			map[R-1][x] = map[R-1][x+1];
		}
		
		for (int y = R-1; y > cleaner[1]; y--) {
			map[y][C-1] = map[y-1][C-1];
		}
		for (int x = C-1; x > 1; x--) {
			map[cleaner[1]][x] = map[cleaner[1]][x-1];
		}
		map[cleaner[1]][1] = 0;
		map[cleaner[1]][0] = -1;
	}
	static void spreaddust() {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if(dust_map[y][x] > 0 ) { // 먼지가 있을 경우
					int[] ways = returnWay(x,y);
					int spread = (dust_map[y][x] / 5)*ways[0];
					if(dust_map[y][x] - spread > 0 ) { //먼지가 확산될만큼은 있을경우
						map[y][x] -= spread;
						for (int i = 1; i <= 4; i++) { // 먼지 확산
							if(ways[i] == 0) continue;
							int dx = x + delta_x[i-1];
							int dy = y + delta_y[i-1];
							map[dy][dx] += spread/ways[0];
						}
					}
				}
				
			} //for : x
		}
		copyMap();
	}
	static void copyMap() {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				dust_map[y][x] = map[y][x];
			}
		}
	}
	static int[] returnWay(int x, int y) {
		int[] result = new int[5];
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int dx = x + delta_x[i];
			int dy = y + delta_y[i];
			if(dx < 0 || dx >= C || dy < 0 || dy >= R || map[dy][dx] < 0) continue;
			result[i+1] = 1;
			count++;
		}
		result[0] = count;
		return result;
	}
	static int countDust() {
		int sum = 0;
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if(map[y][x] > 0) sum += map[y][x];
			}
		}
		return sum;
	}
}
