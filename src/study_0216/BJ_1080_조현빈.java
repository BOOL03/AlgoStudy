package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1080_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		if (N < 3 && M < 3) {
			System.out.println(-1);
			return;
		}

		char[][]    arr1 = new char[N][M];
		char[][]    arr2 = new char[N][M];
		boolean[][] brr  = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			arr1[i] = br.readLine().toCharArray();
		}
		boolean isEqual = true;
		for (int i = 0; i < N; i++) {
			arr2[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr1[i][j] != arr2[i][j]) {
					brr[i][j] = true;
					isEqual   = false;
				}
			}
		}

		if (isEqual) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (i == N - 3 && !(brr[i][j] == brr[i + 1][j] && brr[i][j] == brr[i + 2][j])) {
					System.out.println(-1);
					return;
				}
				if (j == M - 3 && !(brr[i][j] == brr[i][j + 1] && brr[i][j] == brr[i][j + 2])) {
					System.out.println(-1);
					return;
				}
				if (brr[i][j]) {
					for (int k = i; k < i + 3; k++) {
						for (int l = j; l < j + 3; l++) {
							brr[k][l] = !brr[k][l];
						}
					}
					cnt++;
				}
			}
		}
		boolean flag = brr[N - 3][M - 3];
		for (int i = N - 1; i > M - 3; i--) {
			for (int j = M - 1; j > M - 3; j--) {
				if (flag != brr[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
		return;
	}
}
