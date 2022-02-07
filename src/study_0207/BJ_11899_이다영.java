package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_괄호끼워넣기_11899 {
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();
		
		int answer = 0;
		
		for (int i = 0; i < length; i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') stack.push(ch);
			else {
				if (stack.isEmpty()) {
					answer++;
				}else stack.pop();
			}
			
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
			answer++;
		}
		
		System.out.println(answer);
	}
}
