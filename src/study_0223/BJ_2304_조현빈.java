package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2304_조현빈 {
	static int[][] field = new int[1001][3];

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int             N  = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st                                         = new StringTokenizer(br.readLine());
			field[Integer.parseInt(st.nextToken())][0] = Integer.parseInt(st.nextToken());
		}

		int height = 0;
		for (int i = 0; i < 1001; i++) {
			field[i][1] = height = Math.max(field[i][0], height);
		}
		height = 0;
		for (int i = 1000; i > -1; i--) {
			field[i][2] = height = Math.max(field[i][0], height);
		}
		int area = 0;
		for (int i = 0; i < 1001; i++) {
			area += Math.min(field[i][1], field[i][2]);
		}
		System.out.println(area);
	}
}
