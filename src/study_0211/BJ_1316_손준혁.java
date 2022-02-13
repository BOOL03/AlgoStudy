package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1316_손준혁 {

	static int T, count;
	static char[] words;
	static int[] alpha = new int[26];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		count = T;
		for (int i = 0; i < T; i++) {
			String tmp = br.readLine();
			words = tmp.toCharArray();
			for (int j = 0; j < words.length; j++) {
				int tmp_int = words[j]-97;
				if(j > 0) {
					if(alpha[tmp_int] > 0 && words[j-1] != words[j]) {
						count--;
						break;
					}
				}
				alpha[tmp_int]++;
			}
			alpha = new int[26];
		}
		System.out.println(count);
	}

}
