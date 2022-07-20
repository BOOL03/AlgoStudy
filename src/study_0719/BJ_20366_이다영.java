package study_0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20366_이다영 {
	
	static int N;
	static int min;
	static int[] balls;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		balls = new int[N];
		
		for (int i = 0; i < N; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(balls);
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				int snow1 = balls[i] + balls[j];
				
				int left = 0;
				int right = N-1;
				
				while(left < right) {
					if(left == i || left == j) {
						left++;
						continue;
					}
					
					if(right == i || right == j) {
						right--;
						continue;
					}
					
					int snow2 = balls[left] + balls[right];
					
					min = Math.min(min, Math.abs(snow1 - snow2));
					
					if(snow2 > snow1) right--;
					else if(snow2 < snow1) left++;
					else {
						System.out.println(0);
						return;
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
}
