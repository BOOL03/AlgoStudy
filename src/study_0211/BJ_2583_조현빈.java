package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2583_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());
		int             N      = Integer.parseInt(st.nextToken());
		int             M      = Integer.parseInt(st.nextToken());
		int             K      = Integer.parseInt(st.nextToken());
		int[][]         arr    = new int[N][M];
		int[]           dy     =
			{
					-1, 0, 1, 0
			};
		int[]           dx     =
			{
					0, 1, 0, -1
			};
		int[]           result = null;

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int sj = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());

			for (int i = si; i < ei; i++) {
				for (int j = sj; j < ej; j++) {
					arr[i][j] = -1;
				}
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					dfs(i, j, arr, N, M, dx, dy, cnt++);
				}
			}
		}
		result = new int[cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1) {
					continue;
				}
				result[arr[i][j]]++;
			}
		}
		result = Arrays.copyOfRange(result, 1, cnt);
		Arrays.sort(result);
		System.out.println(cnt - 1);
		for (int i = 0; i < cnt - 1; i++) {
			System.out.print(result[i] + " ");
		}
	}

	static void dfs(int i, int j, int[][] arr, int N, int M, int[] dx, int[] dy, int cnt) {
		arr[i][j] = cnt;
		for (int k = 0; k < 4; k++) {
			int ni = i + dy[k];
			int nj = j + dx[k];
			if (ni > N - 1 || ni < 0 || nj > M - 1 || nj < 0 || arr[ni][nj] != 0) {
				continue;
			}
			dfs(ni, nj, arr, N, M, dx, dy, cnt);
		}
	}
}
