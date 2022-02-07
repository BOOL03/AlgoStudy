package study_0207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_조현빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader   br      = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter   bw      = new BufferedWriter(new OutputStreamWriter(System.out));

		int              N       = Integer.parseInt(br.readLine());
		int[]            receive = new int[N];

		StringTokenizer  st      = new StringTokenizer(br.readLine());

		Stack<Integer[]> stk1    = new Stack<>();
		Stack<Integer[]> stk2    = new Stack<>();

		for (int i = 0; i < N; i++) {
			stk1.push(new Integer[]
				{
						Integer.parseInt(st.nextToken()), i
				});
		}

		while (!stk1.isEmpty()) {
			stk2.push(stk1.pop());
			if (stk1.isEmpty()) {
				break;
			}
			while (true) {
				if (stk2.peek()[0] > stk1.peek()[0]) {
					break;
				} else {
					receive[stk2.peek()[1]] = stk1.peek()[1] + 1;
					stk2.pop();
					if (stk2.isEmpty()) {
						break;
					}
				}
			}
		}

		for (int elem : receive) {
			bw.write(elem + " ");
		}
		bw.flush();
	}
}
