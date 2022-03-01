package study_0228;
import java.io.*;
import java.util.*;

public class BJ_15903_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> Q = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			Q.offer(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			long sum = Q.poll()+Q.poll();
			Q.offer(sum);
			Q.offer(sum);
		}
		
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum += Q.poll();
		}
		System.out.println(sum);
	}
}
