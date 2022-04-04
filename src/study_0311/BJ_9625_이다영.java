package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BJ_9625_이다영 {
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int ansA = 1;
		int ansB = 0;
		
		for (int i = 0; i < N; i++) {
			int tmpA = ansB;
			int tmpB = ansA + ansB;
			
			ansA = tmpA;
			ansB = tmpB;
		}
		
		System.out.println(ansA+ " " +ansB);
	}
}
