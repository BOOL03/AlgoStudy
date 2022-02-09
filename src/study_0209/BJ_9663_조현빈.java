package study_0209;

import java.util.Scanner;

public class BJ_9663_조현빈 {
	static int       N        = 0;                       // 입력 변수
	static boolean[] location = null;                    // 각 행에 퀸이 있는지 체크
	static int[][]   board    = null;                    // 체스판 배열
	static int       cnt      = 0;                       // 카운트 변수

	static int[]     dx       =                          // 델타변수. 위에서 아래로 퀸을 놓는다하면
		{                                                  // 좌상, 상, 우상 세곳만 확인하면 됨.
				-1, 0, 1                                       // y는 결국 -1만 해주면 되기때문에 따로 필요없음
		};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N        = sc.nextInt();
		location = new boolean[N];
		board    = new int[N][N];

		sc.close();
		for (int i = 0; i < N; i++) {
			board[0][i] = 1;    // 첫번째 행의 각 열마다 퀸을 하나씩 놓고,
			location[i] = true; // location에 표시함

			count(1, 0); // 그리고 재귀문을 두번째 행부터 돌림

			location[i] = false; // location 다시 해제 시켜줌
			board[0][i] = 0;     // 퀸을 치움
		}

		System.out.println(cnt);
	}

	static void count(int i, int depth) {
		if (depth == N - 1) {
			// 재귀의 깊이가 N - 1 이면 퀸을 전부 놓은것
			cnt++;
		}

		for (int j = 0; j < N; j++) {

			if (location[j]) {
				// 이 열에 퀸이 하나라도 놓여있으면
				// 그 밑에는 놓을수 없으므로 다음 루프로 넘어감
				continue;
			}

			boolean flag = true; // 퀸을 놓을수 있는지 없는지 체크하는 변수

			breakPoint: for (int k = 0; k < 3; k++) {
				int tmpI = i; // 현재 i
				int tmpJ = j; // 현재 j
				while (true) {
					// try, catch로 인덱스 범위 체크
					try {
						if (board[tmpI - 1][tmpJ + dx[k]] == 1) {
							// 좌상, 상, 우상 중에 퀸이 하나라도 놓여있으면 퀸 못놓으니까
							// flag = false로 바꿔주고 바로 바깥 for문 탈출
							flag = false;
							break breakPoint;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						// 인덱스 범위 넘어가면 while문 종료
						break;
					}
					// 다음 인덱스로 갱신
					tmpJ += dx[k];
					tmpI--;
				}
			}
			if (flag) {
				// 퀸을 놓을수 있으면
				// location 체크해주고 보드에 퀸 놓고
				// 다음 행으로 ㄱㄱ
				location[j] = true;
				board[i][j] = 1;
				count(i + 1, depth + 1);
				board[i][j] = 0;
				location[j] = false;
			}
		}
	}

}
