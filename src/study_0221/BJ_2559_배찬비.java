package study_0221;
import java.io.*;
import java.util.*;

public class BJ_2559_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<k; i++) sum += num[i];
		
		int answer = sum;
		for(int i=k; i<n; i++) {
			sum = sum+num[i]-num[i-k];
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
