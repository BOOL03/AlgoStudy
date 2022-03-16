package study_0316;
import java.io.*;
import java.util.*;

public class BJ_13335_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] car = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			car[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {car[0], 1});
		int cur = 1;
		int sum = car[0];
		int index = 1;
		while(!Q.isEmpty()) {
			cur++;
			if(cur-Q.peek()[1]==w) {
				sum -= Q.poll()[0];
			}
			if(index<n && sum+car[index]<=l) {
				Q.offer(new int[] {car[index], cur});
				sum += car[index++];
			}
		}
		
		System.out.println(cur);
	}

}
