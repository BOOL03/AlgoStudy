package study_0218;

import java.util.Scanner;

public class BJ_15649_조무현 {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] tgt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		tgt = new int[M];
		boolean[] select = new boolean[N];
		perm(0, select);
		System.out.println(sb.toString());
	}

	private static void perm(int tgtIdx, boolean[] select) {
		// 기저조건
		if(tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = i+1;
			select[i] = true;
			perm(tgtIdx + 1, select);
			select[i] = false;
		}
		
		
		
	}

	
}
