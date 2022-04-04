package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5904_이다영 {
	static int N;
	static char[] mooArray = {'m', 'o', 'o'};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		moo(N, 1, 3);
	}
	public static void moo(int n, int k, int len) {
		int new_len = len * 2 + (k+3);
		if (n <= 3) {
			System.out.println(mooArray[n-1]);
			return;
		}
		
		if(new_len < n) {
			moo(n, k+1, new_len);
		}
		else if(len < n && n <= len+k+3) {
			if(len+1 == n) {
				System.out.println("m");
				return;
			}else {
				System.out.println("o");
				return;
			}
		}else {
			moo(n-(len+k+3), 1, 3);
		}
	}
}
