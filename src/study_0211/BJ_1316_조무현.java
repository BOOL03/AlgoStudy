package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1316_조무현 {
	static int N;
	static String[] words;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			Map<Character, Integer> alpha = new HashMap<>();
			words[i] = br.readLine();
			boolean isGroup = true;
			int len = words[i].length();
			for (int j = 0; j < len-1; j++) {
				char prev = words[i].charAt(j); // 이전 문자
				char next = words[i].charAt(j+1);
				if(prev == next) { // 이전문자와 다음문자 비교
					continue;
				}
				else {
					if(alpha.get(prev) != null) {
						isGroup = false;
						break;
					}
					if(alpha.get(next) != null) {
						isGroup = false;
						break;
					}
					alpha.put(prev, 1);
				}
				
			}
			
			if(isGroup) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}

}
