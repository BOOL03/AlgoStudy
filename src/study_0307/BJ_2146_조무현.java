package study_0307;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2146_조무현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int ans = 1;
		while(queue.size() > 1) {
			// 하나를 버리고
			queue.poll();
			int x = queue.poll();
			ans = x;
			queue.offer(x);
		}
		System.out.println(ans);
	}

}
