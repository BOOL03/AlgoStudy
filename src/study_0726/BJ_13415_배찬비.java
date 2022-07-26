package study_0726;
import java.io.*;
import java.util.*;

public class BJ_13415_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		int[] answer = new int[n];
		for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		Deque<int[]> Q = new ArrayDeque<>();
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int knum = Integer.parseInt(st.nextToken());
			while(!Q.isEmpty() && Q.peekLast()[0]<=knum) {
				Q.pollLast();
			}
			Q.offer(new int[] {knum, 0});
			
			knum = Integer.parseInt(st.nextToken());
			while(!Q.isEmpty() && Q.peekLast()[0]<=knum) {
				Q.pollLast();
			}
			Q.offer(new int[] {knum, 1});
		}
		
		Q.offerLast(new int[] {0, 0});
		int[] max = Q.pollFirst();
		for(int i=max[0]; i<n; i++) answer[i] = num[i];
		Arrays.sort(num, 0, max[0]);
		
		int aindex = 0, dindex = max[0]-1;
		int s = 0, e = max[0]-1;
		int order = max[1];
		
		while(!Q.isEmpty()) {
			int[] t = Q.pollFirst();
			s = t[0]-1;
			if(order==1) {
				for(int i=e; i>s; i--) {
					answer[i] = num[aindex++];
				}
			} else {
				for(int i=e; i>s; i--) {
					answer[i] = num[dindex--];
				}
			}
			e = s;
			order = t[1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : answer) sb.append(i+" ");
		System.out.println(sb.toString());
		
	}

}
