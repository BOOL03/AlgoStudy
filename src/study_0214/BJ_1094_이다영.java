package study_0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1094_이다영 {

	static int X;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		
		PriorityQueue <Integer> queue = new PriorityQueue <>();
		
		int sum = 64;
		queue.offer(64);
		
		while(true) {
			if(sum == X) {
				System.out.println(queue.size());
				break;
			}
			
			if(sum > X) {
				int shortBar = queue.poll();
				sum -= shortBar;
				sum += shortBar/2;
				if(sum >= X) queue.offer(shortBar/2);
				else {
					sum += shortBar/2;
					queue.offer(shortBar/2);
					queue.offer(shortBar/2);
				}
			}	
		}
	}
}
