package study_0415;
import java.util.*;
import java.io.*;

public class BJ_4811_배찬비 {
	
	static long[][] num = new long[31][31];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			sb.append(dp(n, 0)+"\n");
		}

		System.out.println(sb.toString());
	}

	static long dp(int w, int h) {
		if(w==0) return 1;
		if(num[w][h]!=0) return num[w][h];
		
		num[w][h] = dp(w-1, h+1);
		if(h!=0) num[w][h] += dp(w, h-1);
		return num[w][h];
	}
}
