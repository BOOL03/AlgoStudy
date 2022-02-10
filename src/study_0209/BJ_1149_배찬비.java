package study_0209;
import java.util.*;
import java.io.*;


public class BJ_1149_배찬비 {
	static int n;
	static int[][] house;
	static int[][] cost;
	
	static void paint() {
		for(int i=1; i<n; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + house[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + house[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + house[i][2];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		house = new int[n][3];
		cost = new int[n][3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) house[i][j] = Integer.parseInt(st.nextToken());
		}
		
		cost[0] = house[0];
		paint();
		System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));
	}
}
