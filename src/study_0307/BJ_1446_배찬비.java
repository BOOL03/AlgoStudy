package study_0307;
import java.io.*;
import java.util.*;

public class BJ_1446_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ArrayList<Road> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(e-s<=len || e>d) continue;
			arr.add(new Road(s, e, len));
		}
		
		Collections.sort(arr, (e1, e2)->e1.s==e2.s?e1.e-e2.e:e1.s-e2.s);
		
		int[] dis = new int[d+1];
		for(int i=1; i<=d; i++) dis[i] = i;
		
		for(int i=0; i<arr.size(); i++) {
			int s = arr.get(i).s;
			int e = arr.get(i).e;
			int len = arr.get(i).len;
			
			if(dis[e]>dis[s]+len) {
				dis[e] = dis[s] + len;
				for(int j=e; j<=d; j++) {
					dis[j] = Math.min(dis[j], dis[j-1]+1);
				}
			}
		}
		
		System.out.println(dis[d]);
	}
	
	static class Road{
		int s, e, len;
		public Road(int s, int e, int len) {
			this.s = s;
			this.e = e;
			this.len = len;
		}
	}
	
}
