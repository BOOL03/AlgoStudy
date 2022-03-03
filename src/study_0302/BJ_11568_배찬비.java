package study_0302;
import java.io.*;
import java.util.*;

public class BJ_11568_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] max = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			max[i] = 1;
			for(int j=0; j<i; j++) {
				if(num[i]>num[j]) {
					max[i] = Math.max(max[i], max[j]+1);
				}
			}
			answer = Math.max(answer, max[i]);
		}
		
		System.out.println(answer);
	}
}
