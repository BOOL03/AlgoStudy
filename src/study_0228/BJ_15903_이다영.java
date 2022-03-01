package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_카드합체놀이_15903 {
	static int N, M;
	static BigInteger ans;
	static long[] src;
	static long[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		src = new long[N];
		
		
		for (int i = 0; i < N; i++) {
			src[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			Arrays.sort(src);
			sum();
		}
		
		ans = BigInteger.valueOf(0);
		
		for (int i = 0; i < N; i++) {
			ans = ans.add(BigInteger.valueOf(src[i]));
		}
		System.out.println(ans);

	}
	static void sum() {
		long sum = src[0] + src[1];
		src[0] = sum;
		src[1] = sum;
	}
}
