package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_조무현 {
	static int N, M;
	static long[] inputN;
	static long[] inputM;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inputN = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputN[i] = (long)(Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		inputM = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			inputM[i] = (long)(Integer.parseInt(st.nextToken()));
		}
		// 정렬 후 이분탐색
		Arrays.sort(inputN);
		for (int i = 0; i < M; i++) {
			// 찾아야할 대상
			boolean found = false;
			long input = inputM[i];
			int start = 0;
			int end = N-1;
			int mid = (start + end) /2;
			while(true) {
				long mid_value = inputN[mid];
				if(mid_value == input) {
					found = true;
					break;
				}
				if(start > end) break;
				if(input < mid_value) {
					end = mid-1;
				}else if(input > mid_value) {
					start = mid+1;
				}else {
					found = true;
					break;
				}
				mid = (start + end) /2;
				
			}
			if(found) {
				sb.append("1").append("\n");
			}else {
				sb.append("0").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
