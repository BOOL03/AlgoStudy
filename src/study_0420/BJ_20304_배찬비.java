package study_0420;
import java.util.*;
import java.io.*;

public class BJ_20304_배찬비 {
	
	static int n, INF = Integer.MAX_VALUE;
	static int[] pass;
	static Queue<Integer> Q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pass = new int[n+1];
		Arrays.fill(pass, INF);
		
		for(int i=0; i<k; i++) {
			int num = Integer.parseInt(st.nextToken());
			pass[num] = 0;
			Q.offer(num);
		}
		
		while(!Q.isEmpty()) {
			int p = Q.poll();
			for(int i=0; i<=19; i++) {
				int tmp = p^(1<<i);
				if(tmp>n) continue;
				if(pass[tmp] == INF) {
					pass[tmp] = pass[p]+1;
					Q.offer(tmp);
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<=n; i++) {
			if(pass[i]!=INF) answer = Math.max(answer, pass[i]);
		}
		System.out.println(answer);
	}
}
