package study_0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_손준혁 {
	static int N,K,MaxValue = Integer.MIN_VALUE;
	static Package[] packages;
	
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		packages = new Package[N];
		dp = new int[N+1][K+1];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			packages[n] = new Package(W,V);
		}
		backpack();
		System.out.println(MaxValue);
	}

	static void backpack() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(packages[i-1].W <= j)
					dp[i][j] = Math.max(packages[i-1].V + dp[i-1][j - packages[i-1].W], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
				MaxValue = Math.max(dp[i][j], MaxValue);
			}
		}
	}
	static class Package{
		int W;
		int V;
		public Package(int w, int v) {
			this.W = w;
			this.V = v;
		}
	}
}
