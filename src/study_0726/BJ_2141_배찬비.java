package study_0726;
import java.io.*;
import java.util.*;

public class BJ_2141_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] town = new int[n][2];
		long sum = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			town[i][0] = Integer.parseInt(st.nextToken());
			town[i][1] = Integer.parseInt(st.nextToken());
			sum += (long)town[i][1];
		}
		Arrays.sort(town, (e1, e2)->e1[0]==e2[0]?e1[1]-e2[1]:e1[0]-e2[0]);
		
		long mid = (sum+1)/2;
		int index = 0;
		long tmp = 0;
		
		while(tmp<mid) {
			tmp += town[index++][1];
		}
		
		System.out.println(town[index-1][0]);
		
	}

}
