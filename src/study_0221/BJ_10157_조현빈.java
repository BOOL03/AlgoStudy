package study_0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_조현빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             C   = Integer.parseInt(st.nextToken());
		int             R   = Integer.parseInt(st.nextToken());
		int[][]         arr = new int[C + 1][R + 1];
		int             K   = Integer.parseInt(br.readLine());

		if (K > C * R) {
			System.out.println(0);
			return;
		}

		int   index = 0;
		int[] dy    =
			{
					0, 1, 0, -1
			};
		int[] dx    =
			{
					1, 0, -1, 0
			};
		int   x     = 1;
		int   y     = 1;
		int   count = 1;

		while (true) {
			if (count == K) {
				System.out.println(y + " " + x);
				break;
			}
			arr[y][x] = count++;
			int nx = x + dx[index];
			int ny = y + dy[index];

			if (nx < 1 || ny < 1 || nx > R || ny > C || arr[ny][nx] != 0) {
				index++;
				if (index == 4) index = 0;
				x = x + dx[index];
				y = y + dy[index];
				continue;
			}

			x = nx;
			y = ny;
		}
	}

}
