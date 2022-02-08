package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
// 테스트
public class BJ_11899_조무현 {
	
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if(stack.isEmpty()) {
				stack.push(input[i]);
				continue;
			}
			
			char prev = stack.peek();
			if(prev == '(' && input[i] == ')') {
				stack.pop();
				continue;
			}
			stack.push(input[i]);
		}
		System.out.println(stack.size());
	}

}
