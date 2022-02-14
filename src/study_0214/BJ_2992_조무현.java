package study_0214;

import java.util.Scanner;

public class BJ_2992_조무현 {
	static int[] num;
	static int N;
	static String ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		N = input.length();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = input.charAt(i) - '0';
		}
		
		if(np()) {
			for (int i = 0; i < N; i++) {
				System.out.print(num[i]);
			}
		}else {
			System.out.println(0);
		}
	
	}
	
	static boolean np() {
		// 꼭대기 찾기
		int i = N-1;
		while(i > 0 && num[i-1] >= num[i]) i--;
		
		if( i == 0 ) return false;
		int j = N -1;
		while(num[i-1] >= num[j]) j--;
		
		swap(num, i-1, j);
		
		int k = N -1;
		while(i < k) swap(num, i++, k--);
		return true;
	}
	
	static void swap(int[] src, int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
	
}
