package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1439_이다영 {
	static boolean[] strArray;
	static int ans;
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int size = str.length();
		
		strArray = new boolean[size];
		
		for (int i = 0; i < size; i++) {
			strArray[i] = str.charAt(i) == '1' ? true : false;
		}
		
		boolean type = strArray[0];
		
		for (int i = 1; i < size; i++) {
			if(type != strArray[i]) {
				ans++;
				for (int j = i; j < size; j++) {
					if(type==strArray[j]) break;
					else {
						strArray[j] = !strArray[j];
					}
				}
			}
		}
		System.out.println(ans);
	}

}
