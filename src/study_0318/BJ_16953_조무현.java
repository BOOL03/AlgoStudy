package study_0318;

import java.util.Scanner;

public class BJ_16953_조무현 {
	static String A, B;
	static boolean valid = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.next();
		B = sc.next();
		StringBuilder sb = new StringBuilder(A);
		dfs(0, sb);
		if(!valid) System.out.println(-1);
		
	}
	
	public static void dfs(int cnt, StringBuilder sb) {
		// 초과했으면 안되는 케이스
		if(Long.parseLong(sb.toString()) > Long.parseLong(B)) return;
		// 종료 조건
		if(sb.toString().equals(B)) {
			System.out.println(cnt + 1);
			valid = true;
			return;
		}
		
		
		StringBuilder in_str = new StringBuilder(sb.toString());
		// 뒤에 1을 추가하는 거 먼저
		in_str.append(1);
		dfs(cnt + 1, in_str);
		
		// 2를 곱한다.
		long tmp = Long.parseLong(sb.toString()) * 2;
		in_str = new StringBuilder(Long.toString(tmp));
		dfs(cnt + 1, in_str);
	}

}
