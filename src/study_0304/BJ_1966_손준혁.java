package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966_손준혁 {
	static int impo;
	
	static Queue<int[]> list = new LinkedList<>();
	static PriorityQueue<Integer> impo_queue = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			impo = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				int tmp_impo = Integer.parseInt(st.nextToken());
				list.offer(new int[] {tmp_impo, i});
				impo_queue.offer(tmp_impo);
			}
			
			Dequeue();
			impo_queue.clear();
			list.clear();
		}
	}
	static void Dequeue() {
		int count = 0;
		while(!list.isEmpty()) {
			int[] tmp = list.poll();
			int max_impo = impo_queue.poll();
			if(max_impo > tmp[0]) {
				impo_queue.offer(max_impo);
				list.offer(tmp);
				continue;
			}
			count++;
			if(tmp[1] == impo) {
				System.out.println(count);
				return;
			}
		}
	}
}
