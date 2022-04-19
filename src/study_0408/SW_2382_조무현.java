package study_0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2382_조무현 {
	static int T, N, M, K;
	static long ans = 0;
	static Node[][] map;

	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	
	static class Node{
		int cnt;
		int dir;
		int sum=0;
		public Node() {};
		public Node(int cnt, int dir) {
			this.cnt = cnt;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Node[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new Node(0, 0);
				}
			}
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[r][c] = new Node(cnt, dir);
				
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print("( " + map[i][j].cnt +" , " + map[i][j].dir + " )");
				}
				System.out.println();
			}
			System.out.println();
			ans = 0;
			move(0);
			System.out.println("#" + t + " " +ans);

		}
			
	}
	
	// M시간만큼 이동
	static void move(int m) {
		if(m == M) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j].cnt + " ");
					ans += map[i][j].cnt;
				}
			}
			return;
		}
		Node[][] copyMap = new Node[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = new Node(0, 0);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].cnt == 0) continue;
				Node cur = map[i][j];
				int nr = i + dr[cur.dir];
				int nc = j + dc[cur.dir];
				if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if(nr == 0 || nc == 0 || nr == N-1 || nc == N-1) { // 경계지점
						// 미생물 반
						copyMap[nr][nc].cnt = cur.cnt / 2;
						copyMap[nr][nc].sum = cur.cnt / 2;
						// 방향 전환
						if(cur.dir == 1 || cur.dir == 2) copyMap[nr][nc].dir = 3 - cur.dir;
						else if(cur.dir == 3 || cur.dir == 4) copyMap[nr][nc].dir = 7 - cur.dir;
						
					}else {
						if(cur.cnt > copyMap[nr][nc].cnt) {
							copyMap[nr][nc].dir = cur.dir;
							copyMap[nr][nc].cnt = cur.cnt;
						}else {
							copyMap[nr][nc].cnt = cur.cnt;							
						}
						copyMap[nr][nc].sum += cur.cnt;
					}
				}
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].cnt = copyMap[i][j].sum;
				map[i][j].dir = copyMap[i][j].dir;
				map[i][j].sum = copyMap[i][j].sum;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("( " + map[i][j].cnt +" , " + map[i][j].dir + " )");
			}
			System.out.println();
		}
		System.out.println();
		move(m + 1);

	}
	

}
