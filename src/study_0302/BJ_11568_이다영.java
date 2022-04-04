package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11568_이다영 {
	static int N, ans;
	static int[] nums;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		
		ans = 1;
		dp[0] = 1;
		
		for (int i = 1; i < N; i++) {
			if(nums[i] > nums[i-1]) dp[i] = dp[i-1]+1;
			else {
				int idx = i-2;
				while(idx>=0) {
					if(nums[i] > nums[idx]) {
						dp[i] = dp[idx] + 1;
						break;
					}
					idx--;
				}
				if(idx<0) dp[i] = 1;
			}
			int idx = i-1;
			int max = 1;
			while(idx>=0) {
				if(nums[i] > nums[idx]) {
					int num = dp[idx] + 1;
					max = Math.max(max, num);
				}
				idx--;
			}
			dp[i] = max;
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
