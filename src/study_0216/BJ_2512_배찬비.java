package study_0216;

import java.io.*;
import java.util.*;

public class BJ_2512_배찬비 {
	
	static int n, m, answer;
	static int[] cost;
	
	static boolean poss(int mid) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum+= (cost[i]<=mid?cost[i]:mid);
		}
		if(sum<=m) return true;
		else return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 0, max = 0;
		n = Integer.parseInt(br.readLine());
		cost = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, cost[i]); // 가장 큰 비용을 max의 초기값 
		}
		m = Integer.parseInt(br.readLine());
		
		min = m/n;  // 가장 최소 
		while(min<=max) {
			int mid = (max+min)/2;
			if(poss(mid)) {
				answer = Math.max(answer, mid);
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		
		System.out.println(answer);
		
	}
	
}
