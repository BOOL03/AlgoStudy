package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_쉽게푸는문제_1292 {
	static int S, E;
	static int[] num;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		num = new int[E+1];
		
		int number = 1;
		int cnt = 0;
		for (int i = 1; i <= E; i++) {
			cnt++;
			num[i] = number;
			if(cnt == number) {
				number++;
				cnt = 0;
			}
		}
		
		int sum = 0;
		for (int i = S; i <= E; i++) {
			sum += num[i];
		}
		System.out.println(sum);
	}
}
