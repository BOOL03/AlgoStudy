package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615_이다영 {
	
	static int N;
	static int[][] map;
	
	static int[] dy = {-1, 0, 1, 1}; //상우, 우, 하우, 하
	static int[] dx = {1, 1, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 20;
		map = new int[N][N];
		
		for (int i = 1; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int num = map[i][j];
				if(num!=0) {
					for (int d = 0; d < 4; d++) {
						int y = i;
						int x = j;
						
						for (int k = 0; k < 6; k++) {
							if(k==0) {
								int ny = y-dy[d];
								int nx = x-dx[d];
								
								if(ny < 1 || nx <1 || ny>= N || nx>=N) continue;
								if(num == map[ny][nx]) break;
								
							}
							else if(k==5) {
								int ny = y+k*dy[d];
								int nx = x+k*dx[d];
								
								if(ny < 1 || nx <1 || ny>= N || nx>=N || num!= map[ny][nx]) {
									System.out.println(num);
									System.out.println(i + " " + j);
									return;
								}
							}
							else {
								int ny = y+k*dy[d];
								int nx = x+k*dx[d];
								if(ny < 1 || nx <1 || ny>= N || nx>=N || num!= map[ny][nx]) break;
							}
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}
