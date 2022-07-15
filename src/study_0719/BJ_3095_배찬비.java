package study_0719;
import java.io.*;
import java.util.*;

public class BJ_3095_배찬비 {
	
	static int n, answer;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] plus = {{'0', '1','0'},
							{'1', '1', '1'},
							{'0', '1', '0'}};
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for(int i=0; i<n; i++) arr[i] = br.readLine().toCharArray();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]=='1') {
					int cnt = 1;
					while(true) {
						if(!isPlus(i, j, cnt)) break;
						cnt++;
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}

	
	static boolean isPlus(int x, int y, int cnt) {
		
		if(x-cnt<0 || x+cnt>=n || y-cnt<0 || y+cnt>=n) return false;
		
		for(int i=0; i<2; i++) {
			int xx = x+dx[i]*cnt;
			int yy = y+dy[i]*cnt;
			
			if(arr[xx][yy] != '1') return false;
			for(int j=1; j<=cnt; j++) if(arr[xx][yy-j] != '0') return false;
			for(int j=1; j<=cnt; j++) if(arr[xx][yy+j] != '0') return false;
		}
		for(int i=2; i<4; i++) {
			int xx = x+dx[i]*cnt;
			int yy = y+dy[i]*cnt;
			
			if(arr[xx][yy] != '1') return false;
			for(int j=1; j<=cnt; j++) if(arr[xx-j][yy] != '0') return false;
			for(int j=1; j<=cnt; j++) if(arr[xx+j][yy] != '0') return false;
		}
		
		return true;
	}

}
