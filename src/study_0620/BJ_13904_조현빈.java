package study_0620;

import java.io.*;
import java.util.*;

public class BJ_13904_조현빈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2[1], e1[1]));

        int N = Integer.parseInt(br.readLine());
        int lastDeadLine = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            if (deadLine > lastDeadLine) {
                lastDeadLine = deadLine;
            }

            pq.offer(new int[] { deadLine, score });
        }

        int[] scores = new int[lastDeadLine + 1];

        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            for (int i = task[0]; i > 0; i--) {
                if (scores[i] == 0) {
                    scores[i] = task[1];
                    break;
                }
            }
        }

        int maxScore = 0;
        for (int i = 1; i < lastDeadLine + 1; i++) {
            maxScore += scores[i];
        }

        System.out.println(maxScore);
    }
}
