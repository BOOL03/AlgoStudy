package study_0209;

import java.util.Scanner;

public class BJ_1182_조무현 {

	static int N, S, COUNT;
	static int[] numbers;
	static boolean[] select;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		numbers = new int[N];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		COUNT = 0;
		combination(0);
		System.out.println(COUNT);
	}
	
	static void combination(int srcIdx) {
		// 기저조건
		if(srcIdx == N) {
			int sum = 0;
			boolean haveNum = false;
			for (int i = 0; i < N; i++) {
				if(select[i]) {
					haveNum = true;
					sum += numbers[i];
				}
			}
			if(haveNum && sum == S) {
				COUNT++;
			}
			return;
		}
		
		// 선택하거나
		select[srcIdx] = true;
		combination(srcIdx + 1);
		// 선택하지 않거나
		select[srcIdx] = false;
		combination(srcIdx + 1);
	}

	
}
