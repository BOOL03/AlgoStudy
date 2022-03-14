package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9625_손준혁 {
	static int K;
		
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		int a_count = 1, b_count = 0;
		int tmp = 0;
		for (int i = 0; i < K; i++) {
			tmp = a_count;
			a_count = b_count;
			b_count += tmp;
		}
		System.out.println(a_count+" "+b_count);
	}
}
