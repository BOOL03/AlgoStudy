package study_0506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12904_손준혁 {
	static String S;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		String T = br.readLine();
		System.out.println(calc(T));
		
	}
	static int calc(String t) {
		if(t.equals(S)) return 1;
		if(t.length() <= S.length()) return 0;
		int result = 0;
		
		if(t.toCharArray()[t.toCharArray().length-1] == 'A') {
			result = calc(t.substring(0, t.length()-1));
		}
		else {
			t = t.substring(0, t.length()-1);
			StringBuffer sb = new StringBuffer(t);
			String reverse = sb.reverse().toString();
			result = calc(reverse);
		}
		return result;
	}
}
