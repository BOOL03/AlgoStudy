package study_0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_손준혁 {

	static int N, min_sum=Integer.MAX_VALUE;
	static int[] paint_orders;
	static int[][] cost;
	
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		paint_orders = new int[N];
		
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			dp[0][i] = cost[0][i];
		}
		System.out.println(Math.min(dpfun(N- 1, 0), Math.min(dpfun(N - 1, 1), dpfun(N - 1, 2))));
	}
//	static void fun(int idx, int limite) {
//		int tmp_sum = 0;
//		if(idx == paint_orders.length) {
//			// add min_sum
//			for (int i = 0; i < N; i++) {
//				tmp_sum += paint_orders[i];
//			}
//			if(tmp_sum < min_sum) min_sum = tmp_sum;
//			return;
//		}
//		for (int i = 0; i < 3; i++) {
//			if(i == limite) continue;
//			paint_orders[idx] = cost[idx][i];
//			fun(idx+1, i);
//		}
//	}
	static int dpfun(int idx, int color) {
		if(dp[idx][color] == 0) {
			if(color == 0) {
				dp[idx][color] = Math.min(dpfun(idx-1, 1),dpfun(idx-1, 2)) + cost[idx][color];
			}
			else if(color == 1) {
				dp[idx][color] = Math.min(dpfun(idx-1, 0),dpfun(idx-1, 2)) + cost[idx][color];
			}
			else {
				dp[idx][color] = Math.min(dpfun(idx-1, 0),dpfun(idx-1, 1)) + cost[idx][color];
			}
			
		}
		return dp[idx][color];
	}

}
