package study_0726;
import java.io.*;
import java.util.*;

public class BJ_23030_배찬비 {
	
	static int m;
	static Map<Integer, int[]> map = new HashMap<>();
	static ArrayList<int[]>[] list;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] stationCnt = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) stationCnt[i] = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[m*2+3];
		for(int i=1; i<=m*2; i++) list[i] = new ArrayList<>();
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			map.put(i, new int[] {p1, p2});
			map.put(i+m, new int[] {q1, q2});
			list[i].add(new int[] {i+m, -1});
			list[i+m].add(new int[] {i, -1});
		}
		
		for(int i=1; i<=m*2; i++) {
			for(int j=i+1; j<=m*2; j++) {
				int[] a = map.get(i);
				int[] b = map.get(j);
				if(a[0]==b[0]) {
					list[i].add(new int[] {j, Math.abs(a[1]-b[1])});
					list[j].add(new int[] {i, Math.abs(a[1]-b[1])});
				}
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int l=0; l<k; l++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int u1 = Integer.parseInt(st.nextToken());
			int u2 = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map.put(m*2+1, new int[] {u1, u2}); // 출발 
			map.put(m*2+2, new int[] {v1, v2}); // 도착 
			
			Queue<Integer> Q = new ArrayDeque<>();
			for(int i=m*2+1; i<=m*2+2; i++) {
				list[i] = new ArrayList<>();
				for(int j=1; j<=m*2; j++) {
					int[] a = map.get(i);
					int[] b = map.get(j);
					if(a[0]==b[0]) {
						list[i].add(new int[] {j, Math.abs(a[1]-b[1])});
						list[j].add(new int[] {i, Math.abs(a[1]-b[1])});
						Q.offer(i);
						Q.offer(j);
					}
				}
			}
			
			int dij = dijkstra(t);
			if(map.get(m*2+1)[0]==map.get(m*2+2)[0]) {
				dij = Math.min(dij, Math.abs(map.get(m*2+1)[1]-map.get(m*2+2)[1]));
			}
			answer.append(dij+"\n");
			
			while(!Q.isEmpty()) {
				int num = Q.poll();
				list[num].remove(list[num].size()-1);
			}
			
		}
		
		System.out.println(answer.toString());
		
	}
	
	static int dijkstra(int t) {
		int[] dis = new int[m*2+3];
		boolean[] visited = new boolean[m*2+3];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[m*2+1] = 0;
		int min = m*2+1;
		visited[min] = true;
		
		for(int i=2; i<=m*2+2; i++) {
			for(int[] tmp : list[min]) {
				if(visited[tmp[0]]) continue;
				int time = tmp[1]==-1? t : tmp[1];
				dis[tmp[0]] = Math.min(dis[tmp[0]], dis[min]+time);
			}
			
			int minIndex = 0;
			int minDis = Integer.MAX_VALUE;
			for(int j=1; j<=m*2+2; j++) {
				if(visited[j]) continue;
				if(minDis>dis[j]) {
					minDis = dis[j];
					minIndex = j;
				}
			}
			min = minIndex;
			visited[min] = true;
			
			if(min==m*2+2) return minDis;
			if(min==0) break;
		}
		
		return Integer.MAX_VALUE;
	}

}
