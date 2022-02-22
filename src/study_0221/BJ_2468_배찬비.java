package study_0221;
import java.io.*;
import java.util.*;

public class BJ_2468_배찬비 {
	
	static boolean[][] visited;
	static int[][] map;
	static int n, answer = 1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());		
		
		map = new int[n][n];
		
		int maxHeight = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		for(int k = 0; k<=maxHeight; k++) {
			visited = new boolean[n][n];
			int area = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]>k && !visited[i][j]) {
						visited[i][j] = true;
						area++;
						BFS(k, i, j);
					}
				}
			}
			answer = Math.max(answer, area);
		}
		System.out.println(answer);
	}
	
	
	static void BFS(int num, int x, int y) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		Queue<Pos> Q = new ArrayDeque<>();
		Q.offer(new Pos(x, y));
		
		while(!Q.isEmpty()) {
			Pos p = Q.poll();
			for(int i=0; i<4; i++) {
				int xx = p.x+dx[i];
				int yy = p.y+dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=n || map[xx][yy]<=num ||visited[xx][yy]) continue;
				visited[xx][yy] = true;
				Q.offer(new Pos(xx, yy));
			}
			
		}
	}
	
	static class Pos{
		int x,y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
