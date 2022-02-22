package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_조현빈 {
	public static void main(String[] args) throws Exception {
		int     max = Integer.MIN_VALUE;
		int[][] arr = input();
		int     N   = arr.length;

		for (int t = 0; t < 101; t++) {
			int     count = 1;
			int[][] cnt   = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > t && cnt[i][j] == 0) {
						dfs(N, arr, cnt, count++, t, j, i);
					}
				}
			}

			max = max < count ? count : max;
		}
		System.out.println(max - 1);
	}

	public static void dfs(int N, int[][] arr, int[][] cnt, int count, int t, int x, int y) {
		int[] dy =
			{
					-1, 0, 1, 0
			};
		int[] dx =
			{
					0, 1, 0, -1
			};
		cnt[y][x] = count;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
			if (arr[ny][nx] <= t || cnt[ny][nx] != 0) continue;
			dfs(N, arr, cnt, count, t, nx, ny);
		}
	}

	public static int[][] input() throws Exception {
		BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
		int            N        = Integer.parseInt(br.readLine());
		int[][]        inputArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		return inputArr;
	}
}
