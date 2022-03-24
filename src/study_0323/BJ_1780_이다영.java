package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_종이의개수_1780 {
	static int N;
	static int[][]paper;
	static int[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		ans = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void count(int y, int x, int n) {
		if (n < 1) return;
		if(isSame(y, x, n)) return;
		
		n/=3;
		count(y, x, n);
		count(y, x+n, n);
		count(y, x+n+n, n);
		count(y+n, x, n);
		count(y+n, x+n, n);
		count(y+n, x+n+n, n);
		count(y+n+n, x, n);
		count(y+n+n, x+n, n);
		count(y+n+n, x+n+n, n);
		
	}
	
	public static boolean isSame(int y, int x, int n) {
		int num = paper[y][x];
		
		for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(paper[i][j] != num) {
					return false;
				}
			}
		}
		
		if(num == -1) ans[0] ++;
		else if(num == 0) ans[1] ++;
		else if (num == 1) ans[2] ++;
		return true;
	}
}
