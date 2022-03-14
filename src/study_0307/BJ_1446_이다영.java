package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다익스트라 
public class BJ_지름길_1446 {
	static int N, distance, ans;
	static int road[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		
		road = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
			road[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(road, (n1, n2) -> n2[1] == n1[1] ? n1[0] - n2[0]  : n1[1] - n2[1]);
		Arrays.sort(road, (n1, n2) -> n2[1] == n1[1] ? (n1[0]+n1[2]) - (n2[0]+n2[2]) : n1[1] - n2[1]);
		
		
		for (int i = 0; i < N; i++) {
			if(road[i][1] > distance) continue;
			
		}
	}

}
