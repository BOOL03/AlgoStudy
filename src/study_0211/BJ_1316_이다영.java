package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1316_이다영 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean chk;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int length = str.length();
			chk = true;
			for (int j = 0; j < length; j++) {
				char ch = str.charAt(j);
				String compStr = str.substring(j+1, length);
				int idxof = compStr.indexOf(ch);
				if(idxof!= 0 && idxof!=-1) {
					chk = false;
					break;
				}
			}
			if(chk) count++;
		}
		
		System.out.println(count);
	}

}
