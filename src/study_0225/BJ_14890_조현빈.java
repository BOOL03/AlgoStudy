package study_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14890_조현빈 {
	public static void main(String[] args) throws Exception {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             N   = Integer.parseInt(st.nextToken());
		int             L   = Integer.parseInt(st.nextToken());
		int[][]         map = new int[N][N];
		int[]           way = new int[N];
		int             cnt = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				way[j] = map[i][j];
			}
			cnt += check(way, L);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				way[j] = map[j][i];
			}
			cnt += check(way, L);
		}

		System.out.println(cnt);
	}

	static int check(int[] way, int L) {
		int       N    = way.length;
		int       prev = way[0];
		boolean[] hill = new boolean[N]; // 경사로 설치를 알기위한 boolean 배열

		for (int i = 1; i < N; i++) {
			int gap    = way[i] - prev; // 이전이랑 높이차이를 계산한 변수
			int absGap = Math.abs(gap); // 절대값

			if (absGap > 1) {
				// 높이차이가 1이상 나면 길을 못만드니까 바로 0을 리턴
				return 0;
			} else if (absGap == 1) {
				// 높이 차이가 1일때
				if (gap == -1) {
					// 높이가 낮아졌을때
					// 현재위치에서 L만큼 앞으로 가면서
					// 내리막을 설치할 수 있는지 체크

					int downHill = 0;      // 카운트 변수
					int current  = way[i]; // 현재 위치의 높이

					// 경사로 길이가 L 이니까 i + L 까지만 체크하면 됨

					if (i + L > N) {
						// 근데 i + L 이 N보다 커버리면 경사로 절대 못만듬
						return 0;
					}

					for (int j = i; j < i + L; j++) {
						if (way[j] == current) {
							downHill++;
						}
					}

					if (downHill == L) {
						// 경사로 설치가 가능하면
						// 높이가 변한 위치에 경사로가 있다는 것을 표시
						for (int j = i; j < i + L; j++) {
							if (hill[j]) {
								// 경사로 설치하려하는데 이미 경사로가 있으면 얜 안됨.
								// 바로 리턴 0
								return 0;
							}
							hill[j] = true;
						}
					} else {
						// 길이가 안되면 바로 return
						return 0;
					}

				} else {
					// 높이가 높아졌을때
					// 현재위치에서 L만큼 뒤로 가면서
					// 오르막을 설치할 수 있는지 체크

					int upHill  = 0;          // 카운트 변수
					int current = way[i - 1]; // 현재 위치의 높이

					// 위치가 바뀐걸 감지한게 i번째 인덱스니까 i - 1부터 검사를 해야함
					// 경사로 길이가 L 이니까 i - 1 - L 까지만 체크하면 됨

					if (i - 1 - L < -1) {
						// 근데 i - 1 - L이 -1보다 작으면 경사로 절대 못만듬
						return 0;
					}

					for (int j = i - 1; j > i - 1 - L; j--) {
						if (way[j] == current) {
							upHill++;
						}
					}

					if (upHill == L) {
						// 경사로 설치가 가능하면
						// 높이가 변한 위치에 경사로가 있다는 것을 표시
						for (int j = i - 1; j > i - 1 - L; j--) {
							if (hill[j]) {
								// 경사로 설치하려하는데 이미 경사로가 있으면 얜 안됨.
								// 바로 리턴 0
								return 0;
							}
							hill[j] = true;
						}
					} else {
						// 길이가 안되면 바로 return
						return 0;
					}
				}
			}
			prev = way[i];
		}

		// 길 다만들고 체크해보기
		// 옳은 길이면 리턴 1 아니면 0
		return isCorrectWay(hill, way) ? 1 : 0;
	}

	static boolean isCorrectWay(boolean[] hill, int[] way) {
		int N    = way.length;
		int prev = way[0];

		for (int i = 1; i < N; i++) {
			int gap    = way[i] - prev;
			int absGap = Math.abs(gap);
			if (absGap == 1) {
				if (gap == 1) {
					// 높이가 높아질때 이전에 오르막이 없으면 길이 없는거임
					if (!hill[i - 1]) {
						return false;
					}
				} else {
					// 높아기 낮아질때 다음에 내리막이 없으면 길이 없는거임
					if (!hill[i]) {
						return false;
					}
				}
			}
			prev = way[i];
		}
		return true;
	}
}
