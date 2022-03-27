package study_0325;

import java.io.*;
import java.util.*;

public class BJ_2531_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] eat = new int[d+1];
		int[] sushi = new int[n+k-1];
		for(int i=0; i<n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for(int i=n; i<n+k-1; i++) {
			sushi[i] = sushi[i-n];
		}
		
		eat[c] = 1;
		int cnt = 1;
		for(int i=0; i<k; i++) {
			if(eat[sushi[i]]==0) cnt++;
			eat[sushi[i]]++;
		}
		int answer = cnt;
		
		for(int i=k; i<n+k-1; i++) {
			int s = sushi[i-k];
			int e = sushi[i];
			if(eat[s]==1) cnt--;
			eat[s]--;
			if(eat[e]==0) {
				cnt++;
				answer = Math.max(answer, cnt);
			}
			eat[e]++;
		}
		System.out.println(answer);
	}
	
}
