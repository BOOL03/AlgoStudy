package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2304_조무현 {
	static int N;
	static Pillar[] pillar;
	static ArrayList<Pillar> roof = new ArrayList<Pillar>();
	static class Pillar{
		int x;
		int y;
		public Pillar(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pillar = new Pillar[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pillar[i] = new Pillar(x, y);
		}
		
		Arrays.sort(pillar, (p1, p2)-> p1.x - p2.x);
		
		// 첫 기둥은 낮든 높든 넣는다.
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(pillar[i].y, max);
		}
		Pillar front = null;
		Pillar high = pillar[0];
		Pillar cur;
		int sum = 0;
		if(high.y == max) {
			front = high;
		}else {
			for (int i = 1; i < N; i++) {
				cur = pillar[i];
				if(cur.y > high.y) {
					sum += (cur.x - high.x) * high.y;
					high = cur;
				}
				
				if(cur.y == max) {
					front = pillar[i];
					break;
				}
			}
			
		}
		
		Pillar back = null;
		high = pillar[N-1];
		if(high.y == max) {
			back = high;
		}else {
			for (int i = N-1; i >= 0; i--) {
				cur = pillar[i];
				if(cur.y > high.y) {
					sum += Math.abs(cur.x - high.x) * high.y;
					high = cur;
				}
				
				if(cur.y == max) {
					back = pillar[i];
					break;
				}
			}
		}
		
		
		
		if(front.x == back.x) {
			sum += max;
		}else {
			sum += Math.abs(back.x - front.x + 1) * max;
		}
		
		System.out.println(sum);
		
		
	}

}
