package study_0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_1427_손준혁 {
	static PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		for (int i = 0; i < data.length; i++) {
			qu.offer(data[i]-'0');
		}
		while(!qu.isEmpty()) {
			System.out.print(qu.poll());
		}
	}

}
