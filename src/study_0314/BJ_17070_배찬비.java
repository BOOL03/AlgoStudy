package study_0314;
import java.io.*;
import java.util.*;

public class BJ_17070_배찬비 {
	
	static int n, answer;
	static int[][] house;
	
	static void DFS(int x2, int y2, int d) {
		if(x2==n && y2==n) {
			answer++;
			return;
		}
		if(d==1) { //가로
			if(y2<n && house[x2][y2+1]==0) {
				house[x2][y2+1] = 1;
				DFS(x2, y2+1, 1);
				house[x2][y2+1] = 0;
				if(x2<n && house[x2+1][y2+1]==0 && house[x2+1][y2]==0) {
					house[x2+1][y2+1] = 1;
					DFS(x2+1, y2+1, 3);
					house[x2+1][y2+1] = 0;
				}
			}
		} else if(d==2) { //세로 
			if(x2<n && house[x2+1][y2]==0) {
				house[x2+1][y2] = 1;
				DFS(x2+1, y2, 2);
				house[x2+1][y2] = 0;
				if(y2<n && house[x2+1][y2+1]==0 && house[x2][y2+1]==0) {
					house[x2+1][y2+1] = 1;
					DFS(x2+1, y2+1, 3);
					house[x2+1][y2+1] = 0;
				}
			}
		} else { //대각선 
			if(y2<n && house[x2][y2+1]==0) {
				house[x2][y2+1] = 1;
				DFS(x2, y2+1, 1);
				house[x2][y2+1] = 0;
			}
			if(x2<n && house[x2+1][y2]==0) {
				house[x2+1][y2] = 1;
				DFS(x2+1, y2, 2);
				house[x2+1][y2] = 0;
				if(y2<n && house[x2+1][y2+1]==0 && house[x2][y2+1]==0) {
					house[x2+1][y2+1] = 1;
					DFS(x2+1, y2+1, 3);
					house[x2+1][y2+1] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		house = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		house[1][1] = 1;
		house[1][2] = 1;
		DFS(1, 2, 1);
		
		System.out.println(answer);
		
	}

}
