package study_0401;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2023_이다영 {
	static int N;
	static int num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = (int) Math.pow(10, N) -1;
		int start = (int) Math.pow(10, (N-1));
		
		
		for (int i = start; i <= num; i++) {
			boolean chk = true;
			for (int j = i ; j > 0; j/=10) {
				if(! isPrime(j)) {
					chk=false;
					break;
				}
			}
			if(chk) System.out.println(i);
		}
		
		
	}
	public static boolean isPrime(int num) {
		for(int i=2; i*i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
	
}
