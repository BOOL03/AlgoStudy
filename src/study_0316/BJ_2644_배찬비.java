package study_0316;
import java.io.*;
import java.util.*;

public class BJ_2644_배찬비 {
	
	static int n, a, b;
	static int[] parent;
	static ArrayList<Integer>[] child;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		child = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) child[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			parent[y] = x;
			child[x].add(y);
		}
		
		System.out.println(find());
		
	}
	
	static int find() {
		int answer = -1;
	
		Queue<int[]> Q = new ArrayDeque<>();
		visited[a] = true;
		visited[0] = true;
		Q.offer(new int[] {a, 0});
		
		while(!Q.isEmpty()) {
			int[] tmp = Q.poll();
			if(tmp[0] == b) return tmp[1];
			if(!visited[parent[tmp[0]]]) {
				Q.offer(new int[] {parent[tmp[0]], tmp[1]+1});
				visited[parent[tmp[0]]] = true;
			}
			for(int i=0; i<child[tmp[0]].size(); i++) {
				if(!visited[child[tmp[0]].get(i)]) {
					Q.offer(new int[] {child[tmp[0]].get(i), tmp[1]+1});
					visited[child[tmp[0]].get(i)] = true;
				}
			}
		}
		
		return answer;
	}

}
