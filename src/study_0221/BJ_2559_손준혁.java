package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2559_손준혁 {
	static int N,K, maxSum=Integer.MIN_VALUE;
	static int[] arrays;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arrays = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrays[i] = Integer.parseInt(st.nextToken());
		}
		cal();
		System.out.println(maxSum);
	}
	static void cal() {
		for (int i = 0; i <= N-K; i++) {
			int tmpSum = 0;
			for (int j = i; j < i+K; j++) {
				tmpSum += arrays[j];
			}
			maxSum = Math.max(maxSum, tmpSum);
		}
	}

}
