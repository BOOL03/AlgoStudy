package study_0411;
import java.io.*;
import java.util.*;

public class BJ_19238_배찬비 {
	
	static int n, m, fuel, x, y;
	static int[][] road;
	static Pos[] dist;  // 목적지 저장 배열 
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		road = new int[n][n];
		dist = new Pos[m+2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken())-1;
		y = Integer.parseInt(st.nextToken())-1;
		
		int p = 2;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			road[sx-1][sy-1] = p;
			dist[p] = new Pos(ex-1, ey-1);
			p++;
		}
		
		for(int i=0; i<m; i++) {
			if(!on()) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(fuel);
		
	}
	
	static boolean on() {
		Queue<int[]> Q = new ArrayDeque<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2)-> e1[0]==e2[0] ? e1[1]-e2[1] : e1[0]-e2[0]);
		boolean[][] visited = new boolean[n][n];
		Q.offer(new int[] {x, y, 0});
		int cur = 1;
		
		while(!Q.isEmpty()) {
			int[] t = Q.poll();
			if(t[2]>fuel) return false;
			
			if(cur == t[2] && !pq.isEmpty()) {
				int[] t2 = pq.poll();
				fuel -= t2[2];
				x = t2[0];
				y = t2[1];
				int num = road[t2[0]][t2[1]];
				road[t2[0]][t2[1]] = 0;
				pq.clear();
				cur++;
				if(off(num)) return true;
				else return false;
			} else if(cur == t[2]) {
				cur++;
			}
			if(road[t[0]][t[1]]>1) {
				pq.offer(t);
			}
			
			for(int i=0; i<4; i++) {
				int xx = t[0] + dx[i];
				int yy = t[1] + dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=n || visited[xx][yy] || road[xx][yy]==1) continue;
				visited[xx][yy] = true;
				Q.offer(new int[] {xx, yy, t[2]+1});
			}
		}
		if(!pq.isEmpty()) {
			int[] t2 = pq.poll();
			fuel -= t2[2];
			x = t2[0];
			y = t2[1];
			int num = road[t2[0]][t2[1]];
			road[t2[0]][t2[1]] = 0;
			if(off(num)) return true;
			else return false;
		}
		
		return false;
	}
	
	static boolean off(int num) {
		Queue<int[]> Q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		Q.offer(new int[] {x, y, 0});
		int ex = dist[num].x;
		int ey = dist[num].y;
		
		while(!Q.isEmpty()) {
			int[] t = Q.poll();
			if(t[2]>fuel) return false;
			if(ex==t[0] && ey==t[1]) {
				fuel += t[2];
				x = t[0];
				y = t[1];
				return true;
			}
			
			for(int i=0; i<4; i++) {
				int xx = t[0] + dx[i];
				int yy = t[1] + dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=n || visited[xx][yy] || road[xx][yy]==1) continue;
				visited[xx][yy] = true;
				Q.offer(new int[] {xx, yy, t[2]+1});
			}
		}
		
		return false;
	}
	
	static class Pos{
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
}