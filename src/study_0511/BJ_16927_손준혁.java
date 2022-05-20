package study_0511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16927_손준혁 {
	static int[][] map;
	static int M,N,R;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x_start = 0;
		int x_end = M - 1;
		int y_start = 0;
		int y_end = N - 1;
		while (true) {
			int repeat = (x_end - x_start + 1)*2+(y_end - y_start + 1)*2 - 4;
			spin(x_start,x_end,y_start,y_end, R%repeat);
			x_start++;
			x_end--;
			y_start++;
			y_end--;
			if(x_start > x_end || y_start > y_end) break;
		}
		
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void spin(int x_start, int x_end, int y_start, int y_end, int repeat) {
		//int repeat = Math.min(M, N) / 2;
		for (int r = 0; r < repeat; r++) {
			int temp = map[y_start][x_start];

			for(int j=x_start;j<x_end;j++) {
				map[y_start][j] = map[y_start][j+1]; 
			}
			
			for(int i=y_start;i<y_end;i++) {
				map[i][x_end] = map[i+1][x_end];
			}
			
			for(int j=x_end;j>x_start;j--) {
				map[y_end][j] = map[y_end][j-1];
			}
			
			for(int i=y_end;i>y_start;i--) {
				map[i][x_start] = map[i-1][x_start];
			}
			map[y_start+1][x_start] = temp;
		}
	}

}
