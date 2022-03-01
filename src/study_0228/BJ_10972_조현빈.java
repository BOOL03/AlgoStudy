package study_0228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_10972_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		int             N   = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int[]           arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (np(arr, N)) {
			for (int i = 0; i < N; i++) {
				bw.write(String.format("%d ", arr[i]));
			}
		} else {
			bw.write("-1");
		}

		bw.flush();
	}

	static boolean np(int[] arr, int N) {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) i--;
		if (i == 0) return false;
		int j = N - 1;
		while (arr[i - 1] >= arr[j]) j--;
		swap(arr, i - 1, j);
		int k = N - 1;
		while (i < k) swap(arr, i++, k--);
		return true;
	}

	static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

}
