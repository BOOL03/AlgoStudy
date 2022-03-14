package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164_손준혁 {

	static int N;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		int poll = queue.poll();
		System.out.println(poll);
	}

}
