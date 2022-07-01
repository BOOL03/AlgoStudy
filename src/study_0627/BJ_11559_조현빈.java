package study_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_11559_조현빈 {
	static char[][] arr = new char[12][6];
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int count = 0;
		while (true) {
			if (bfs()) {
				count++;
				blockDown();
			} else {
				break;
			}
		}
		System.out.println(count);
	}

	static void blockDown() {
		char[][] newArr = new char[12][6];

		for (int i = 0; i < 12; i++) {
			Arrays.fill(newArr[i], '.');
		}

		for (int i = 0; i < 6; i++) {
			int index = 11;
			for (int j = 11; j > -1; j--) {
				if (arr[j][i] != '.') {
					newArr[index][i] = arr[j][i];
					index--;
				}
			}
		}

		arr = newArr;
	}

	static boolean bfs() {
		boolean result = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] == '.')
					continue;

				char cur = arr[i][j];

				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] { i, j });

				boolean[][] visit = new boolean[12][6];
				visit[i][j] = true;

				List<int[]> list = new ArrayList<>();
				list.add(new int[] { i, j });

				int count = 1;

				while (!q.isEmpty()) {
					int y = q.peek()[0];
					int x = q.poll()[1];

					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];

						if (ny < 0 || nx < 0 || ny > 11 || nx > 5)
							continue;

						if (visit[ny][nx])
							continue;

						if (arr[ny][nx] != cur)
							continue;

						visit[ny][nx] = true;
						q.offer(new int[] { ny, nx });
						count++;
						list.add(new int[] { ny, nx });
					}
				}

				if (count >= 4) {
					for (int k = 0; k < list.size(); k++) {
						int y = list.get(k)[0];
						int x = list.get(k)[1];

						arr[y][x] = '.';
					}
					result = true;
				}
			}
		}
		return result;
	}
}
