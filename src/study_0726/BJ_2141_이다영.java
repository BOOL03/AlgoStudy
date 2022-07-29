package study_0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2141_이다영 {
	
	static int N;
	static int[][] town;
	static long min;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		town = new int[N][2];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			town[i][0] = Integer.parseInt(st.nextToken());
			town[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(town, (n1, n2) -> n1[0] - n2[0]);
		
		int left = 0;
		int right = N-1;
		
		min = Long.MAX_VALUE;
		ans = Integer.MAX_VALUE;
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			long[] result = calc(mid);
			
			if(min == result[0] + result[1]) {
				ans = Math.min(ans, town[mid][0]);
			}
			else if(min > result[0] + result[1]) {
				min = result[0] + result[1];
				ans = town[mid][0];
			}
			
			if(result[0] < result[1]) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(ans);
		
	}
	public static long[] calc(int point) {
		long left = 0L;
		long right = 0L;
		
		for (int i = 0; i < N; i++) {
			if(town[i][0] < town[point][0]) {
				left += Math.abs(town[point][0] - town[i][0]) * town[i][1];
//				left += town[i][1];
			}else {
				right += Math.abs(town[i][0] - town[point][0]) * town[i][1];
//				right += town[i][1];
			}
		}
		
		long[] result = {left, right};
		
		return result;
	}
}
