package study_0209;
import java.util.*;
import java.io.*;


public class BJ_1182_배찬비 {
	static int n, s, answer;
	static int[] num;
	static void comb(int index, int sum) {
		if(index!=0 && sum==s) {
			answer++;
		}
		for(int i=index; i<n; i++) {
			comb(i+1, sum+num[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new int[n];
		for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
		
		comb(0, 0);
		System.out.println(answer);
	}
}
