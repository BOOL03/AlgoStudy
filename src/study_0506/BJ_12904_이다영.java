package study_0506;

import java.io.*;

public class BJ_12904_이다영 {
	static String S, T;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		if(makeS()) System.out.println(1);
		else System.out.println(0);
	}
	public static boolean makeS() {
		while(true) {
			if (S.length() > T.length()) return false;
			if (S.equals(T)) return true;
			char ch = T.charAt(T.length()-1);
			if(ch == 'A') T = addA(T);
			else T = flip(T);
		}
	}
	
	public static String addA(String str) {
		return str.substring(0, str.length()-1);
	}
	
	public static String flip(String str) {
		int len = str.length();
		String newStr = "";
		for (int i = len - 2; i >= 0 ; i--) {
			newStr += str.charAt(i);
		}
		
		return newStr;
	}
}