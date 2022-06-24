package study_0622;
import java.io.*;
import java.util.*;

public class BJ_13913_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(n>k) {
			StringBuilder sb = new StringBuilder();
			System.out.println(n-k);
			for(int i=n; i>=k; i--) {
				sb.append(i+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		visited[k] = -2;
		Queue<Node> Q = new ArrayDeque<>();
		Q.offer(new Node(0, k));
		
		while(!Q.isEmpty()) {
			Node tmp = Q.poll();
			if(tmp.me == n) {
				System.out.println(tmp.cnt);
				StringBuilder sb = new StringBuilder();
				int num = n;
				while(true) {
					if(num == -2) break;
					sb.append(num+" ");
					num = visited[num];
				}
				System.out.println(sb.toString());
				break;
			}
			
			if(tmp.me-1>=0 && visited[tmp.me-1]==-1) {
				visited[tmp.me-1] = tmp.me;
				Q.offer(new Node(tmp.cnt+1, tmp.me-1));
			}
			if(tmp.me+1<=100000 && visited[tmp.me+1]==-1) {
				visited[tmp.me+1] = tmp.me;
				Q.offer(new Node(tmp.cnt+1, tmp.me+1));
			}
			if(tmp.me!=0 && tmp.me%2==0 && visited[tmp.me/2]==-1) {
				visited[tmp.me/2] = tmp.me;
				Q.offer(new Node(tmp.cnt+1, tmp.me/2));
			}
		}
	}
	
	static class Node{
		int cnt, me;
		Node(int cnt, int me){
			this.cnt = cnt;
			this.me = me;
		}
	}

}
