package study_0511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1525_이다영 {
	static int y, x;
	static int[][] map;
	
	static Queue<Node> queue;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					y = i;
					x = j;
				}
			}
		}
		
		queue = new ArrayDeque<>();
		queue.offer(new Node(-1, -1, y, x, map, 0));
		
		bfs();
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(check(node.map)) {
				System.out.println(node.depth);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny >= 3 || nx >= 3 || ny < 0 || nx < 0 ) continue;
				if(ny == node.beforeY && nx == node.beforeX) continue;
				
				int [][] newMap = copyMap(node.map);
				newMap[node.y][node.x] = newMap[ny][nx];
				newMap[ny][nx] = 0;
				
				queue.offer(new Node(node.y, node.x, ny, nx, newMap, node.depth + 1));
			}
		}
		System.out.println(-1);
	}
	
	public static class Node{
		int beforeY;
		int beforeX;
		int y;
		int x;
		int[][] map;
		int depth;
		
		public Node(int beforeY, int beforeX, int y, int x, int[][]map, int depth) {
			this.beforeY = beforeY;
			this.beforeX = beforeX;
			this.y = y;
			this.x = x;
			this.map = map;
			this.depth = depth;
		}
	}
	
	public static int[][] copyMap (int[][] map) {
		int[][] newMap = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
	
	public static boolean check(int[][] map) {
		int num = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 2 && j ==2 && map[i][j] == 0) return true;
				if(map[i][j] != num++) return false;
			}
		}	
		return true;
	}
}
