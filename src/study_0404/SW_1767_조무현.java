package study_0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1767_조무현 {
	static int T, N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max_core_cnt = 0;
	static int min_wire_len = Integer.MAX_VALUE;
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			// core들의 위치 저장
			ArrayList<Node> core = new ArrayList<Node>();
			// 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n == 1) {
						core.add(new Node(i, j));
					}
					map[i][j] = n;
				}
			}
			
			dfs(map, 0, 0, core.size(), core, 0);
			if(max_core_cnt == 0) min_wire_len = 0;
			System.out.println("#" + t + " " + min_wire_len);
			min_wire_len = Integer.MAX_VALUE;
			max_core_cnt = 0;
		}
		
	}
	
	static void dfs(int[][] map, int idx, int sum, int limit, ArrayList<Node> core, int core_cnt) {
		if(limit - idx < max_core_cnt - core_cnt) return;
		if(idx == limit) {
			// 종료조건
			// core의 수와 사용된 전선의 길이를 비교해서 최저값 갱신
			if(core_cnt > max_core_cnt) {
				max_core_cnt = core_cnt;
				min_wire_len = sum;
			}else if(core_cnt == max_core_cnt && sum < min_wire_len) {
				min_wire_len = sum;
			}
			return;
		}
		//복사한 배열로 처리해주고 dfs호출
		Node node = core.get(idx);
		
		// 가장 자리에 위치한 core라면 dfs호출
		if(node.r == 0 || node.c == 0 || node.r == N-1 || node.c == N-1) {
			dfs(map, idx+1, sum, limit, core, core_cnt + 1);
		}
		
		for (int d = 0; d < 4; d++) {
			int len = 0;
			int nr = node.r;
			int nc = node.c;
			boolean valid = true;
			while(len < N-1) {
				nr += dr[d];
				nc += dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
				if(map[nr][nc] == 1) {
					valid = false;
					break;
				}else {
					len++;					
				}
			}
			
			if(valid) {
				nr = node.r;
				nc = node.c;
				int[][] tmp_map = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						tmp_map[i][j] = map[i][j];
					}
				}
				while(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					tmp_map[nr][nc] = 1;
					nr += dr[d];
					nc += dc[d];
				}
				dfs(tmp_map, idx+1, sum + len, limit, core, core_cnt + 1);
			}else {
				dfs(map, idx+1, sum, limit, core, core_cnt);
			}
		}
		
	}

}
