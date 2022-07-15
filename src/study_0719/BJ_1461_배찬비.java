package study_0719;
import java.io.*;
import java.util.*;

public class BJ_1461_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int left = 0, right = 0;
		
		st = new StringTokenizer(br.readLine());
		int[] books = new int[n];
		for(int i=0; i<n; i++) {
			books[i] = Integer.parseInt(st.nextToken()); 
			if(books[i]<0) left++;
			else right++;
		}
		Arrays.sort(books);
		
		int s = 0;
		int e = n-1;
		int sum = 0;
		
		if(-books[0]<books[n-1]) {
			sum = books[n-1];
			e -= m;
		} else {
			sum = -books[0];
			s += m;
		}
		
		for(int i=s; i<left; i+=m) {
			sum += books[i]*-2;
		}
		for(int i=e; i>=n-right; i-=m) {
			sum += books[i]*2;
		}
		
		System.out.println(sum);
		
	}

}
