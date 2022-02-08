package study_0207;
import java.util.*;
import java.io.*;


public class BJ_11899_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for(int i=0; i<str.length(); i++) {
			char token = str.charAt(i);
			if(token=='(') stack.push(token);
			else {
				if(stack.empty()) answer++;
				else stack.pop();
			}
		}
		System.out.println(answer+stack.size());
	}
}
