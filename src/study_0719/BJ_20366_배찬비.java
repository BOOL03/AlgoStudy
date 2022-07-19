package study_0719;
import java.io.*;
import java.util.*;

public class BJ_20366_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = Integer.MAX_VALUE;
		int[] snow = new int[n];
		for(int i=0; i<n; i++) snow[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(snow);
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int s = 0;
				int e = n-1;
				int tall = snow[i] + snow[j];
				
				while(s<e) {
					if(s==i || s==j) {
						s++;
						continue;
					}
					if(e==j || e==i) {
						e--;
						continue;
					}
					int sum = snow[s] + snow[e];
					int dif = Math.abs(tall-sum);
					answer = Math.min(answer, dif);
					if(answer == 0) break;
					
					if(tall>sum) s++;
					else e--;
				}
			}
		}
		
		System.out.println(answer);
	}

}
