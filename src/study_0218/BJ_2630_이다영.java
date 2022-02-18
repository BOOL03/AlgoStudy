package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이만들기_2630 {
	static int N, cntW, cntB;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(0, 0, N);
		
		System.out.println(cntW);
		System.out.println(cntB);
	}
	static void check(int y, int x, int n) {
		boolean chk = true;
		int num = map[y][x];
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(num!=map[i][j]) {
					chk = false;
					break;
				}
			}
		}
		
		if(!chk) {
			n /= 2;
			check(y, x, n);
			check(y, x+n, n);
			check(y+n, x, n);
			check(y+n, x+n, n);
		}
		else if(num == 1) cntB++;
		else if(num == 0) cntW++;
	}
}
