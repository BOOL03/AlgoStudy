package study_0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_이다영 {
	static int H, W, hour, cheese;
	static int[][] map;
	static boolean[][] visitAir;
	static boolean[][] visitCheese;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static Queue<Node> queueAir = new LinkedList<Node>();
	static Queue<Node> queueBorder = new LinkedList<Node>(); //경계면에 있는 치즈
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visitAir = new boolean[H][W];
		visitCheese = new boolean[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// bfs
		visitAir[0][0] = true;
		queueAir.offer(new Node(0, 0));
		
		while(true) {
			// 공기를 순회하면서 공기와 닿은 치즈를 찾아서 queueBorder 에 담는다. 
			bfsAir();
			// queueBorder에 더이상 없다 => break!
			if(queueBorder.isEmpty()) break;
			// queueBorder에서 치즈 => 공기로 전환 (queueAir)에 담는다! (cheese 수를 매번 새로 계산 => 매번 경계 치즈를 -> 공기로 전환)
			bfsBorder();
			// 1회 -> hour 1증가
			hour++;
		}
		
		System.out.println(hour);
//		System.out.println(cheese);
		
	}
	static void bfsAir() {
		while(! queueAir.isEmpty()) {
			
			Node n = queueAir.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || visitAir[ny][nx]) continue;
				
				// 공기
				if(map[ny][nx] == 0) {
					visitAir[ny][nx] = true;
					queueAir.add(new Node(ny, nx));
					continue;
				}
				// 공기와 2번 접촉된 치즈
				if( map[ny][nx] == 2) {
					if(visitCheese[ny][nx] ) continue; // 다른 공기에 의해서 치즈가 이미 발견되었다면..
					visitCheese[ny][nx] = true;
					queueBorder.offer(new Node(ny, nx));
				}
				
				// 공기와 1번 접촉된 치즈
				if( map[ny][nx] == 1) {
					map[ny][nx] = 2; 
				}
			}
		}
	}
	
	// 경계면 치즈 => 공기로 바뀜
	// 매번 남아있는 치즈를 새롭게 계산 (즉, 경계면 치즈 -> 공기) 로 변환하는 횟수를 계산
	static void bfsBorder() {
//		cheese = 0;
		
		while(!queueBorder.isEmpty()) {
			Node n = queueBorder.poll();
			visitAir[n.y][n.x] = true;
			queueAir.offer(n);
//			cheese++;
		}
	}
	
	
	static class Node{
		int y, x;
		public Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
