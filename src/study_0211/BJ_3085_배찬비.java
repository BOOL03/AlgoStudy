package study_0211;
import java.io.*;
import java.util.*;

public class BJ_3085_배찬비 {
	static int n, answer;
	static char[][] candy;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		candy = new char[n][n];
		for(int i=0; i<n; i++) candy[i] = br.readLine().toCharArray();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<2; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if(x==n || y==n) continue;
					swap(i, j, x, y);
					count(i, j, 0);
					count(i, j, 1);
					if(k==0) count(x, y, 1);
					else if(k==1) count(x, y, 0);
					swap(x, y, i, j);
				}
			}
		}
		System.out.println(answer);
	}
	
	static void count(int x, int y, int d) {
		int cnt = 1;
		if(d==0) {
			for(int i=1; i<n; i++) {
				if(candy[x][i-1]==candy[x][i]) cnt++;
				else {
					answer = Math.max(cnt, answer);
					cnt=1;
				}
			}
			answer = Math.max(cnt, answer);
		}
		else if(d==1) {
			for(int i=1; i<n; i++) {
				if(candy[i-1][y]==candy[i][y]) cnt++;
				else {
					answer = Math.max(cnt, answer);
					cnt=1;
				}
			}
			answer = Math.max(cnt, answer);
		}
	}
	
	static void swap(int ax, int ay, int bx, int by) {
		char tmp = candy[ax][ay];
		candy[ax][ay] = candy[bx][by];
		candy[bx][by] = tmp;
	}
}
