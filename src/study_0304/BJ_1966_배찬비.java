package study_0304;
import java.io.*;
import java.util.*;

public class BJ_1966_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2)->e2-e1);
			Queue<int[]> Q = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(num);
				Q.offer(new int[] {num, i});
			}
			
			int cnt = 1;
			while(!Q.isEmpty()) {
				int[] tmp = Q.poll();
				if(tmp[0]==pq.peek()) {
					if(tmp[1]==m) {
						answer.append(cnt+"\n");
						break;
					}
					pq.poll();
					cnt++;
				}
				else Q.offer(tmp);
			}
		}
		System.out.println(answer.toString());
	}
}
