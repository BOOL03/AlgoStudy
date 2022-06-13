package study_0613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_23295_이다영 {
	static int N, T;
	static int []time;
	static int []timeSum;
	static int ansS, ansE;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		time = new int[100000];
		timeSum = new int[100000];
		
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			for (int j = 0; j < t; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				for (int k = s; k < e; k++) {
					time[k]++;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 100000; i++) {
			sum += time[i];
			timeSum[i] = sum;
		}
		
		max = timeSum[T-1];
		ansS = 0;
		ansE = T;
		
		sum = 0;
		for (int i = T; i < 100000; i++) {
			sum = timeSum[i] - timeSum[i-T];
			if(sum > max) {
				max = sum;
				ansS = i-T+1;
				ansE = i+1;
			}
		}
		System.out.println(ansS + " " + ansE);
	}

}
