package study_0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10282_손준혁 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) -1;
			
			int[][] computers = new int[n][n]; // b -> a
			int[] hacks = new int[n];
			hacks[c] = -1;
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				computers[b-1][a-1] = s;
			}
			
			int count = 0, time = 0;
			Queue<Integer> list = new LinkedList<>();
			list.offer(c);
			while(!list.isEmpty()) {
				int point = list.poll();
				for (int i = 0; i < n; i++) {
					if(point == i || c == i) continue;
					if(computers[point][i] != 0) {
						//count++;
						if(computers[point][i] >= hacks[i] && hacks[i] != 0) continue;
						time = computers[point][i];
						list.offer(i);
						if(hacks[i] > time || hacks[i] == 0) hacks[i] = time;
					}
				}
			}
			
			time = 1;
			for (int i = 0; i < n; i++) {
				//System.out.print(hacks[i] + " ");
				time += hacks[i];
				if(hacks[i] != 0) count++;
			}
			//System.out.println();
			System.out.println(count+" "+time);
		}
	}

}
