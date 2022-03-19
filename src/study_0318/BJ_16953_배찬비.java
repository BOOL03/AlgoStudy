package study_0318;
import java.io.*;
import java.util.*;

public class BJ_16953_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[b+1];
		
		int answer = -1;
		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {b, 1});
		visited[a] = true;
		while(!Q.isEmpty()) {
			int[] tmp = Q.poll();
			if(tmp[0]<a) continue;
			if(tmp[0]==a) {
				answer = tmp[1];
				break;
			}
			if(tmp[0]%2==0) {
				Q.offer(new int[] {tmp[0]/2, tmp[1]+1});
				visited[tmp[0]/2] = true;
			}
			if(tmp[0]%10==1) {
				Q.offer(new int[] {tmp[0]/10, tmp[1]+1});
				visited[tmp[0]/10] = true;
			}
		}
		
		System.out.println(answer);
		
	}


}
