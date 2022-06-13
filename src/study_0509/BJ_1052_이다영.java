package study_0509;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1052_이다영 {
	static int N, K, water;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		make();
		
	}
	
	public static void make() {
		if( N <= K) {
			System.out.println(0);
			return;
		}
		water = 0;
		while(true) {
			int tmp = N + water;
			int count = 0;
			
			while(tmp > 0) {
				
				if(tmp %2 != 0) count++;
				tmp/=2;
			}
			
			if(count <= K) break;
			water++;
		}
		System.out.println(water);
	}
}