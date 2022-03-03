package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11568_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		int             N    = Integer.parseInt(br.readLine());
		StringTokenizer st   = new StringTokenizer(br.readLine());
		// DP(N, st);
		List<Integer>   list = new ArrayList<>();

		list.add(Integer.parseInt(st.nextToken()));

		for (int i = 1; i < N; i++) {
			boolean flag = true;
			int     num  = Integer.parseInt(st.nextToken());
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) >= num) {
					list.remove(j);
					list.add(j, num);
					flag = false;
					break;
				}
			}
			if (flag) list.add(num);
		}

		System.out.println(list.size());
	}

	static void DP(int N, StringTokenizer st) {
		int[] arr = new int[N];
		int[] dp  = new int[N];
		int   max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i + 1; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
