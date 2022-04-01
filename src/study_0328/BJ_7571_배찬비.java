package study_0328;

import java.io.*;
import java.util.*;

public class BJ_7571_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] x = new int[m];
		int[] y = new int[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		int xx = x[m/2];
		int yy = y[m/2];
		
		int sum = 0;
		for(int i=0; i<m; i++) {
			sum+=Math.abs(xx-x[i]);
			sum+=Math.abs(yy-y[i]);
		}
		System.out.println(sum);
	}
}
