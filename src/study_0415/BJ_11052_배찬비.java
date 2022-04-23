package study_0415;
import java.util.*;
import java.io.*;

public class BJ_11052_배찬비 {
	
	static boolean[] isExist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cost = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i/2; j++) {
				cost[i] = Math.max(cost[i], cost[i-j] + cost[j]);
			}
		}

		System.out.println(cost[n]);

	}

}
