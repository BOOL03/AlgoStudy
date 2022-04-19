package study_0411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238_조무현 {
	static int N, M, fuel;
	static int[][] map;
	static Node[] passengers;
	static int bjr, bjc;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int visit_count = 0;
	static PriorityQueue<Point> pqueue = new PriorityQueue<Point>((n1, n2)->  {
		if(n1.d == n2.d) {
			if(n1.r == n2.r) {
				return n1.c - n2.c;
			}else {
				return n1.r - n2.r;
			}
		}else {
			return n1.d - n2.d;
		}
	});
	// 승객정보
	static class Node{
		int sr;
		int sc;
		int dr;
		int dc;
		int d = 0;
		public Node(int sr, int sc, int dr, int dc) {
			this.sr = sr;
			this.sc = sc;
			this.dr = dr;
			this.dc = dc;
		}
		@Override
		public String toString() {
			return "Node [sr=" + sr + ", sc=" + sc + ", dr=" + dr + ", dc=" + dc + ", d=" + d + "]";
		}
		
	}
	
	// r, c, d(거리)
	static class Point{
		int r;
		int c;
		int d;
		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		passengers = new Node[(N+1)*(N+1)];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = st.nextToken().charAt(0) - '0';
			}
		}
		st = new StringTokenizer(br.readLine());
		bjr = Integer.parseInt(st.nextToken());
		bjc = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			passengers[sr*N + sc] = new Node(sr, sc, dr, dc);
			map[sr][sc] = 2;
		}
		// 입력 끝
		// 첫 승객찾기
		
		while(visit_count < M) {
			findPassenger(bjr, bjc);
			moveTaxi();
			if(fuel == -1) break;
			visit_count++;
		}
		System.out.println(fuel);
	}
	// 사용한 연료량을 return
	static void moveTaxi() {
		// 태우러 갈 승객
		//System.out.println(pqueue.size());
		Point point = pqueue.poll();
		if(point == null) {
			fuel = -1;
			return;
		}
		Node node = passengers[point.r * N + point.c];
		int far = distance(point.r, point.c, node.dr, node.dc);
		if(far == -1 || fuel < point.d) {
			fuel = -1;
			return;
		}else {
			if(fuel - point.d < far) {
				fuel = -1;
				return;
			}else {
				fuel -= far + point.d;
				fuel += far * 2;	
			}
		}
		map[point.r][point.c] = 0;
		bjr = node.dr;
		bjc = node.dc;
	}
	static int distance(int sr, int sc, int desr, int desc) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {sr, sc, 0});
		boolean[][] visited = new boolean[N+1][N+1];
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			// 승객이면
			if(point[0] == desr && point[1] == desc) {
				return point[2];
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = point[0] + dr[d];
				int nc = point[1] + dc[d];
				if( nr <= 0 || nc <= 0 || nr > N || nc > N || map[nr][nc] == 1 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc, point[2] + 1});
				
			}
		}
		
		return -1;
		
	}
	// 백준의 위치에 따라 남은 승객들의 거리를 계산
	static boolean findPassenger(int x, int y) {
		pqueue.clear();
		int min_dist = Integer.MAX_VALUE;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N+1][N+1];
		// 현재 백준의 위치
		queue.add(new int[] {x, y, 0});
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			// 승객이면
			if(map[point[0]][point[1]] == 2 && point[2] <= min_dist) {
				min_dist = point[2];
				pqueue.add(new Point(point[0], point[1], point[2]));
			}
			else if(map[point[0]][point[1]] == 2 && point[2] > min_dist) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = point[0] + dr[d];
				int nc = point[1] + dc[d];
				if( nr < 1 || nc < 1 || nr > N || nc > N || map[nr][nc] == 1 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc, point[2] + 1});
			}
		}
		// pqueue에는 가장 가까운 승객정보가 담겨있음
		if(pqueue.isEmpty())return false;
		else return true;
	}
	
	

}
