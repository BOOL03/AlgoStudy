package study_0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_15649_조현빈 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());
		int[]           arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		bw = dfs(arr, bw, N, M, 0, new int[M], 0);
		bw.flush();
	}

	static BufferedWriter dfs(int[] arr, BufferedWriter bw, int N, int M, int depth, int[] comb,
			int bit) throws Exception {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				bw.write(comb[i] + " ");
			}
			bw.write("\n");
			return bw;
		}
		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) != 0) continue;
			comb[depth] = arr[i];
			bw          = dfs(arr, bw, N, M, depth + 1, comb, bit | 1 << i);
		}
		return bw;
	}
}
