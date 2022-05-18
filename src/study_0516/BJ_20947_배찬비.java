package study_0516;
import java.io.*;
import java.util.*;

public class BJ_20947_배찬비 {
	
	static int n;
	static char[][] city;
	static Queue<int[]> OQ = new ArrayDeque<>();
	static Queue<int[]> XQ = new ArrayDeque<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		city = new char[n][n];
		
		for(int i=0; i<n; i++) {
			city[i] = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				if(city[i][j]=='X') XQ.offer(new int[] {i, j});
				else if(city[i][j]=='O') OQ.offer(new int[] {i, j});
			}
		}
		
		Xbomb();
		Obomb();
		
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				answer.append(city[i][j]);
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
	}
	
	static void Xbomb() {
		while(!XQ.isEmpty()) {
			int[] t = XQ.poll();
			for(int i=0; i<4; i++) {
				int x = t[0] + dx[i];
				int y = t[1] + dy[i];
				while(true) {
					if(x<0 || x>=n || y<0 || y>=n || city[x][y]!='.') break;
					city[x][y] = 'B';
					x += dx[i];
					y += dy[i];
				}
			}
		}
	}
	
	static void Obomb() {
		while(!OQ.isEmpty()) {
			int[] t = OQ.poll();
			for(int i=0; i<4; i++) {
				int x = t[0] + dx[i];
				int y = t[1] + dy[i];
				while(true) {
					if(x<0 || x>=n || y<0 || y>=n || city[x][y]=='O' || city[x][y]=='X') break;
					city[x][y] = '.';
					x += dx[i];
					y += dy[i];
				}
			}
		}
	}

}
