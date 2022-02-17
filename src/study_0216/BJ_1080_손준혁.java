package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1080_손준혁 {
	static int N,M,count = 0;
	static int[][] A,B;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		if(N < 3 || M < 3) { 주석 안하고 15번 에러 발생 후 주석 처리 이후 정상작동 확인했습니다.
//			System.out.println(-1);
//			return;
//		}
		A = new int[N][M];
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = tmp.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = tmp.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if(A[i][j] == B[i][j]) continue;
				reverse(j, i);
				count++;
			}
			
		}
		if(checkFun()) System.out.println(count);
		else System.out.println(-1);
	}
	static void reverse(int x, int y) {
		for (int i = y; i < y+3; i++) {
			for (int j = x; j < x+3; j++) {
				A[i][j] = 1 - A[i][j];
			}
		}
	}

	static boolean checkFun() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A[i][j] != B[i][j]) return false;
			}
		}
		return true;
	}

}

