package study_0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2141_이다영2 {
	
	static int N;
	static int[][] town;
	static long people;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		town = new int[N][2];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			town[i][0] = Integer.parseInt(st.nextToken());
			town[i][1] = Integer.parseInt(st.nextToken());
			people += town[i][1];
		}
		
		Arrays.sort(town, (n1, n2) -> n1[0] == n2[0] ? n2[1] - n1[1] : n1[0] - n2[0]);
		
		long sum = 0;
		

		for (int i = 0; i < N; i++) {
			sum += town[i][1];
			if(sum >= (people+1)/2) {
				System.out.println(town[i][0]);
				break;
			}
		}
	}
}
