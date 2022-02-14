package study_0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11723_조현빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  = null;
		boolean[]       arr = new boolean[21];
		int             M   = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "add":
					arr[Integer.parseInt(st.nextToken())] = true;
					break;
				case "check":
					bw.write(arr[Integer.parseInt(st.nextToken())] ? 1 + "\n" : 0 + "\n");
					break;
				case "remove":
					arr[Integer.parseInt(st.nextToken())] = false;
					break;
				case "empty":
					for (int j = 0; j < 21; j++) {
						arr[j] = false;
					}
					break;
				case "all":
					for (int j = 0; j < 21; j++) {
						arr[j] = true;
					}
					break;
				case "toggle":
					int n = Integer.parseInt(st.nextToken());
					if (arr[n]) {
						arr[n] = false;
					} else {
						arr[n] = true;
					}

			}
		}
		bw.flush();
	}
}
