package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_안전영역_2468 {
	
	static int N, M, max;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				M = Math.max(M, num); //최대 높이 구하는 것
			}
		}
		findMaxSecureZone(1);
		System.out.println(max);
	}
	static void findMaxSecureZone(int h) { // 쵀대 안전 영역 구하는 함수 
		if(h >= M) return; //최대높이 이상일때 리턴
		
		visit = new boolean[N][N];
		int cnt = chkSecureZone(h);
		max = Math.max(max, cnt);
		
		findMaxSecureZone(h+1);
	}
	
	static int chkSecureZone(int h) {// h높이 이하인 경우, 안전 영역 세는 함수 
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > h && !visit[i][j]) {
					visit[i][j] = true;
					int y = i;
					int x = j;
					while(true) {
						boolean chk = false;
						
						for (int d = 0; d < 4; d++) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							
							if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
							if(visit[ny][nx]) continue;
							if(map[ny][nx] <= h) continue;
							else{
								visit[ny][nx] = true;
								chk = true;
								y = ny;
								x = nx;
								break;
							}
						}
						if(!chk) break;
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
}
