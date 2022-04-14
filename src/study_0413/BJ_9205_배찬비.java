package study_0413;
import java.io.*;
import java.util.*;

public class BJ_9205_배찬비 {
	
	static int n;
	static int[][] store;
	static boolean[] visited;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			store = new int[n+2][2];
			visited = new boolean[n+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			store[0][0] = Integer.parseInt(st.nextToken());
			store[0][1] = Integer.parseInt(st.nextToken());
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			store[n+1][0] = Integer.parseInt(st.nextToken());
			store[n+1][1] = Integer.parseInt(st.nextToken());
			
			bfs();
		}
		System.out.println(answer.toString());
	}

	static void bfs() {
		Queue<Integer> Q = new ArrayDeque<>();
		visited[0] = true;
		Q.offer(0);
		
		while(!Q.isEmpty()) {
			int s = Q.poll();
			if( s == n+1 ) {
				answer.append("happy\n");
				return;
			}
			for(int i=1; i<n+2; i++) {
				if(visited[i]) continue;
				if(dis(store[s][0], store[s][1], store[i][0], store[i][1])<=1000) {
					visited[i] = true;
					Q.offer(i);
				}
			}
		}
		
		answer.append("sad\n");
		return;
	}
	
	static int dis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}