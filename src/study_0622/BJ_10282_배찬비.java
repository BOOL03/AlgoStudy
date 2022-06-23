package study_0622;
import java.io.*;
import java.util.*;

public class BJ_10282_배찬비 {
	
	static int n, d, c, cnt, answer;
	static ArrayList<Node>[] list;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			for(int i=0; i<=n; i++) list[i] = new ArrayList<Node>();
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list[b].add(new Node(a, s));
			}
			
			virus();
			sb.append(cnt+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void virus() {
		boolean[] visited = new boolean[n+1];
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[c] = 0;
		int[] com;
		cnt = 0;
		answer = 0;
		PriorityQueue<int[]> Q = new PriorityQueue<>((e1, e2) -> e1[1]-e2[1]);
		Q.offer(new int[] {c, 0});
		
		while(!Q.isEmpty()) {
			com = Q.poll();
			if(visited[com[0]]) continue;
			visited[com[0]] = true;
			cnt++;
			answer = com[1];
			
			for(int i=0; i<list[com[0]].size(); i++) {
				Node tmp = list[com[0]].get(i);
				if(dis[tmp.num] > com[1] + tmp.time) {
					dis[tmp.num] = com[1] + tmp.time;
					Q.offer(new int[] {tmp.num, dis[tmp.num]});
				}
			}
		}
	}
	
	static class Node{
		int num, time;
		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}

}
