package study_0530;
import java.io.*;
import java.util.*;

public class BJ_1516_배찬비 {
	
	static List<Integer>[] list;
	static int[] degree;
	static int[] time;
	static int[] answer;
	static Queue<Integer> Q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
		degree = new int[n+1];  // 연결된 간선 수 
		time = new int[n+1];   // 각각 짓는데 걸리는 시간 
		answer = new int[n+1]; 
		
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) break;
				degree[i]++;
				list[num].add(i);
			}
			if(degree[i]==0) {
				Q.offer(i);
				answer[i] = time[i];
			}
		}
		
		sort();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(answer[i]+"\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void sort() {
		while(!Q.isEmpty()) {
			int num = Q.poll();
			for(int i=0; i<list[num].size(); i++) {
				int tmp = list[num].get(i);
				degree[tmp]--;
				if(degree[tmp]==0) {
					Q.offer(tmp);
				}
				answer[tmp] = Math.max(answer[tmp], answer[num]+time[tmp]);
			}
		}
	}


}
