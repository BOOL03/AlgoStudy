package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		int[][]        arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] zeroOne = dfs(arr, 0, 0, N, new int[]
			{
					0, 0
			});
		System.out.printf("%d\n%d", zeroOne[0], zeroOne[1]);
	}

	public static int[] dfs(int[][] arr, int y, int x, int size, int[] zeroOne) {
		if (check(arr, y, x, size)) {
			if (arr[y][x] == 0)
				zeroOne[0]++;
			else
				zeroOne[1]++;

			return zeroOne;
		}
		// 1
		zeroOne = dfs(arr, y, x, size / 2, zeroOne);
		// 2
		zeroOne = dfs(arr, y, x + size / 2, size / 2, zeroOne);
		// 3
		zeroOne = dfs(arr, y + size / 2, x, size / 2, zeroOne);
		// 4
		zeroOne = dfs(arr, y + size / 2, x + size / 2, size / 2, zeroOne);

		return zeroOne;
	}

	public static boolean check(int[][] arr, int y, int x, int size) {
		int prev = arr[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (prev != arr[i][j]) return false;
				prev = arr[i][j];
			}
		}
		return true;
	}
}
