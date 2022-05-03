package study_0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_4811_이다영 {
	static BigInteger[] fact;
	static BigInteger[] dp;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		fact = new BigInteger[61];
		
		for (int i = 1; i <= 60; i++) {
			fact[i] = fact(i);
		}
		
		dp = new BigInteger[31];
		
		for (int i = 1; i <= 30; i++) {
			dp[i] = func(i);
		}
		
		while(N!=0) {
			sb.append(dp[N]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
	
	public static BigInteger fact(int x) {
		if(x==1) return BigInteger.valueOf(1);
		else return fact[x-1].multiply(BigInteger.valueOf(x));
	}
	
	public static BigInteger func(int x) {
		// ()()()()()
		// ()()(
		// ()
		//
		// WHWH
		// 다각형 도형 -> 삼각형 ? 
		//
		
		// 카탈란 수
		// 2n!/(n!n!) - 2n!/(n-1)!(n+1)!
		// 2n!/(n+1)!n!
		BigInteger deno = fact[2*x]; // 분모
		BigInteger mole = fact[x].multiply(fact[x+1]) ; //분자
		return deno.divide(mole);
	}
}
