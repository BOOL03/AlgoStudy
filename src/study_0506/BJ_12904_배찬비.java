package study_0506;
import java.util.*;
import java.io.*;

public class BJ_12904_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int s = str2.length()-1;
		while(str2.length()>0) {
			if(str2.equals(str1)) {
				System.out.println("1");
				return;
			}
			if(s<str1.length()) {
				break;
			}
			
			if(str2.charAt(s)=='A') {
				str2 = str2.substring(0, s--);
			} else {
				str2 = str2.substring(0, s--);
				str2 = new StringBuilder(str2).reverse().toString();
			}
		}
		
		System.out.println("0");
		
	}

}
