package study_0629;
import java.io.*;
import java.util.*;

public class BJ_14923_배찬비 {
	
	static int n, m, sx, sy, ex, ey;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		boolean[][][] visited = new boolean[n][m][2];
		Queue<Node> Q = new ArrayDeque<>();
		Q.offer(new Node(sx, sy, 0, 0));
		visited[sx][sy][0] = true;
		
		while(!Q.isEmpty()) {
			Node tmp = Q.poll();
			if(tmp.x==ex && tmp.y==ey) return tmp.cnt;
			
			for(int i=0; i<4; i++) {
				int xx = tmp.x + dx[i];
				int yy = tmp.y + dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=m || (tmp.visit==1 && arr[xx][yy]==1)) continue;
				if(tmp.visit==0 && arr[xx][yy]==1) {
					if(visited[xx][yy][1]) continue;
					Q.offer(new Node(xx, yy, tmp.cnt+1, 1));
					visited[xx][yy][1] = true;
				} else {
					if(visited[xx][yy][tmp.visit]) continue;
					Q.offer(new Node(xx, yy, tmp.cnt+1, tmp.visit));
					visited[xx][yy][tmp.visit] = true;
				}
			}
		}
		
		return -1;
	}
	
	static class Node{
		int x, y, cnt, visit;
		Node(int x, int y, int cnt, int visit){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.visit = visit;
		}
	}

}
