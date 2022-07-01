package study_0613;

import java.io.*;
import java.util.*;

public class BJ_12731_조현빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int NA = Integer.parseInt(st.nextToken());
			int NB = Integer.parseInt(st.nextToken());

			ArrayList<int[]> train = new ArrayList<>();

			for (int na = 0; na < NA; na++) {
				String[] str = br.readLine().split(" |:");
				int depart = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
				int arrive = Integer.parseInt(str[2]) * 60 + Integer.parseInt(str[3]);
				train.add(new int[] { depart, arrive, 0 });
			}

			for (int nb = 0; nb < NB; nb++) {
				String[] str = br.readLine().split(" |:");
				int depart = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
				int arrive = Integer.parseInt(str[2]) * 60 + Integer.parseInt(str[3]);
				train.add(new int[] { depart, arrive, 1 });
			}

			Collections.sort(train, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);

			PriorityQueue<Integer> stationA = new PriorityQueue<>((e1, e2) -> e1 - e2);
			PriorityQueue<Integer> stationB = new PriorityQueue<>((e1, e2) -> e1 - e2);

			stationA.offer(100000);
			stationB.offer(100000);

			int a = 0;
			int b = 0;

			for (int i = 0; i < NA + NB; i++) {
				int[] trainInfo = train.get(i);

				switch (trainInfo[2]) {
					case 0:
						if (stationA.peek() <= trainInfo[0])
							stationA.poll();
						else
							a++;

						stationB.offer(trainInfo[1] + T);
						break;
					case 1:
						if (stationB.peek() <= trainInfo[0])
							stationB.poll();
						else
							b++;

						stationA.offer(trainInfo[1] + T);
						break;
				}
			}
			bw.write(String.format("Case #%d: %d %d\n", n + 1, a, b));
		}
		bw.flush();
	}
}