package study_0523;
import java.io.*;
import java.util.*;

public class BJ_5430_배찬비 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] button = new boolean[10];
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		 StringTokenizer st;
		if(m!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int answer = Math.abs(100-n);
		if(m==10) {
			System.out.println(answer);
			return;
		}
		
		for(int i=n; i>=0&&i>=n-answer; i--) {
			String str = String.valueOf(i);
			int cnt = 0;
			for(int j=0; j<str.length(); j++) {
				if(button[str.charAt(j)-'0']) break;
				cnt++;
			}
			if(cnt==str.length()) {
				answer = Math.min(answer, n-i+cnt);
				break;
			}
		}
		
		for(int i=n; i<=n+answer ; i++) {
			String str = String.valueOf(i);
			int cnt = 0;
			for(int j=0; j<str.length(); j++) {
				if(button[str.charAt(j)-'0']) break;
				cnt++;
			}
			if(cnt==str.length()) {
				answer = Math.min(answer, i-n+cnt);
				break;
			}
		}
		
		System.out.println(answer);
		
	}


}
