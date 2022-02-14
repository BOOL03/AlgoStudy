package study_0214;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1094_조무현 {
	static int X;
	static int[] sticks = new int[7];


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		// 첫 막대
		int count = 1;
		int sum = 64;
		int cur_stick = 64;
		sticks[6] = 1;
		while(sum > X) {
			int index = findIndex(cur_stick);
			sticks[index] -= 1;
			int half1 = cur_stick / 2;
			int half2 = cur_stick - half1;
			index = findIndex(half1);
			int tmp = sum() + half1;
			cur_stick = half1;
			if(tmp >= X) {
				sticks[index] = 1;
			}else {
				sticks[index] = 2;
			}
			sum = sum();
			if(sum == X) break;	
		}
		int ans = 0;
		for (int i = 0; i < 7; i++) {
			ans += sticks[i];
		}
		System.out.println(ans);
		
		
		
	}
	static int findIndex(int x) {
		int y = x;
		int count = 0;
		while(true) {
			y = y /2 ;
			if(y > 0) count++;
			else break;
		}
		return count;
	}
	static int sum() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += (sticks[i] << i);
		}
		return sum;
	}
	

	
}
