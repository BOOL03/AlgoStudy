package study_0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_손준혁 {
	static boolean check = false;
	static Place house, festival;
	static boolean[] visited;
	static ArrayList<Place> store = new ArrayList<Place>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine())+2;
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(n == 0)house= new Place(x,y);
				else if(n == N-1) festival= new Place(x,y);
				else {
					store.add(new Place(x,y));
				}
			}
			visited = new boolean[N];
			if(BFS()) System.out.println("happy");
			else System.out.println("sad");
			store.clear();
			check = false;
		}
	}
	static boolean BFS() {
		Queue<Place> pList = new LinkedList<>();
		pList.offer(house);
		while(!pList.isEmpty()) {
			Place p = pList.poll();
			int dx = Math.abs(p.x - festival.x);
			int dy = Math.abs(p.y - festival.y);
			if(dx + dy <= 1000) return true;
			for (int i = 0; i < store.size(); i++) {
				if(!visited[i]) {
					if(Math.abs(p.x - store.get(i).x) + Math.abs(p.y - store.get(i).y) <= 1000) {
						visited[i] = true;
						pList.offer(store.get(i));
					}
				}
			}
		}
		
		return false;
	}
	static class Place{
		int x;
		int y;
		
		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
