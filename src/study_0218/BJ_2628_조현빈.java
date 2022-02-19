package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2628_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());
		int             O   = Integer.parseInt(br.readLine());
		int[][]         arr = new int[O][2];
		int             cnt = 0;
		int             max = Integer.MIN_VALUE;
		for (int i = 0; i < O; i++) {
			st        = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if (arr[i][0] == 0) {
				cnt++;
			}
		}
		int[] arr1  = new int[cnt + 1];
		int[] arr2  = new int[O - cnt + 1];
		int   index = 0;
		int   jndex = 0;
		for (int i = 0; i < O; i++) {
			if (arr[i][0] == 0) {
				arr1[index++] = arr[i][1];
			} else {
				arr2[jndex++] = arr[i][1];
			}
		}
		arr1[cnt]     = M;
		arr2[O - cnt] = N;

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int y = 0;
		for (int i = 0; i <= cnt; i++) {
			int ny = arr1[i];
			int x  = 0;
			for (int j = 0; j <= O - cnt; j++) {
				int nx     = arr2[j];
				int width  = nx - x;
				int height = ny - y;
				int area   = width * height;
				max = Math.max(area, max);
				x   = nx;
			}
			y = ny;
		}
		System.out.println(max);
	}
}
