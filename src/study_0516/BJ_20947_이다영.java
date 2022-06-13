package study_0516;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_20947_이다영 {
	static char[][] map;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
	}
	
}
