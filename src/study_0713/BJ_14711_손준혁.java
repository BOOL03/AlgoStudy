package study_0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14711_손준혁 {
	static char[][] map;
	static int[][] check;
	
	static int delta_y[] = { 0, 0, 1 };
	static int delta_x[] = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		check = new int[n][n];
		
		char[] tmp = br.readLine().toCharArray();
		
		for (int i = 0; i < n; i++) {
			map[0][i] = tmp[i];
			sb.append(map[0][i]);
		}
		sb.append('\n');
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '#') {
					check[i][j]++;
					for (int d = 0; d < 3; d++) {
						int dx = j + delta_x[d];
						int dy = i + delta_y[d];
						if(dx<0 ||dx>=n || dy<0 || dy>=n) continue;
						check[dy][dx]++;
					}
				}
			}

			for(int j=0;j<n;j++) {
				if(check[i][j]%2==0) {
					if(map[i][j] == '#') {
						map[i+1][j] = '#';
					}
					else {
						map[i+1][j] = '.';
					}
					sb.append(map[i+1][j]);
				}else {
					if(map[i][j] == '#') {
						map[i+1][j] = '.';
					}
					else {
						map[i+1][j] = '#';
					}
					sb.append(map[i+1][j]);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
