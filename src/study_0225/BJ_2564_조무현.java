package study_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2564_조무현 {
	static int N, M, K;
	static int dong_dir, dong_x;
	static ArrayList<int[]> places = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		int dir, x;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			places.add(new int[] {dir, x});
		}
		st = new StringTokenizer(br.readLine());
		dong_dir = Integer.parseInt(st.nextToken());
		dong_x = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += min_distance(places.get(i)[0], places.get(i)[1]);
		}
		System.out.println(sum);
	}
	
	static int min_distance(int dir, int x) {
		// 같은 변에 있을 경우
		if(dir == dong_dir) {
			return Math.abs(dong_x - x);
		}else {
			switch(dong_dir) {
			case 1:
				if(dir == 2) {
					int sum = N + x + dong_x;
					int sum2 = N + (M*2 -x - dong_x);
					return Math.min(sum, sum2);
				}
				
				else if(dir == 3) {
					return x + dong_x;
				}
				else if(dir == 4) {
					return M - dong_x + x;
				}
				break;
			case 2:
				if(dir == 1) {
					int sum = N + x + dong_x;
					int sum2 = N + (M*2 -x - dong_x);
					return Math.min(sum, sum2);
				}
				
				else if(dir == 3) {
					return N - x + dong_x;
				}
				else if(dir == 4) {
					return N - x + M - dong_x;
				}
				break;
			case 3:
				if(dir == 1) {
					return x + dong_x;
				}
				
				else if(dir == 2) {
					return N - dong_x + x;
				}
				else if(dir == 4) {
					int sum = M + x + dong_x;
					int sum2 = M + (N*2 -x - dong_x);
					return Math.min(sum, sum2);
				}
				break;
			case 4:
				if(dir == 1) {
					return M - x + dong_x;
				}
				
				else if(dir == 2) {
					return N - dong_x + M - x;
				}
				else if(dir == 3) {
					int sum = M + x + dong_x;
					int sum2 = M + (N*2 -x - dong_x);
					return Math.min(sum, sum2);
				}
				break;
			
			}
		
		}
		return 0;
	}

}
