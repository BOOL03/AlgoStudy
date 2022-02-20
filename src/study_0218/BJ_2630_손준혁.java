package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_손준혁 {
	static int N, N_size = 0, blueCount = 0, whiteCount = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		N_size = Integer.toBinaryString(N).length()-1;
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		QuadTree(N_size, 0, 0);
		System.out.println(whiteCount);
		System.out.println(blueCount);
	}
	static boolean check(int n, int x, int y) {
		int tmp = map[y][x];
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(tmp != map[i][j]) return false;
			}
		}
		
		return true;
	}
	static void QuadTree(int n, int x, int y) {// n_size, x, 
		if(n < 0) return;
		if(check((int) Math.pow(2, n),x,y)) {
			if(map[y][x] == 1) blueCount++;
			else whiteCount++;
		}
		else {
			int n_size = (int) Math.pow(2, n-1);
			QuadTree(n-1,x,y);
			QuadTree(n-1, x+n_size, y);
			QuadTree(n-1, x, y+n_size);
			QuadTree(n-1, x+n_size, y+n_size);
		}
	}
}
