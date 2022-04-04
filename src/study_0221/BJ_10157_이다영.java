package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BJ_10157_이다영 {
	static int C, R, M;
	static int[][]map;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		if(M > C*R) {
			System.out.println(0);
			return;
		}
		
		map = new int[R][C];
		
		int y = 0;
		int x = 0;
		int d = 0; //direction 방향을 의미
		
		int num = 1; // 배열안에 넣는 증가하는 수
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.println(num);
				System.out.println(x + " " + y);
				if(num == M) {
					System.out.println((j+1) + " " + (R-i));
					return;
				}
				map[y][x] = num++;
				
				if (d == 0 ) { // 우    - 하 
					if(y + dy[d] >= R || map[y+dy[d]][x] !=0 ){ //범위를 벗어나거나 이미 지나간 경우일 때에만 방향을 바꿈
						d = 1;
					}
				}else if( d == 1){ // 하 - 우
					if(x + dx[d] >= C || map[y][x+dx[d]] !=0 ) { //범위를 벗어나거나 이미 지나간 경우일 때에만 방향을 바꿈
						d = 2;
					}
				}else if( d == 2){ // 좌 - 상
					if(y + dy[d] < 0 || map[y+dy[d]][x] !=0 )  { //범위를 벗어나거나 이미 지나간 경우일 때에만 방향을 바꿈
						d = 3;
					}
				}else if( d == 3) { // 상 - 좌
					if(x + dx[d] < 0 || map[y][x+dx[d]] !=0 ){ //범위를 벗어나거나 이미 지나간 경우일 때에만 방향을 바꿈
						d = 0;
					}
				}
				y += dy[d];
				x += dx[d];
			}
		}
	}

}
