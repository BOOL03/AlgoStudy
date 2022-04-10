package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096_이다영 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 최대구하기
		int sum1 = map[0][0];
		int sum2 = map[0][1];
		int sum3 = map[0][2];
		
		for (int i = 1; i < N; i++) {
			int s1 = Math.max(sum1, sum2) + map[i][0];
			int s2 = Math.max(sum1, Math.max(sum2, sum3)) + map[i][1];
			int s3 = Math.max(sum2, sum3) + map[i][2];
			
			sum1 = s1;
			sum2 = s2;
			sum3 = s3;
		}
		
		System.out.print(Math.max(sum1, Math.max(sum2, sum3)) + " ");
		
		// 최소 구하기
		sum1 = map[0][0];
		sum2 = map[0][1];
		sum3 = map[0][2];
		
		for (int i = 1; i < N; i++) {
			int s1 = Math.min(sum1, sum2) + map[i][0];
			int s2 = Math.min(sum1, Math.min(sum2, sum3)) + map[i][1];
			int s3 = Math.min(sum2, sum3) + map[i][2];
			
			sum1 = s1;
			sum2 = s2;
			sum3 = s3;
		}
		
		System.out.println(Math.min(sum1, Math.min(sum2, sum3)));
	}
}
