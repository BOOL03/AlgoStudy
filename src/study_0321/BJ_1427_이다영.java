package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427_이다영 {
	static int[] number;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int size = str.length();
		number = new int[size];
		
		for (int i = 0; i < size; i++) {
			number[i] = str.charAt(i) - '0';
		}
		
		Arrays.sort(number);
		
		for (int i = size-1; i >=0; i--) {
			sb.append(number[i]);
		}
		
		System.out.println(sb);
	}
}
