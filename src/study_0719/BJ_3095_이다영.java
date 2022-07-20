package study_0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3095_이다영 {
	
	static int N;
	static char[][] map;
	
	static int count;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1}; // 상하좌우 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				if(map[i][j] == '1') {
					for (int k = 1; k <= (N-1)/2 ;        k++) {
						if(findPlus(i, j, k)) count++;
						else break;
					}                                                                        
				}
			}
		}
		
		System.out.println(count);
		
	
	}
	public static boolean findPlus (int y, int x, int k) {
		
		for (int d = 0; d < 4; d++) {
			
			int ny = dy[d]*k + y;
			int nx = dx[d]*k + x;
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) return false;
			if(map[ny][nx] == '0') return false;
		}
		
		
		for (int j = x-k; j <= x+k; j++) {
			if( j == x ) continue;
			if(map[y-k][j] == '1') return false;
		}
		
		for (int i = y-k; i <= y+k ; i++) {
			if(i == y) continue;
			if(map[i][x-k] == '1') return false;
		}
		
		for (int i = y-k; i <= y+k ; i++) {
			if(i == y) continue;
			if(map[i][x+k] == '1') return false;
		}
		
		for (int j = x-k; j <= x+k; j++) {
			if( j == x ) continue;
			if(map[y+k][j] == '1') return false;
		}
		
		return true;
	}
}
