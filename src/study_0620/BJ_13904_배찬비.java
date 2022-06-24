package study_0620;
import java.io.*;
import java.util.*;

public class BJ_13904_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] homework = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			homework[i][0] = d;
			homework[i][1] = w;
		}
		Arrays.sort(homework, (e1, e2) -> { return e2[0] - e1[0]; });
		
		int day = homework[0][0];
		PriorityQueue<Integer> Q = new PriorityQueue<>((e1, e2) -> e2-e1);
		int sum = 0;
		int index = 0;
		
		for(int i=day; i>0; i--) {

			while(true) {
				if(index==n || homework[index][0] != i) break;
				Q.offer(homework[index++][1]);
			}
			if(!Q.isEmpty()) sum += Q.poll();
		}
		
		System.out.println(sum);
		
	}

}
