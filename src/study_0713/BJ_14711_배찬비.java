package study_0713;
import java.io.*;
import java.util.*;

public class BJ_14711_배찬비 {
	
	static int[] dx = {-1, 0, 0};
	static int[] dy = {0, -1, 1};
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		char[][] game = new char[n][n];
		game[0] = br.readLine().toCharArray();
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n; j++) {
				int cnt = 0;
				sb.append(game[i][j]);
				for(int k=0; k<3; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if(x<0 || x>=n || y<0 || y>=n || game[x][y]=='.') continue;
					cnt++;
				}
				if(cnt%2==0) game[i+1][j] = '.';
				else game[i+1][j] = '#';
			}
			sb.append("\n");
		}
		
		for(int i=0; i<n; i++) sb.append(game[n-1][i]);
		
		System.out.println(sb.toString());
		
	}

}
