package study_0411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238_스타트택시 {
	static int N, M, fuel, ans;
	static int[][] map;
	static List<Node> cust; // 손님 
	static List<Node> dest; // 도착지점
	static int sy, sx; // 택시 현재 위치
	
	static int[] dy = {-1,1,0,0,};
	static int[] dx = {0, 0, -1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken()) -1;
		sx = Integer.parseInt(st.nextToken()) -1;
		
		cust = new ArrayList<>();
		dest = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int custy = Integer.parseInt(st.nextToken()) -1;
			int custx = Integer.parseInt(st.nextToken()) -1;
			int desty = Integer.parseInt(st.nextToken()) -1;
			int destx = Integer.parseInt(st.nextToken()) -1;
			cust.add(new Node(custy, custx, i+1, 0));
			dest.add(new Node(desty, destx, i+1, 0));
		}
		// 정렬
		cust.sort((n1, n2) -> n1.y==n2.y? n1.x - n2.x : n1.y - n2.y);
		dest.sort((n1, n2) -> n1.y==n2.y? n1.x - n2.x : n1.y - n2.y);
		taxi();
		System.out.println(ans);
	}
	
	static void taxi() {
		//  1. 최단 거리 손님 찾기
		Node customer = findCust();
		if(customer == null) { // 택시로 갈수있는 손님이 없다면 => null
			ans = -1;
			return;
		}
		int idx = 0;
		int size = cust.size();
		for (int i = 0; i < size; i++) {
			if(cust.get(i).idx == customer.idx) {
				idx = i;
				break;
			}
		}
		 System.out.println("1 : " + customer.d);
		// 2. 현재 연료 : 현재 택시 위치 - 최단 거리 손님(출발지까지의 거리) 소모
		fuel -= customer.d;
		if(fuel <= 0) {
			ans = -1;
			return;
		}
		 System.out.println("2 : " + fuel);
		// 3. 목적지 - 도착지 최단거리
		int useFuel = move(cust.get(idx), dest.get(idx));
		if(useFuel == -1) {
			ans = -1;
			return;
		}
		fuel += useFuel;
		 System.out.println("3 : " + useFuel);
		 System.out.println("3 : " + fuel);
		// 4. 완료한 손님은 리스트에서 제거 
		cust.remove(idx);
		dest.remove(idx);
		
		size = cust.size();
		if(size == 0) {
			ans = fuel;
			return;
		}
		taxi();
	}
	static Node findCust() {//  1. 최단 거리 손님 찾기
		// PriorityQueue<Node> queue = new PriorityQueue<Node>( (n1, n2) -> n1.y == n2.y? (n1.x - n2.x) : n1.y - n2.y);
		Queue<Node> queue = new ArrayDeque<Node>();
		boolean[][][] visit = new boolean[N][N][M+1];
		
		for (Node node : cust) {
			queue.offer(node);
			visit[node.y][node.x][node.idx] = true;
		}
		
		while(! queue.isEmpty()) {
			
			Node node = queue.poll();
			int y = node.y;
			int x = node.x;
			int idx = node.idx;
			int depth = node.d;
			if(y == sy && x == sx) return node;
			
			for (int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny >= N || nx >= N || ny < 0 || nx <0 || visit[ny][nx][idx] || map[ny][nx] == 1) continue;

				queue.offer(new Node(ny, nx, idx, depth + 1));
				visit[ny][nx][idx] = true;
			}
		}
		
		return null;
	}
	
	static int move(Node cust, Node dest) {// 3. 목적지 - 도착지 최단거리
		Queue<Node> queue = new ArrayDeque<Node>();
		boolean[][] visit = new boolean[N][N];
		
		queue.offer(cust);
		visit[cust.y][cust.x] = true;
		
		while(! queue.isEmpty()) {
			Node node = queue.poll();
			int y = node.y;
			int x = node.x;
			int idx = node.idx;
			if(y == dest.y && x == dest.x) {// 목적지 도착하면
				//택시 위치 이동
				sy = y;
				sx = x;
				return node.d; // 사용한 연료
			}
			if(fuel - node.d <= 0) continue;// 이동 도중 연료가 바닥난 경우
			
			for (int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny >= N || nx >= N || ny < 0 || nx <0 || visit[ny][nx] || map[ny][nx] == 1) continue;
				queue.offer(new Node(ny, nx, idx, node.d + 1));
				visit[ny][nx] = true;
			}
		}
		
		return -1;
	}
	
	
	static class Node{
		int y;
		int x;
		int idx;
		int d;
		
		public Node (int y, int x, int idx, int d) {
			this.y = y;
			this.x = x;
			this.idx = idx;
			this.d = d;
		}
	}

}
