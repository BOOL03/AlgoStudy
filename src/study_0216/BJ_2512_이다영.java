package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_이다영 {
	static int N;
	static int[] budget;
	static int MAX;
	static int SUM;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		budget = new int[N];
		SUM = 0;
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			SUM += budget[i];
		}
		
		MAX = Integer.parseInt(br.readLine());
		
		//오름차순 정렬
		Arrays.sort(budget);
		
		// 전체 국가예산 총액보다 요청 금액이 작은 경우
		if(MAX >= SUM) {
			System.out.println(budget[N-1]);
			return;
		}else {
			
			ans = 0;
			int start = 0;
			int end = budget[N-1];
			
			while(start <= end) {
				int mid = (start+end)/2;
				int sum = 0;
				
				for (int i = 0; i < N; i++) {
					if(budget[i] <= mid) {
						sum += budget[i];
					}else {
						sum += mid;
					}
				}
				
				if(sum > MAX) {
					end = mid-1;
				}
				else {
					ans = Math.max(ans, mid);
					start = mid+1;
				}
				
			}
		}
		
		System.out.println(ans);
	}

}
