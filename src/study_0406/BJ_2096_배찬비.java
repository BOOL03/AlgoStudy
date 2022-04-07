package study_0406;
import java.io.*;
import java.util.*;

public class BJ_2096_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] min = new int[n][3];
		int[][] max = new int[n][3];
		int[][] num = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<3; i++) {
			min[0][i] = num[0][i];
			max[0][i] = num[0][i];
		}
		
		for(int i=1; i<n; i++) {
			min[i][0] = num[i][0] + Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] = num[i][1] + Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
			min[i][2] = num[i][2] + Math.min(min[i-1][2], min[i-1][1]);
			
			max[i][0] = num[i][0] + Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] = num[i][1] + Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
			max[i][2] = num[i][2] + Math.max(max[i-1][2], max[i-1][1]);
		}
		
		int max_answer = Math.max(max[n-1][0], Math.max(max[n-1][1], max[n-1][2]));
		int min_answer = Math.min(min[n-1][0], Math.min(min[n-1][1], min[n-1][2]));
		
		System.out.println(max_answer+" "+min_answer);
	}
	
}
