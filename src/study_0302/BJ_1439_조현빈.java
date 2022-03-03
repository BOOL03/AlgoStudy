package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1439_조현빈 {
	public static void main(String[] args) throws Exception {
		char[] arr     = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int    oneCnt  = 0;
		int    zeroCnt = 0;
		char   prev    = '2';

		for (int i = 0; i < arr.length; i++) {
			if (prev != arr[i]) {
				if (arr[i] == '0') zeroCnt++;
				else oneCnt++;
			}
			prev = arr[i];
		}

		System.out.println(Math.min(oneCnt, zeroCnt));
	}
}
