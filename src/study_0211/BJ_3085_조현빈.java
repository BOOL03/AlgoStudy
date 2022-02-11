package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3085_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
		int            N     = Integer.parseInt(br.readLine());
		char[][]       candy = new char[N][N];
		int[]          dy    =
			{
					-1, 0, 1, 0
			};
		int[]          dx    =
			{
					0, 1, 0, -1
			};
		int            cnt   = 1;
		int            max   = 0;

		for (int i = 0; i < N; i++) {
			candy[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ni = i + dy[k];
					int nj = j + dx[k];
					if (ni > N - 1 || ni < 0 || nj > N - 1 || nj < 0) {
						continue;
					}

					char c1 = candy[i][j];
					char c2 = candy[ni][nj];
					candy[i][j]   = c2;
					candy[ni][nj] = c1;

					char prevCandy = candy[i][0];
					cnt = 1;
					for (int l = 1; l < N; l++) {
						if (prevCandy != candy[i][l]) {
							prevCandy = candy[i][l];
							cnt       = 1;
						} else {
							cnt++;
						}
						max = Math.max(cnt, max);
					}
					prevCandy = candy[0][j];
					cnt       = 1;
					for (int l = 1; l < N; l++) {
						if (prevCandy != candy[l][j]) {
							prevCandy = candy[l][j];
							cnt       = 1;
						} else {
							cnt++;
						}
						max = Math.max(cnt, max);
					}

					candy[i][j]   = c1;
					candy[ni][nj] = c2;
				}
			}
		}
		System.out.println(max);
	}
}
