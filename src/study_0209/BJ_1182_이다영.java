package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_부분수열의합_1182 {
	static int N, S, COUNT;
	static int [] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		if(S==0 && COUNT>0) COUNT--;  
		System.out.println(COUNT);
	}
	static void subset(int srcIdx) {
		if(srcIdx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(select[i]) {
					sum += src[i];
				}
			}
			if(sum == S) {
				COUNT++;
			}
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx+1);
		
		select[srcIdx] = false;
		subset(srcIdx+1);
	}

}
