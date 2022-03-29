package study_0328;

import java.io.*;
import java.util.*;

public class BJ_5904_배찬비{
	
	static int n;
	static char find(int k, int s) {
		int k1 = (s-(k+3))/2;
		int tmp = n-(k1);
		if(n<=k1) return find(k-1, k1);
		else if(tmp==1) return 'm';
		else if(tmp<=k+3) return 'o';
		else {
			n = tmp-(k+3);
			return find(k-1, k1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int i = 0;
		int s = 3;
		while(true) {
			if(s>=n) break;
			s = s+(++i+3)+s;
		}
		
		System.out.println(find(i, s));
	}
	
}
