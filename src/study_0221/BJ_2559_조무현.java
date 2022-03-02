package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_조무현 {
	static int N, K;
	static int[] input;
	static int[] sum;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N];
		sum = new int[N];
		st = new StringTokenizer(br.readLine());
		int hap = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			input[i] = tmp;
			hap += tmp;
			sum[i] = hap;
		}
		max = Math.max(sum[K-1], max);
		for (int i = 1; i <= N-K; i++) {
			max = Math.max((sum[i+K-1] - sum[i-1]), max);
		}
		
		System.out.println(max);
	}

}
