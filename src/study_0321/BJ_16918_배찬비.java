package study_0321;

import java.io.*;
import java.util.*;

public class BJ_16918_배찬비 {
	
	static int r, c, n;
	static char[][] arr;
	static int[][] bomb;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		bomb = new int[r][c];
		
		for(int i=0; i<r; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				if(arr[i][j]=='O') bomb[i][j] = 3;
			}
		}
		
		for(int sec=2; sec<=n; sec++) {
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(arr[i][j]=='.') {
						arr[i][j] = 'O';
						bomb[i][j] = sec+3;
					}
				}
			}
			sec++;
			if(sec>n) break;
			
			boolean[][] visited = new boolean[r][c];
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(bomb[i][j]==sec) {
						visited[i][j] = true;
						for(int k=0; k<4; k++) {
							int x = i+dx[k];
							int y = j+dy[k];
							if(x<0 || x>=r || y<0 || y>=c) continue;
							visited[x][y] = true;
						}
					}
				}
			}
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(visited[i][j]) {
						arr[i][j] = '.';
						bomb[i][j] = 0;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
