package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_조무현 {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Node> jqueue = new LinkedList<>();
	static Queue<Node> fqueue = new LinkedList<>();
	static class Node{
		int r;
		int c;
		int d;
		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'J') {
					jqueue.offer(new Node(i, j, 0));
				}
				else if(map[i][j] == 'F') {
					fqueue.offer(new Node(i, j, 0));
				}
			}
		}
		
		int depth = 0;
		boolean found = false;
		while(true) {

			while(!fqueue.isEmpty() && fqueue.peek().d <= depth) {
				Node node = fqueue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
					map[nr][nc] = 'F';
					fqueue.offer(new Node(nr, nc, depth + 1));
				}
			}
			
			while(!jqueue.isEmpty() && jqueue.peek().d <= depth) {
				Node node = jqueue.poll();
				if(node.r == R-1 || node.c == C-1 || node.r == 0 || node.c == 0) {
					found = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != '.') continue;
					map[nr][nc] = 'J';
					jqueue.offer(new Node(nr, nc, depth + 1));
				}
			}
			depth++;
			if(found) break;
			if(jqueue.isEmpty()) break;
		}
		
		if(found) System.out.println(depth);
		else System.out.println("IMPOSSIBLE");
		
	}

}
