package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_손준혁 {
	static boolean[] visited;
	static int[] selected;
	
	static int N,M;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		selected = new int[M];
		
		perm(0);
		
	}
	static void perm(int dp) {
		if(dp == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[dp] = i+1;
			perm(dp+1);
			visited[i] = false;
		}
	}
}
