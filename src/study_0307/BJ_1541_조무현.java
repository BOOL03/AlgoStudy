package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1541_조무현 {
	static ArrayList<Integer> input = new ArrayList<Integer>();
	static ArrayList<Character> operator = new ArrayList<>();
	static Stack<Integer> numbers = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, "+|-");
		
		while(st.hasMoreTokens()) {
			input.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '-' || line.charAt(i) == '+') {
				operator.add(line.charAt(i));
				cnt++;
			}
		}
		int sum = 0;
		for (int i = 0; i < operator.size(); i++) {
			
			if(operator.get(i) == '+') {
				if(!numbers.isEmpty())sum = numbers.pop() + input.get(i+1);
				else sum = input.get(i) + input.get(i+1);
				numbers.push(sum);
			}else {
				if(!numbers.isEmpty()) numbers.push(input.get(i+1));
				else {
					numbers.push(input.get(i));
					numbers.push(input.get(i+1));
				}
			}
		}
		if(operator.isEmpty()) {
			System.out.println(input.get(0));
			return;
		}
		int[] last_num = new int[numbers.size()];
		int index = 0;
		while(!numbers.isEmpty()) {
			last_num[index] = numbers.pop();
			index++;
		}
		int ans = 0;
		for (int i = 0; i < last_num.length-1; i++) {
			ans -= last_num[i];
		}
		ans += last_num[last_num.length-1];
		System.out.println(ans);
		
	}

}
