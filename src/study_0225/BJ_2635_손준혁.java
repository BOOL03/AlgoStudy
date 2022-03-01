package study_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2635_손준혁 {
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> save = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0, max = 0;
		int frist = N, second = N, thrid = N;
		save.offer(N);
		while(true) {
			queue.offer(N);
			queue.offer(second);
			while(true) {
				int result = frist - second;
				if(result < 0) break;
				count++;
				queue.offer(result);
				frist = second;
				second = result;
			}
			if(max < count) {
				max = count;
				save.clear();
				while(!queue.isEmpty()) {
					save.offer(queue.poll());
				}
			}
			queue.clear();
			count = 0;
			thrid--;
			second = thrid;
			frist = N;
			if(second < 0 )break;
		}
		System.out.println(max+2);
		while(!save.isEmpty()) {
			System.out.print(save.poll()+" ");
		}
	}
}
