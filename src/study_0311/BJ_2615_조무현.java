package study_0311;

import java.util.Scanner;

public class BJ_2615_조무현 {
	// 8방 탐색
	static int[] dy = {-1, 0, 1, 1};
	static int[] dx = {1, 1, 1, 0};
	static int[][] map = new int[20][20];

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				map[i][j] = sc.nextInt();				
			}
		}
		//1 검은 바둑돌 2 흰바둑돌
		// 1, 2, 무승부 0
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				int cur = map[i][j];
				if(cur == 1 || cur == 2) {
					int dir = 0;
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny < 0 || nx < 0 || ny > 19 || nx > 19) continue;
						if(map[ny][nx] == cur) {
							int tmp_y = ny;
							int tmp_x = nx;
							int cnt = 0;
							while(true) {
								tmp_y += dy[k];
								tmp_x += dx[k];
								if(tmp_y < 0 || tmp_x < 0 || tmp_y > 19 || tmp_x > 19) break;
								if(map[tmp_y][tmp_x] == cur) cnt++;
								else break;
							}
							
							if(cnt == 3 && cur == 1) {
								int last_y = i + dy[k]*(-1);
								int last_x = j + dx[k]*(-1);
								if(last_y >= 0 && last_x >= 0 && last_y <=19 && last_x <=19) {
									if(map[last_y][last_x] != cur) {
										System.out.println(1);
										System.out.println(i + " " + j);
										return;
									}
								}
								
							}
							if(cnt == 3 && cur == 2) {
								int last_y = i + dy[k]*(-1);
								int last_x = j + dx[k]*(-1);
								if(last_y >= 0 && last_x >= 0 && last_y <=19 && last_x <=19) {
									if(map[last_y][last_x] != cur) {
										System.out.println(2);
										System.out.println(i + " " + j);
										return;
									}
								}
								
							}
						}
					}
					
				}
			}
		}
		System.out.println(0);
		
		
	}

}
