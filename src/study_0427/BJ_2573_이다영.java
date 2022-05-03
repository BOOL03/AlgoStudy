package study_0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_이다영 {
	static int N, M, ans, count;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0 };
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	
	static Queue<Node> queue;
	static Queue<Node> removeQ;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		queue = new ArrayDeque<>();
		removeQ = new ArrayDeque<>();
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					queue.offer(new Node(i, j, 0, map[i][j]));
				}
			}
		}
		
		if(bfs()) System.out.println(ans);
		else System.out.println(0);
	}
	static boolean bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				
				int y = node.y;
				int x = node.x;
				int depth = node.depth;
				int h = node.h;
				
				if(i == 0) {
					visit = new boolean[N][M];
					visit[y][x] = true;
					count = 1;
					dfs(y, x);
//					System.out.println("count : " + count + "size :" + size);
					if(count != size) return true;
					ans++;
				}
				
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ny = y+dy[d];
					int nx = x+dx[d];
					
					if(ny >= N || nx >= M || ny < 0 || nx < 0) continue;
					if(map[ny][nx] == 0) cnt++;
				}
				
				if(cnt >= map[y][x]) removeQ.offer(node);
				else {
					map[y][x] -= cnt;
					queue.offer(new Node(y, x, depth+1, map[y][x]));
				}
			}
			
			remove();
			
//			System.out.println("=======ans : " +ans + " =======");
//			System.out.println("count : " + count + "size :" + size);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		return false;
	}
	
	static void remove() {
		while(!removeQ.isEmpty()) {			
			Node node = removeQ.poll();
			
			map[node.y][node.x] = 0;
		}
	}

	static void dfs(int y, int x) {
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny >= N || nx >= M || ny < 0 || nx < 0 || visit[ny][nx] || map[ny][nx] == 0) continue;
			
			visit[ny][nx] = true;
			count++;
			dfs(ny, nx);
		}		
	}
	
	public static class Node{
		int y;
		int x;
		int depth;
		int h;
		
		public Node(int y, int x, int depth, int h) {
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.h = h;
		}
	}
}
