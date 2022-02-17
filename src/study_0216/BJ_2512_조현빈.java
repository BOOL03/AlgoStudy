package study_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_조현빈 {
	static int[] arr;
	static long  answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long maximum = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		long low  = 0;
		long high = arr[N - 1];

		while (low <= high) {

			long mid = (low + high) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (arr[i] >= mid)
					sum += mid;
				else
					sum += arr[i];
			}
			if (sum > maximum) {
				high = mid - 1;
			} else {
				low    = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		System.out.println(answer);
	}
}