package study_0719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1461_손준혁 {

	private static PriorityQueue<Integer> positiveQ = new PriorityQueue<>((p1, p2) -> p2 - p1);;
	private static PriorityQueue<Integer> negativeQ = new PriorityQueue<>((p1, p2) -> p2 - p1);;
	
	private static int ans = 0;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > 0) {
                positiveQ.offer(temp);
            } else {
                negativeQ.offer(Math.abs(temp));
            }
        }

        int max = 0;
        if (positiveQ.isEmpty()) {
            max = negativeQ.peek();
        } else if (negativeQ.isEmpty()) {
            max = positiveQ.peek();
        } else {
            max = Math.max(positiveQ.peek(), negativeQ.peek());
        }

        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();
            for (int i = 0; i < M - 1; i++) {
                positiveQ.poll();

                if (positiveQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }
        
        while (!negativeQ.isEmpty()) {
            int temp = negativeQ.poll();
            for (int i = 0; i < M - 1; i++) {
                negativeQ.poll();

                if (negativeQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }

        ans -= max;
        System.out.println(ans);
    }
}