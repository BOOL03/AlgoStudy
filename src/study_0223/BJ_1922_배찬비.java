package study_0223;
import java.io.*;
import java.util.*;

public class BJ_1922_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n+1];
		ArrayList<ArrayList<Pos>> line = new ArrayList<>();
		for(int i=0; i<=n; i++) line.add(new ArrayList<Pos>());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			line.get(a).add(new Pos(b, c));
			line.get(b).add(new Pos(a, c));
		}
		
		PriorityQueue<Pos> Q = new PriorityQueue<>((e1, e2)->e1.c-e2.c);
		Q.addAll(line.get(1));
		visited[1] = true;
		int cnt = 1;
		int answer = 0;
		
		while(!Q.isEmpty()) {
			Pos p = Q.poll();
			if(!visited[p.a]) {
				visited[p.a] = true;
				cnt++;
				answer += p.c;
				Q.addAll(line.get(p.a));
			}
			if(cnt==n) break;
		}
		
		System.out.println(answer);

	}
	
	static class Pos{
		int a, c;
		Pos(int a, int c){
			this.a = a;
			this.c = c;
		}
	}
}
