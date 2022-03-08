package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164_조현빈 {
	public static void main(String[] args) throws Exception {
		int            N = Integer
				.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			q.offer(i + 1);
		}

		while (q.size() > 1) {
			// 카드 한장 버림
			q.poll();

			// 그 다음 카드를 골라서 맨 밑으로 옮김
			q.offer(q.poll());
		}

		System.out.println(q.poll());
	}
}
