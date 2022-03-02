package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_조무현 {

	static int N;
	static char[][] map;
	static int[] color = new int[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		char input;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		split(0, 0, N);
		System.out.println(color[0]);
		System.out.println(color[1]);
	}
	private static void split(int y, int x, int n) {
		if(n < 1) return;
		int result = check(y, x, y+n, x+n);
		if(result < 0) { // n/2로 split
			int half = n/2;
			split(y, x, half);
			split(y, x + half, half);
			split(y+half, x, half);
			split(y+half, x+half, half);
		}else {
			color[result]++;
		}
	}
	
	static int check(int y1, int x1, int y2, int x2) {
		// 첫 문자와 다른지 안다른지
		boolean constant = true;
		char start = map[y1][x1];
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				if(start != map[i][j]) constant = false;
			}
		}
		
		if(constant) return start - '0';
		return -1;
	}

}
