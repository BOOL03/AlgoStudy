package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427_조무현 {
	static char[] input;
	static int[] number;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		number = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			number[i] = Character.getNumericValue(input[i]);
		}
		nextPermutation(input.length);
		for (int n : number) {
			System.out.print(n);			
		}
	}
	
	static void nextPermutation(int n) {
		while(true) {
			// 꼭대기 찾기
			int i = n-1;
			while(i > 0 && number[i-1] >= number[i]) i--;
			
			if(i == 0) return;
			
			// i가 꼭대기 index
			int j = n-1;
			while(j > 0 && number[j] <= number[i - 1]) j--;
			
			swap(i-1, j);
			
			int k = n-1;
			// i부터 k까지 swap
			while(i < k) swap(i++, k--); 
		
		}
	}
	
	static void swap(int i, int j) {
		int tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}

}
