package study_0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_2812_이다영 {
	
	static int N, K;
	static String num;
	static Deque<Integer>dq;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dq = new ArrayDeque<>();
		
		num = br.readLine();
		
		for (int i = 0; i < N; i++) {
			int n = num.charAt(i) - '0';
			
			while(cnt < K && !dq.isEmpty() && dq.getLast() < n) {
				dq.pollLast();
				cnt++;
			}
			
			dq.addLast(n);
		}
		
		for (int i = 0; i < N-K; i++) {
			sb.append(dq.pollFirst());
		}
		
		System.out.println(sb);
	}
}
