package study_0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_이다영 {
	static int H, W, rain;
	static int[] left;
	static int[] right;
	static int[] block;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		left = new int[W];
		right = new int[W];
		block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W; i++) {
			left[i] = Math.max(left[i-1], block[i-1]);
		}
		
		for (int i = W-2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], block[i+1]);
		}
		
		for (int i = 0; i < W; i++) {
			int min = Math.min(left[i], right[i]);

			if(min > block[i]) rain+= (min - block[i]);
		}
		
		System.out.println(rain);
	}
}
