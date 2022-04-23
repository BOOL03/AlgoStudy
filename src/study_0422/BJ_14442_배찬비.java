package study_0422;
import java.util.*;
import java.io.*;

public class BJ_14442_배찬비 {
	
	static int n, m, k;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][][] visited;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new boolean[n][m][k+1];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {0, 0, 1, k});
		visited[0][0][k] = true;
		
		while(!Q.isEmpty()) {
			int[] t = Q.poll();
			if(t[0]==n-1 && t[1]==m-1) return t[2];
			
			for(int i=0; i<4; i++) {
				int x = t[0] + dx[i];
				int y = t[1] + dy[i];
				if(x<0 || x>=n || y<0 || y>=m) continue;
				if(t[3]==0 && arr[x][y]=='1') continue;
				
				if(arr[x][y]=='1'){
					if(visited[x][y][t[3]-1]) continue;
					Q.offer(new int[] {x, y, t[2]+1, t[3]-1});
					visited[x][y][t[3]-1] = true;
				}
				else {
					if(visited[x][y][t[3]]) continue;
					Q.offer(new int[] {x, y, t[2]+1, t[3]});
					visited[x][y][t[3]] = true;
				}
			}
		}
		
		return -1;
	}
}
