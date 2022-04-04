package study_0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
3
r  g  b
26 40 83
49 60 57
13 89 99
 */

public class BJ_1149_이다영 {
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int [N][3];
		min =Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				src[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 3; i++) {
			dfs(0,i,0);
		}
		
		System.out.println(min);
		
	}
	
	static void dfs(int srcIdx, int colorIdx, int price) {		
		if(srcIdx == N) {
			min = Math.min(min, price);
			return;
		}
		
		for (int j = 0; j < 3; j++) {//colorIdx
			if(colorIdx != j) dfs(srcIdx + 1, j, price + src[srcIdx][colorIdx]);
		}
	}
}
