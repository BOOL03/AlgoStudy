package study_0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14442_이다영 {
	static int N, M, K, ans;
	static boolean map[][];
	static boolean visit[][][];
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visit = new boolean[N][M][K+1];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)=='0'? true : false;
			}
		}
		
		ans = 1;
		if(bfs()) System.out.println(ans);
		else System.out.println(-1);
	}
	public static boolean bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.offer(new Node(0, 0, 1, 0));
		
		for (int i = 0; i <= K; i++) {
			visit[0][0][i] = true;
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int y = node.y;
			int x = node.x;
			int depth = node.d;
			int k = node.k;
			
			if(y == N-1 && x == M-1) { //도착
				ans = depth;
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny >= N || nx >= M || ny < 0 || nx < 0 ) continue;
				
				// 벽 부수지 않음 
				if(map[ny][nx]&& !visit[ny][nx][k]) {
					visit[ny][nx][k] = true;
					queue.offer(new Node(ny, nx, depth+1, k));
				}
				
				// 벽 부숨
				if(K > k && !map[ny][nx] && !visit[ny][nx][k+1]) {
					visit[ny][nx][k+1] = true;
					queue.offer(new Node(ny, nx, depth+1, k+1));
				}
				
			}
		}
		return false;
	}
	
	public static class Node {
		int y;
		int x;
		int d;
		int k;
		
		public Node(int y, int x, int d, int k) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}

}
