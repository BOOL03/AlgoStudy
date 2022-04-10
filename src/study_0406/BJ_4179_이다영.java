package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_이다영 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> queue = new ArrayDeque<>();
	static Queue<Node> fqueue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] =='J') {
					visit[i][j] = true;
					queue.offer(new Node(i, j, 0));
				}
				else if(map[i][j] =='F') {
					visit[i][j] = true;
					fqueue.offer(new Node(i, j, 0));
				}
			}
		}
		
		int result = bfs();
		System.out.println(result == -1 ? "IMPOSSIBLE" : result);
	}
	
	static int bfs() {
		boolean first = true;
		
		while(! queue.isEmpty()) {
			if(first) first = false;
			else {
				int fsize = fqueue.size();
				for (int i = 0; i < fsize; i++) {
					Node node = fqueue.poll();
					for (int d = 0; d < 4; d++) {
						int ny = node.y + dy[d];
						int nx = node.x + dx[d];
						
						if(ny >= R || nx >= C  || ny < 0 || nx <0 || map[ny][nx] == '#' || map[ny][nx] == 'F') continue;
						if(map[ny][nx] == 'J' && queue.size() == 1) return -1;
						if(map[ny][nx] == 'J') {//queue에서 해당 j 빼기
							for (Node n : queue) {
								if(ny == n.y && nx == n.x) {
									queue.remove(n);
									break;
								}
							}
						}
						map[ny][nx] = 'F';
						fqueue.offer(new Node(ny, nx, d+1));
					}
				}
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				map[node.y][node.x] = '.';
				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];
					int depth = node.d;
					if(ny >= R || nx >= C  || ny < 0 || nx <0 ) { //탈출
						return (depth + 1);
					}
					
					if(map[ny][nx] == '.' && !visit[ny][nx]) {
						visit[ny][nx] = true;
						queue.offer(new Node(ny, nx, depth + 1));
						map[ny][nx] = 'J'; // 현재 위치
					}
				}
			}
		}
		return -1;
	}
	
	static class Node{
		int y;
		int x;
		int d;
		
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
