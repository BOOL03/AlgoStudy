package study_0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2559_조현빈 {
	public static void main(String[] args) throws IOException {
		int[] arr = input();
		int   N   = arr[arr.length - 2];
		int   K   = arr[arr.length - 1];
		arr = Arrays.copyOf(arr, arr.length - 2);
		int max = 0;

		for (int i = 0; i < K; i++) {
			max += arr[i];
		}

		int sum = max;

		for (int i = K; i < N; i++) {
			sum = sum - arr[i - K] + arr[i];
			max = sum > max ? sum : max;
		}

		System.out.println(max);
	}

	public static int[] input() throws IOException {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st    = new StringTokenizer(br.readLine());

		int             N     = Integer.parseInt(st.nextToken());
		int             K     = Integer.parseInt(st.nextToken());
		int[]           arr   = new int[N + 2];
		int             index = 0;

		st     = new StringTokenizer(br.readLine());
		arr[0] = 0;

		for (index = 0; index < N; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}

		arr[index++] = N;
		arr[index]   = K;

		return arr;
	}
}
