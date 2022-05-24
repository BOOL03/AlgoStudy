package study_0520;
import java.io.*;
import java.util.*;

public class BJ_1727_배찬비 {
	
	static int n, m;
	static int[] men, women;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		men = new int[n];
		women = new int[m];
		dp = new int[n+1][m+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) men[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) women[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(men);
		Arrays.sort(women);
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp[i][j] = dp[i-1][j-1]+Math.abs(men[i-1]-women[j-1]);
				if(i<j) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				else if(i>j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
