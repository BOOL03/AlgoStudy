package study_0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_조무현 {
	static int T, N;
	static Node home, festival;
	//static PriorityQueue<Node> pqueue;
	static Queue<Node> queue;
	static List<Node> store;
	static int current_r, current_c;
	static int beer;
	static int INF = 100000;
	static class Node{
		int r;
		int c;
		int d;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			beer = 20;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			current_r = home.r;
			current_c = home.c;
			store = new ArrayList<Node>();
			queue = new LinkedList<Node>();
			//pqueue = new PriorityQueue<Node>((n1, n2)-> distance(current_r, current_c, n1.r, n1.c) - distance(current_r, current_c, n2.r, n2.c));
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Node n = new Node(r, c);
				
				if(distance(home.r, home.c, r, c) <= 1000) {
					queue.offer(new Node(r, c));	
				}
				store.add(n);
				
			}
			st = new StringTokenizer(br.readLine());
			festival = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			store.add(new Node(festival.r, festival.c));
			if(distance(home.r, home.c, festival.r, festival.c) <= 1000) {
				queue.offer(new Node(festival.r, festival.c));
			}
			// 입력 끝
			boolean found = false;
				
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.r == festival.r && node.c == festival.c) {
					found = true;
					break;
				}
				for (Node n : store) {
					int dist = distance(n.r, n.c, node.r, node.c);
					if(dist <= 1000) {
						queue.offer(new Node(n.r, n.c));
						n.r = INF;
						n.c = INF;
					}
				}
			}
				
			
			
			if(found) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	
	static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

}
