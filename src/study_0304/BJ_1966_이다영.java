package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_프린터큐_1966 {
	static int T, N, M;
	static PriorityQueue<int[]> queue;
	static Queue <int[]> queue2;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			queue =new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
			queue2 = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int idx = i;
				int num = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {idx, num});
				queue2.offer(new int[] {idx, num});
			}
			
			int cnt = 0;
			outer: while(true) {
				cnt++;
				int[] arr = queue.poll();
				while(true) {
					int[] arr2 = queue2.poll();
					if(arr[1] == arr2[1]) {
						if(arr2[0] == M) {
							sb.append(cnt).append("\n");
							break outer;
						}
						break;
					}
					queue2.offer(arr2);
				}
			}
		}
		System.out.println(sb);
	}
}
