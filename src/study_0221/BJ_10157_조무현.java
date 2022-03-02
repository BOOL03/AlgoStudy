package study_0221;

import java.util.Scanner;

public class BJ_10157_조무현 {
	static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
	static int[] dy = {1, 0, -1, 0}; 
	static int cnt = 1;
	static int[][] map;
	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		int cnt = 1;
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); // 가로
		int R = sc.nextInt(); // 세로
		int K = sc.nextInt();
		map = new int[R+1][C+1];
		int[] limit = new int[4];
		limit[0] = R; // 상방향 제한
		limit[1] = C; // 우방향 제한
		limit[2] = 1; // 하방향 제한
		limit[3] = 1; // 좌방향 제한
		int dir = 0;
		
		if(K > C*R) {
			System.out.println("0");
			return;
		}
		while(true) {
			if(cnt == K) break;
			int nx, ny;
			// 방향을 바꿀때는 limit을 바꿔주고 방향을 바꾼다.
			switch(dir) {
			case 0:
				nx = x + dx[0];
				ny = y + dy[0];
				if(ny > limit[0]) {
					limit[0]--;
					dir = (dir+1)%4;
					break;
				}
				x = nx;
				y = ny;
				cnt++;
				break;
			case 1:
				nx = x + dx[1];
				ny = y + dy[1];
				if(nx > limit[1]) {
					limit[1]--;
					dir = (dir+1)%4;
					break;
				}
				x = nx;
				y = ny;
				cnt++;
				break;
			case 2:
				nx = x + dx[2];
				ny = y + dy[2];
				if(ny < limit[2]) {
					limit[2]++;
					dir = (dir+1)%4;
					break;
				}
				x = nx;
				y = ny;
				cnt++;
				break;
			case 3:
				nx = x + dx[3];
				ny = y + dy[3];
				if(nx <= limit[3]) {
					limit[3]++;
					dir = (dir+1)%4;
					break;
				}
				x = nx;
				y = ny;
				cnt++;
				break;
			}
			
			
		}
		
		System.out.println(x + " " + y);

	}

}
