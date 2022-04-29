package study_0429;
import java.util.*;
import java.io.*;

public class BJ_14499_배찬비 {
	
	static int n, m, x, y;
	static int[][] arr;
	static int[] dice = new int[6];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int d = Integer.parseInt(st.nextToken());
			int up = roll(d);
			if(up != -1) sb.append(up+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

	static int roll(int d) {
		x += dx[d-1];
		y += dy[d-1];
		if(x<0 || x>=n || y<0 || y>=m) {
			x -= dx[d-1];
			y -= dy[d-1];
			return -1;
		}
		
		if(d==1) {
			int tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = tmp;
		}
		else if(d==2) {
			int tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = tmp;
		}
		else if(d==3) {
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[0];
			dice[0] = tmp;
		}
		else if(d==4) {
			int tmp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = tmp;
		}
		
		if(arr[x][y] == 0) {
			arr[x][y] = dice[3];
		} else {
			dice[3] = arr[x][y];
			arr[x][y] = 0;
		}
		
		return dice[1];
	}
}
