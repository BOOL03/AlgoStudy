package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1439_조무현 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char before = input.charAt(0);
		int cnt = 0;
		for (int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if(before != current) cnt++;
			before = current;
		}
		if(cnt % 2 == 0) {
			cnt = cnt/2;
		}else {
			cnt = cnt/2 + 1;
		}
		System.out.println(cnt);
	}

}
