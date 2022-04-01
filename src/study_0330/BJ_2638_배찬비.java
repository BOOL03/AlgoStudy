package study_0330;
import java.io.*;
import java.util.*;

public class BJ_2638_배찬비{
	
	static int n, m, sec, cnt;
	static int[][] cheese;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int tmp = 0;
		while(true) {
			sec++;
			tmp = air();
			if(tmp==0) break;
		}
		System.out.println(sec-1);
	}
	
	static int air() {
		int[][] visited = new int[n][m];
		visited[0][0] = -1;
		Queue<int[]> a = new ArrayDeque<>();
		Queue<int[]> Q = new ArrayDeque<>();
		a.offer(new int[] {0, 0});
		while(!a.isEmpty()) {
			int[] t = a.poll();
			for(int i=0; i<4; i++) {
				int x = t[0]+dx[i];
				int y = t[1]+dy[i];
				if(x<0 || x>=n || y<0 || y>=m || visited[x][y]==-1) continue;
				if(cheese[x][y]==0) {
					a.offer(new int[] {x, y});
					visited[x][y] = -1;
				}
				else {
					visited[x][y]++;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(cheese[i][j]==1 && visited[i][j]>=2) {
					cnt++;
					cheese[i][j] = 0;
				}
			}
		}
		
		return cnt;
	}

}
