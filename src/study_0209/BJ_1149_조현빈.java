package study_0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_조현빈 {
	static int     LowPrice = Integer.MAX_VALUE;
	static boolean changed  = false;
	static int     N        = 0;
	static int[][] arr      = null;
	static int[][] result   = null;

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N      = Integer.parseInt(br.readLine());
		arr    = new int[N + 1][3];
		result = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			st     = new StringTokenizer(br.readLine());
			arr[i] = new int[]
				{
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
				};
		}

		for (int i = 1; i < N + 1; i++) {
			result[i][0] = Math.min(result[i - 1][1], result[i - 1][2]) + arr[i][0];
			result[i][1] = Math.min(result[i - 1][0], result[i - 1][2]) + arr[i][1];
			result[i][2] = Math.min(result[i - 1][0], result[i - 1][1]) + arr[i][2];
		}

		System.out.println(Math.min(Math.min(result[N][0], result[N][1]), result[N][2]));
	}

	static void paint(int depth) {
		if (depth == N + 1) {
			return;
		}
		result[depth][0] = Math.min(result[depth - 1][1], result[depth - 1][2]) + arr[depth][0];
		result[depth][1] = Math.min(result[depth - 1][0], result[depth - 1][2]) + arr[depth][1];
		result[depth][2] = Math.min(result[depth - 1][0], result[depth - 1][1]) + arr[depth][2];
		return;
	}
}
