package study_0613;

import java.util.*;
import java.io.*;

public class BJ_23295_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int lastTime = 0;
		ArrayList<int[]>[] list = new ArrayList[N];

		for (int n = 0; n < N; n++) {
			list[n] = new ArrayList<>();
			int K = Integer.parseInt(br.readLine());
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (end > lastTime)
					lastTime = end + 1;

				list[n].add(new int[] { start, end });
			}
		}

		int[][] arr = new int[N][lastTime];
		// int[][] arr = new int[N][15];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				int start = list[i].get(j)[0];
				int end = list[i].get(j)[1];

				for (int k = start + 1; k < end + 1; k++) {
					arr[i][k] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < lastTime; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i][j];
				if (j > T) {
					arr[i][j] = arr[i][j] - arr[i][j - T];
				}
			}
		}

		int maxSatisfaction = 0;
		int startTime = 0;
		int endTime = 0;
		for (int i = T; i < lastTime; i++) {
			int toSum = 0;
			for (int j = 0; j < N; j++) {
				toSum += arr[j][i];
			}

			int fromSum = 0;
			for (int j = 0; j < N; j++) {
				fromSum += arr[j][i - T];
			}

			int satisfaction = fromSum + toSum;

			if (satisfaction > maxSatisfaction) {
				maxSatisfaction = satisfaction;
				startTime = i - T;
				endTime = i;
			}
		}
		System.out.println(startTime + " " + endTime);
	}
}
