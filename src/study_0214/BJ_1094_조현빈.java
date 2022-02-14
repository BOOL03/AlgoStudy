package study_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1094_조현빈 {
	static int[] arr = new int[7];
	static int   sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            X   = Integer.parseInt(br.readLine());
		int            cnt = 0;

		arr[6] = 1;
		while (true) {
			getSum();
			if (sum == X) {
				break;
			}

			int i;
			if (sum > X) {
				for (i = 0; i < 7; i++) {
					if (arr[i] != 0) {
						sum = 0;
						if (arr[i] == 1) {
							arr[i] = 0;
						} else {
							arr[i] = 1;
						}
						arr[i - 1] = 1;
						getSum();
						if (sum < X) {
							arr[i - 1] = 2;
						}
						break;
					}
				}
			}
			sum = 0;
		}
		for (int i = 0; i < 7; i++) {
			if (arr[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void getSum() {
		for (int i = 0; i < 7; i++) {
			if (arr[i] != 0) {
				sum += Math.pow(2, i) * arr[i];
			}
		}
	}
}
