package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1446_손준혁 {
	static HashMap<Integer, List<Point>> loads;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		
		loads = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(start  > range || end > range) continue;
			if(!loads.containsKey(end)) {
				loads.put(end, new ArrayList<>());
			}
			loads.get(end).add(new Point(cost, start));
		}
		
		int[] distance = new int[range+1]; 

	        for(int i = 1; i<=range; i++){ 
	            int d = distance[i-1]+1;
	            if (loads.containsKey(i)) {
	                for(Point p : loads.get(i)) {
	                    d = Math.min(d, distance[p.point]+p.cost);
	                }
	            }

	        	distance[i] = d;            
	        }

	        System.out.println(distance[range]);
	}
	
	static class Point{
		int cost;
		int point;
		public Point() {}
		public Point(int c, int p) {
			this.cost = c;
			this.point = p;
		}
	}
}
