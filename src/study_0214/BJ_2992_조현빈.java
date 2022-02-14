package study_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2992_조현빈 {
	static char[] arr = null;
	static int    len = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            X  = Integer.parseInt(br.readLine());

		arr = String.valueOf(X).toCharArray();
		len = arr.length - 1;
		int     min  = Integer.MAX_VALUE;
		boolean flag = false;
		while (np()) {
			int N = Integer.parseInt(String.valueOf(arr));
			if (N < min) {
				min  = N;
				flag = true;
			}
		}
		System.out.println(flag ? min : 0);
	}

	static boolean np() {
		int i = len;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = len;
		while (arr[i - 1] >= arr[j]) {
			j--;
		}

		swap(i - 1, j);
		int k = len;

		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void swap(int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
