package study_0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_13913_이다영 {
	static int N, K, T;
	static Queue<Integer> queue;
	
	static int[] time = new int[100001];
	static int[] route = new int[100001];
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int idx = K;
		
		while( idx != N) {
			idx = route[idx];
			stack.push(idx);
		}
		
		sb.append(time[K] - 1 + "\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void bfs() {
		queue = new ArrayDeque<>();
		queue.offer(N);
		time[N] = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current == K) break;
			
			int next = current + 1;
			if (next <= 100000 && time[next] == 0) {
				queue.offer(next);
				time[next] = time[current] + 1;
				route[next] = current;
			}
			
			next = current - 1;
			if (next >= 0 && time[next] == 0) {
				queue.offer(next);
				time[next] = time[current] + 1;
				route[next] = current;
			}
			
			next = current * 2;
			if (next <= 100000 && time[next] == 0) {
				queue.offer(next);
				time[next] = time[current] + 1;
				route[next] = current;
			}
		}
	}
}
