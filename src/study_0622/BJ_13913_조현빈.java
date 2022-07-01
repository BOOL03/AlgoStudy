package study_0622;

import java.io.*;
import java.util.*;

public class BJ_13913_조현빈 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean bArr[] = new boolean[100001];
		int iArr[] = new int[100001];
		List<Integer> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bArr[N] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N, 0 });

		while (!q.isEmpty()) {
			int[] curN = q.poll();

			if (curN[0] == K) {
				int curLocation = curN[0];
				bw.write(String.format("%d\n", curN[1]));

				while (curLocation != N) {
					list.add(curLocation);
					curLocation = iArr[curLocation];
				}
				list.add(N);

				for (int i = list.size() - 1; i > -1; i--) {
					bw.write(String.format("%d ", list.get(i)));
				}
				bw.flush();

				break;
			}

			int nextN1 = curN[0] + 1;
			int nextN2 = curN[0] - 1;
			int nextN3 = curN[0] * 2;

			if (nextN1 < 100001 && !bArr[nextN1]) {
				q.offer(new int[] { nextN1, curN[1] + 1 });
				bArr[nextN1] = true;
				iArr[nextN1] = curN[0];
			}
			if (nextN2 > -1 && !bArr[nextN2]) {
				q.offer(new int[] { nextN2, curN[1] + 1 });
				bArr[nextN2] = true;
				iArr[nextN2] = curN[0];
			}
			if (nextN3 < 100001 && !bArr[nextN3]) {
				q.offer(new int[] { nextN3, curN[1] + 1 });
				bArr[nextN3] = true;
				iArr[nextN3] = curN[0];
			}
		}
	}
}
