package study_0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020_이다영 {

	static int N, H;
	static int[] up, down;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		up = new int[H + 1];
		down = new int[H + 1];

		for (int i = 0; i < N / 2; i++) {
			up[Integer.parseInt(br.readLine())]++;
			down[Integer.parseInt(br.readLine())]++;
		}

		for (int i = H - 1; i > 0; i--) {
			up[i] += up[i + 1];
			down[i] += down[i + 1];
		}

		int[] total = new int[H + 1];
		int min = N + 1;

		for (int i = 1; i <= H; i++) {
			total[i] = up[i] + down[H - i + 1];
			min = Math.min(min, total[i]);
		}
		
		for (int i = 1; i <= H; i++) {
			if (total[i] == min)
				cnt++;
		}
		
		System.out.println(min + " " + cnt);
	}
}
