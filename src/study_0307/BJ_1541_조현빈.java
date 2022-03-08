package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1541_조현빈 {
	public static void main(String[] args) throws Exception {
		String             str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		StringTokenizer    st  = new StringTokenizer(str, "+-", true);
		ArrayList<Integer> al  = new ArrayList<Integer>();

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			// 마지막 숫자면 리스트에 넣고 브레이크
			if (!st.hasMoreTokens()) {
				al.add(num);
				break;
			}
			char oper = st.nextToken().charAt(0);
			// 뺄셈이면 숫자를 바로 넣고
			if (oper == '-') al.add(num);
			// 덧셈만 먼저 더해줌
			else {
				while (true) {
					num += Integer.parseInt(st.nextToken());
					// 마지막 숫자면 리스트에 넣고 브레이크
					if (!st.hasMoreTokens()) {
						al.add(num);
						break;
					}
					char nextOper = st.nextToken().charAt(0);
					// 다음 연산자가 뺄셈이면 브레이크
					if (nextOper == '-') {
						al.add(num);
						break;
					}
				}
			}
		}

		// 개같이 뺄셈
		int result = al.get(0);
		for (int i = 1; i < al.size(); i++) {
			result -= al.get(i);
		}

		System.out.println(result);
	}
}
