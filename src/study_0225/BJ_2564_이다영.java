package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
10 10
3
4 6
2 8
1 4
1 2

 */
public class BJ_경비원_2564 {
	static int N, M, K, ans;
	static int sx, sy;
	static List<int[]> store;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		store = new ArrayList<>();
		
		for (int i = 0; i <= K ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = 0;
			if(d==1) y = 0; //북쪽
			
			else if(d==2) y = N; //남쪽
			
			else if(d==3) { //서쪽
				y = x;
				x = 0;
			}
			else if(d==4) { //동쪽
				y = x;
				x = M;
			}
			if(i < K) store.add(new int[] {y, x});
			else {
				sy = y;
				sx = x;
			}
		}
		
		int size = store.size();
		for (int i = 0; i < size; i++) {
			int y = store.get(i)[0];
			int x = store.get(i)[1];
			int totalDis = 2*(N+M);
			int dis = 0;
			if((y == 0 && sy == 0) || (y == N && sy == N) || (x == 0 && sx == 0) || (x == M && sx == M)) dis = Math.abs(sy-y) + Math.abs(sx-x);
			else if(Math.abs(y-sy) == N) dis = Math.min(N + sx + x, totalDis - (N + sx + x));
			else if(Math.abs(x-sx) == M)  dis = Math.min(M + sy + y, totalDis - (M + sy + y));
			else dis = Math.abs(sy-y) + Math.abs(sx-x);
			
			ans+=dis;
		} 
		System.out.println(ans);
	}
}
