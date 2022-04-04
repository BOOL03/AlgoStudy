package study_0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2531_이다영 {
	static int N, d, k, c, ans;
	static List<Integer> dish;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dish = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			dish.add(Integer.parseInt(br.readLine()));
		}
		
		for (int i = N; i < N+k-1; i++) {
			dish.add(dish.get(i%N));
		}
		
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			Set<Integer> kindOfDish = new HashSet<>( dish.subList(i, i+k) );
			int size = kindOfDish.contains(c) ? kindOfDish.size() : kindOfDish.size()+1;
			if(size == d) {
				System.out.println(d);
				return;
			}
			ans = Math.max(ans, size);
		}
		System.out.println(ans);
	}
}
