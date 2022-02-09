package study_0209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_1182_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());
		int             N      = Integer.parseInt(st.nextToken());
		int             S      = Integer.parseInt(st.nextToken());
		int[]           arr    = new int[N];
		int[]           subset = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getSubset(0, 0, N, S, arr, subset, 0));
	}

	static int getSubset(int depth, int start, int N, int S, int[] arr, int[] subset, int cnt) {
		if (depth == N) {
			return cnt;
		}

		int sum = 0;
		for (int i = start; i < N; i++) {
			subset[depth] = arr[i];
			sum           = getSum(subset, depth + 1);
			if (sum == S) {
				cnt += 1;
			}
			cnt           = getSubset(depth + 1, i + 1, N, S, arr, subset, cnt);
			subset[depth] = 0;
		}
		return cnt;
	}

	static int getSum(int[] subset, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += subset[i];
		}
		return sum;
	}
}
