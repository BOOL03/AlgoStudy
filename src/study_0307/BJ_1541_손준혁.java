package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1541_손준혁 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] min_tmps = br.readLine().split("-");
		int result = Integer.MAX_VALUE;
		//55-(50+40)
		for (int i = 0; i < min_tmps.length; i++) {
			String[] plus_tmps = min_tmps[i].split("\\+");
			int tmp = 0;
			for (int j = 0; j < plus_tmps.length; j++) {
				tmp += Integer.parseInt(plus_tmps[j]);
			}
			if(result == Integer.MAX_VALUE) result = tmp;
			else result -= tmp;
		}
		System.out.println(result);
	}
}
