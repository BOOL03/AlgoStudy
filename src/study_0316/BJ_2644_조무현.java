package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2644_조무현 {
	static int n, N;
	static int a, b;
	static int[][] parents;
	static boolean[] visited;
	static boolean valid;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		parents = new int[n+1][n+1];
		visited = new boolean[n+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			parents[y][x] = 1;
			parents[x][y] = 1;
		}
		//System.out.println(Arrays.toString(parents));
		
		// 부모와 자식인지 확인

		visited[a] = true;
		dfs(a,b, 0);
		if(!valid) {
			System.out.println(-1);
		}
	}
	
	static void dfs(int cur, int target, int cnt){
		visited[cur] = true;
		if(cur == target) {
			valid = true;
			System.out.println(cnt);
			return;
		}
		
		// 부모나 자식이 있으면 탐색
		for (int i = 1; i < parents.length; i++) {
			if(parents[cur][i] == 1 && !visited[i]) {
				dfs(i, target, cnt + 1);
			}
		}
		
		
	}
	
	

}
