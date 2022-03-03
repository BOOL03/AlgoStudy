package study_0302;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_조현빈 {
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int             N  = Integer.parseInt(br.readLine());

		arr = new int[N];

		st  = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {

			if (bs(Integer.parseInt(st.nextToken()), N - 1)) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}
		bw.flush();
	}

	static boolean bs(int num, int N) {

		int low  = 0;
		int high = N;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (num < arr[mid]) {
				high = mid - 1;
			} else if (num > arr[mid]) {
				low = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
