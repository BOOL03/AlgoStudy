package study_0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14711_이다영 {
	
	static char[][] map;
	static int[][] cnt;
	static int N;
	
	static int[] dy = {0, 1, 0};
	static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		cnt = new int[N][N];

		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			map[0][i] = str.charAt(i);
			sb.append(map[0][i]);
		}
		sb.append('\n');
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '#') {
					cnt[i][j]++;
					for (int d = 0; d < 3; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						
						if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
						
						cnt[ny][nx]++;
					}
				}

			}
			
			for (int j = 0; j < N; j++) {
				if(cnt[i][j] % 2 == 0) {
					map[i+1][j] = map[i][j] == '#' ? '#' : '.';
					sb.append(map[i+1][j]);
				}
				else {
					map[i+1][j] = map[i][j] == '#' ? '.' : '#';
					sb.append(map[i+1][j]);
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
