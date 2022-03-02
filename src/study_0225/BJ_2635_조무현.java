package study_0225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2635_조무현 {
	static int N;
	static int max;
	static ArrayList<Integer> max_result = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = 0;
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(N);
			arr.add(i);
			int index = 2;
			while(true) {
				int result = arr.get(index - 2) - arr.get(index -1);
				if(result < 0) {
					break;
				}else {
					arr.add(result);
					index++;
				}
			}
			if(max < arr.size()) {
				max = arr.size();
				max_result = (ArrayList<Integer>) arr.clone();
			}
		}
		System.out.println(max);
		for (int x : max_result) {
			System.out.print(x + " ");
		}
	}

}
