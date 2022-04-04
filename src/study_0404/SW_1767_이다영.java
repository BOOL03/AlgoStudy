package study_0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767_이다영 {
	
	static int T, N;
	static int[][] map;
	static int[] ans;
	
	static List<int[]> core;
	
	static int[] dy = { -1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			ans = new int[2];
			ans[0] = 0; // 연결된 core 수
			ans[1] = 0; // 연결된 선의 합
			
			core = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) core.add(new int[] {i, j});
				}
			}
			
			connect(0, 0, 0, map);
			sb.append("#" + t + " " + ans[1] + "\n");
		}
		System.out.println(sb);
	}
	
	static int[][] copyMap (int[][] original){
		int[][] copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = original[i][j];
			}
		}
		
		return copy;
	}
	
	static boolean connect (int idx, int cnt, int sum, int[][] cell) {
		if (idx == core.size()) {
			// complete code (core수, sum)
			if (ans[0] < cnt) { //core수가 더 많다면
				ans[0] = cnt;
				ans[1] = sum;
			}else if(ans[0] == cnt){ // core 수가 같다면
				ans[1] = Math.min(ans[1], sum); // 연결된 선의 합이 더 적은 것으로
			}
			
			return true;
		}
		
		if (ans[0] >= cnt + (core.size() - idx) && ans[1] < sum) return false;
		
		int y = core.get(idx)[0];
		int x = core.get(idx)[1];
		
		if (y == 0 || x == 0 || y == N-1 || x == N-1) { //core 가  가장 자리에 있다면
			cell[y][x] = 3; //연결된 core 로 바꿈
			connect(idx + 1, cnt + 1, sum, cell);
			return true;
		}
		
		for (int d = 0; d < 4; d++) {
			boolean chk = false;
			int [][] tmp = copyMap(cell);
			
			int ny = y;
			int nx = x;
			
			while(true) {
				ny += dy[d];
				nx += dx[d];
				
				if(tmp[ny][nx] == 1 || tmp[ny][nx] == 2 || tmp[ny][nx] == 3) break; // 이미 연결된 방향이라면
				
				if(ny == 0 || nx == 0 || ny == N-1 || nx == N-1) { //제대로 연결되었다면 (가장 자리 까지 왔다면)
					tmp[ny][nx] = 2; // 선연결
					chk = true;
					break;
				}

				tmp[ny][nx] = 2; // 선 연결
			}
			
			if (chk) {
				tmp[y][x] = 3;
				connect(idx + 1, cnt + 1, sum + Math.abs(ny-y) + Math.abs(nx-x), tmp);
			}	
		}
		connect(idx + 1, cnt, sum, cell);
		return true;
	}
}
