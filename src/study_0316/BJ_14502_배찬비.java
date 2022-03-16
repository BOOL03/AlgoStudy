package study_0316;
import java.io.*;
import java.util.*;

public class BJ_14502_배찬비 {
	
	static int n, m, answer;
	static int[][] room;
	static ArrayList<int[]> virus = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==2) virus.add(new int[] {i, j});
			}
		}
		DFS(0, -1, 0);
		System.out.println(answer);
		
	}
	
	static void DFS(int x, int y, int cnt) {
		if(cnt==3) {
			answer = Math.max(answer, BFS());
			return;
		}
		for(int i=y+1; i<m; i++) {
			if(room[x][i]==0) {
				room[x][i] = 1;
				DFS(x, i, cnt+1);
				room[x][i] = 0;
			}
		}
		for(int i=x+1; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(room[i][j]==0) {
					room[i][j] = 1;
					DFS(i, j, cnt+1);
					room[i][j] = 0;
				}
			}
		}
	}
	
	static int BFS() {
		Queue<int[]> Q = new ArrayDeque<>();
		int[][] visited = new int[n][m];
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = room[i][j];
			}
		}
		for(int i=0; i<virus.size(); i++) {
			int[] tmp = virus.get(i);
			Q.offer(new int[] {tmp[0], tmp[1]});
			visited[tmp[0]][tmp[1]] = 2;
		}
		
		while(!Q.isEmpty()) {
			int[] tmp = Q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i=0; i<4; i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=m || visited[xx][yy]==1 || visited[xx][yy]==2) continue;
				Q.offer(new int[] {xx, yy});
				visited[xx][yy] = 2;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j]==0) max++;
			}
		}
		
		return max;
	}

}
