package study_0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16120_이다영 {
	static boolean chk;
	static int cnt;
	static String str;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		int size = str.length();
		
		chk = true;
		
		for (int i = 0; i < size; i++) {
			char ch = str.charAt(i);
			
			if(ch == 'P') cnt++;
			else if(ch == 'A') {
				if(cnt >= 2 && i+1 < size && str.charAt(++i) == 'P') cnt--;
				else {
					chk = false;
					break;
				}
			}
		}
		
		if(!chk || cnt != 1) System.out.println("NP");
		else System.out.println("PPAP");
	}
}
