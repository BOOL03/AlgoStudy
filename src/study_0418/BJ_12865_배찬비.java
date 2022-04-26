package study_0418;
import java.util.*;
import java.io.*;

public class BJ_12865_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] bag = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<=k; j++) {
				if(j<w) bag[i][j] = bag[i-1][j];
				else bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-w]+v);
			}
		}
		
		System.out.println(bag[n][k]);
	}
}
