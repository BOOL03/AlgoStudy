package study_0418;
import java.util.*;
import java.io.*;

public class BJ_11404_배찬비 {
	
	static int[][] dis;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		dis = new int[n+1][n+1];
		for(int i=1; i<=n; i++) Arrays.fill(dis[i], INF);
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(k==i) continue;
				for(int j=1; j<=n; j++) {
					if(k==j || i==j) continue;
					if(dis[i][k] == INF || dis[k][j] == INF) continue;
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(dis[i][j] == INF) sb.append("0 ");
				else sb.append(dis[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
