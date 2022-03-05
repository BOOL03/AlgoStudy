package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1292_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             A   = Integer.parseInt(st.nextToken());
		int             B   = Integer.parseInt(st.nextToken());
		int[]           arr = new int[1001];
		int             cnt = 0;
		for (int i = 0, j = 1; i < 1001; i++) {
			arr[i] = j;
			if (++cnt == j) {
				cnt = 0;
				j++;
			}
		}
		int sum = 0;
		for (int i = A - 1; i < B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
