package study_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_11899_조현빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader   br   = new BufferedReader(new InputStreamReader(System.in));

		String           str  = br.readLine();
		Stack<Character> stk1 = new Stack<>();
		Stack<Character> stk2 = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stk1.push(str.charAt(i));
		}

		while (true) {
			if (stk1.isEmpty()) {
				break;
			}
			stk2.push(stk1.pop());
			while (true) {
				if (stk2.isEmpty() || stk1.isEmpty()) {
					break;
				}
				if (stk1.peek() == '(' && stk2.peek() == ')') {
					stk1.pop();
					stk2.pop();
				} else {
					break;
				}
			}
		}
		System.out.println(stk1.size() + stk2.size());
	}
}
