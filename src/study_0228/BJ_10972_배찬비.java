package study_0228;
import java.io.*;
import java.util.*;

public class BJ_10972_배찬비 {
	
	static int n;
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if(np()) {
			StringBuilder sb = new StringBuilder();
			for(int x: num) {
				sb.append(x+" ");
			}
			System.out.println(sb.toString());
		} else System.out.println("-1");
	}
	static boolean np() {
		
		int i = n-1;
		while(i>0 && num[i-1]>=num[i]) --i;
		
		if(i==0) return false;
		
		int j = n-1;
		while(num[i-1]>=num[j]) --j;
		
		swap(i-1, j);
		
		int k = n-1;
		while(i<k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int a, int b) {
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
}
