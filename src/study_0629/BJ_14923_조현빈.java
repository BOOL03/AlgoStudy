package study_0629;

import java.io.*;
import java.util.*;

public class BJ_14923_조현빈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // Y 축
		int M = Integer.parseInt(st.nextToken()); // X 축

		int[][] maze = new int[N][M];

		st = new StringTokenizer(br.readLine());

		int Hy = Integer.parseInt(st.nextToken()) - 1; // 시작 Y
		int Hx = Integer.parseInt(st.nextToken()) - 1; // 시작 X

		st = new StringTokenizer(br.readLine());

		int Ey = Integer.parseInt(st.nextToken()) - 1; // 끝 Y
		int Ex = Integer.parseInt(st.nextToken()) - 1; // 끝 X

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visit = new boolean[N][M][2]; // 지팡이 안쓴 경우, 쓴 경우
		visit[Hy][Hx][0] = true;
		visit[Hy][Hx][1] = true;

		Queue<int[]> q = new LinkedList<>(); // new int[] {y, x, use, count}
		q.offer(new int[] { Hy, Hx, 0, 0 });

		int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
		boolean flag = false;

		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int use = q.peek()[2];
			int count = q.poll()[3];

			if (y == Ey && x == Ex) {
				System.out.println(count);
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				// 범위 체크
				if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
					continue;
				}

				// 지팡이를 아직 사용 안했을 때
				if (use == 0) {
					// 다음칸이 벽이 아닐때
					if (maze[ny][nx] == 0) {
						if (visit[ny][nx][0]) {
							continue;
						}

						visit[ny][nx][0] = true;

						q.offer(new int[] { ny, nx, 0, count + 1 });
					}
					// 다음칸이 벽일때
					else {
						if (visit[ny][nx][1]) {
							continue;
						}

						visit[ny][nx][1] = true;
						q.offer(new int[] { ny, nx, 1, count + 1 });
					}
				}

				// 지팡이 이미 사용 했을 때
				else {
					if (maze[ny][nx] == 1) {
						continue;
					}

					if (visit[ny][nx][1]) {
						continue;
					}

					visit[ny][nx][1] = true;
					q.offer(new int[] { ny, nx, 1, count + 1 });
				}
			}
		}

		if (!flag) {
			System.out.println(-1);
		}
	}
}
