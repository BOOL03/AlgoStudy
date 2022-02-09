package study_0209;

import java.util.Scanner;

public class BJ_9663_조현빈 {
	static boolean[] location = null;
	static int       N        = 0;
	static int[][]   board    = null;
	static int       cnt      = 0;
	static int[]     dx       =
		{
				-1, 0, 1
		};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N        = sc.nextInt();
		location = new boolean[N];
		board    = new int[N][N];

		sc.close();
		for (int i = 0; i < N; i++) {
			board[0][i] = 1;
			location[i] = true;
			count(1, 0);
			location[i] = false;
			board[0][i] = 0;
		}

		System.out.println(cnt);
	}

	static void count(int i, int depth) {
		if (depth == N - 1) {
			cnt++;
		}

		for (int j = 0; j < N; j++) {

			if (location[j]) {
				continue;
			}
			boolean flag = true;
			breakPoint: for (int k = 0; k < 3; k++) {
				int tmpI = i;
				int tmpJ = j;
				while (true) {
					try {
						if (board[tmpI - 1][tmpJ + dx[k]] == 1) {
							flag = false;
							break breakPoint;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						break;
					}
					tmpJ += dx[k];
					tmpI--;
				}
			}
			if (flag) {
				location[j] = true;
				board[i][j] = 1;
				count(i + 1, depth + 1);
				board[i][j] = 0;
				location[j] = false;
			}
		}
	}

}
