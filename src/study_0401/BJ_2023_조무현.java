package study_0401;

import java.util.Scanner;


public class BJ_2023_조무현 {
	static int N;
	static String[] front = {"2", "3", "5", "7"};
	static String[] rest = {"1", "3", "7", "9"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		find("", 0);
	}
	
	static void find(String s, int n) {
		if(n == N) {
			System.out.println(s);
			return;
		}
		
		if(n == 0) {
			for (int i = 0; i < 4; i++) {
				find(front[i], n+1);
			}
		}else if(n >= 1) {
			for (int i = 0; i < 4; i++) {
				String tmp =  s + rest[i];
				int tmp_int = Integer.parseInt(tmp);
				if(check(tmp_int)) {
					find(tmp, n+1);
				}
			}
		}
	}
	
	static boolean check(int x) {
		for (int i = 2; i <= Math.round(Math.pow(x, 0.5)); i++) {
			if(x % i == 0) return false;
		}
		return true;
	}
	
}
