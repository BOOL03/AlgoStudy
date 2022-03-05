package study_0304;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int            T  = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int             N  = Integer.parseInt(st.nextToken());
			int             M  = Integer.parseInt(st.nextToken());
			Queue<Integer>  q  = new LinkedList<Integer>();

			st = new StringTokenizer(br.readLine());
			int   originPrioirty = -1;
			int[] priority       = new int[10];

			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				priority[num]++;
				if (i != M) {
					q.offer(num);
				} else {
					originPrioirty = num;
					q.offer(-1);
				}
			}
			int cnt = 0;
			while (true) {
				int     num   = q.poll();
				boolean flag  = true;
				int     index = num == -1 ? originPrioirty : num;
				for (int i = index + 1; i < 10; i++) {
					if (priority[i] != 0) {
						flag = false;
						q.offer(num);
						break;
					}
				}

				if (!flag) continue;
				else {
					if (num == -1) {
						bw.write(String.format("%d\n", cnt + 1));
						break;
					} else {
						cnt++;
						priority[num]--;
					}
				}
			}
		}
		bw.flush();
	}
}
