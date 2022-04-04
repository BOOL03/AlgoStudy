package study_0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1347_이다영 {
	static int N;
	static char[][] map;
	
	static int[] dy = {0, 1, 0, -1}; //우남좌북
	static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String command = br.readLine();
		
		map = new char[101][101];
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				map[i][j] = '#';
			} 
		}
		
		int i = 50;
		int j = 50;
		int d = 1; // 남부터 시작
		int minX = j;
		int minY = i;
		int maxX = j;
		int maxY = i;
		
		map[i][j] = '.';
		
		for (int k = 0; k < N; k++) {
			char c = command.charAt(k);
			
			switch (c) {
				case 'R': d = (d+1)%4; break;
				case 'L': d = d-1 < 0 ? 3 : d-1; break;
				case 'F': 
					i += dy[d];
					j += dx[d];
					map[i][j] = '.';
					minX = Math.min(minX, j);
					minY = Math.min(minY, i);
					maxX = Math.max(maxX, j);
					maxY = Math.max(maxY, i);
					break;
			}
		}
		
		
		
		for (int y= minY; y <= maxY; y++) {
			for (int x = minX; x <= maxX; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
	}
}
