package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1922_조무현 {
	static int N, M;
	static ArrayList<ArrayList<Edge>> edges;
	static PriorityQueue<Edge> pqueue;
	static boolean[] visit;
	static class Edge {
		int v;
		int c;
		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		pqueue = new PriorityQueue<Edge>((o1, o2)->o1.c - o2.c);
		edges = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<Edge>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges.get(a).add(new Edge(b, c));
			edges.get(b).add(new Edge(a, c));
		}
		
		visit[1] = true;
		int ans = 0;
		int cnt = 1;
		pqueue.addAll(edges.get(1));
		while(!pqueue.isEmpty()) {
			Edge edge = pqueue.poll();
			if(visit[edge.v]) continue;
			
			visit[edge.v] = true;
			ans += edge.c;
			cnt++;
			if(cnt == N) break;
			
			pqueue.addAll(edges.get(edge.v));
		}
		System.out.println(ans);
		
	}

}
