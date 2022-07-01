package study_0627;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BJ_2733_조현빈 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		continuePoint: for (int t = 1; t <= T; t++) {
			bw.write(String.format("PROGRAM #%d:\n", t));

			StringBuilder sb = new StringBuilder();

			while (true) {
				String str = br.readLine();
				if (str.equals("end")) {
					break;
				}
				str.replaceAll(" ", "");

				if (str.contains("%")) {
					str = str.substring(0, str.indexOf("%"));
				}

				sb.append(str);
			}

			Stack<Integer> stack = new Stack<>();
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == '[') {
					stack.add(i);
				} else if (sb.charAt(i) == ']') {
					if (stack.size() == 0) {
						bw.write("COMPILE ERROR\n");
						continue continuePoint;
					}
					int index = stack.pop();
					map.put(i, index);
					map.put(index, i);
				}
			}

			if (!stack.isEmpty()) {
				bw.write("COMPILE ERROR\n");
				continue;
			}

			char[] arr = new char[32768];
			int pointer = 0;

			for (int i = 0; i < sb.length(); i++) {
				char chr = sb.charAt(i);

				if (chr == '>') {
					pointer = pointer == 32767 ? 0 : pointer + 1;
				} else if (chr == '<') {
					pointer = pointer == 0 ? 23767 : pointer - 1;
				} else if (chr == '+') {
					arr[pointer] = arr[pointer] == 255 ? 0 : (char) (arr[pointer] + 1);
				} else if (chr == '-') {
					arr[pointer] = arr[pointer] == 0 ? 255 : (char) (arr[pointer] - 1);
				} else if (chr == '.') {
					bw.write(String.format("%c", arr[pointer]));
				} else if (chr == '[') {
					i = arr[pointer] == 0 ? map.get(i) : i;
				} else if (chr == ']') {
					i = arr[pointer] != 0 ? map.get(i) - 1 : i;
				}
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
