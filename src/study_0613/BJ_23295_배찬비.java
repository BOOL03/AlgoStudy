package study_0613;
import java.io.*;
import java.util.*;

public class BJ_23295_배찬비 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] cnt = new int[100000];
		int[] good = new int[100000];
		
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				for(int m=s; m<e; m++) cnt[m]++;
			}
		}
		int sum = 0;
		for(int i=0; i<100000; i++) {
			sum += cnt[i];
			good[i] = sum;
		}
		
		int time = -1;
		int max = good[t-1];
		for(int i=t; i<100000; i++) {
			if(max<good[i]-good[i-t]) {
				max = good[i]-good[i-t];
				time = i-t;
			}
		}
		
		System.out.println((time+1)+" "+(time+t+1));
		
	}

}
