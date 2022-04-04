package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_이다영 {
	static int N, M;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{ //순열이었는데 중복 ? 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		select = new boolean[N];
		
		for (int i = 1; i <= N; i++) {
			src[i-1] = i;
		}
		
		comb(0, 0);
		System.out.println(sb);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == M) {
			//complete code
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(srcIdx == N) return;
		
		for (int i = srcIdx; i < N; i++) {
			if(select[i]) continue;
			select[i] = true;  
			tgt[tgtIdx] = src[i];
			comb(srcIdx+1, tgtIdx + 1);
			select[i] = false;
		}
	}
}
