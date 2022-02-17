package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		int[]           arr = new int[N + 1];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (s == 1) {
				int a = 1;
				while (true) {
					try {
						arr[n * a] ^= 1;
						a++;
					} catch (ArrayIndexOutOfBoundsException e) {
						break;
					}
				}
			} else {
				int a = 1;
				arr[n] ^= 1;
				while (true) {
					try {
						if (n - a < 1 || n + a > N) {
							break;
						}
						if (arr[n - a] == arr[n + a]) {
							arr[n - a] ^= 1;
							arr[n + a] ^= 1;
							a++;
						} else {
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						break;
					}
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
