package study_0520;
import java.io.*;
import java.util.*;

public class BJ_2800_배찬비 {
	
	static ArrayList<int[]> bracket = new ArrayList<>();
	static int size;
	static char[] str;
	static Set<String> answers = new TreeSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<str.length; i++) {
			if(str[i]=='(') stack.add(i);
			else if(str[i]==')') {
				bracket.add(new int[] {stack.pop(), i});
			}
		}
		size = bracket.size();
		
		remove(0, 0);
		
//		Collections.sort(answers);
		for(String answer : answers) {
			bw.append(answer+"\n");
		}
		bw.flush();
	}
	
	static void remove(int cnt, int index) {
		if(cnt==size) {
			return;
		}
		for(int i=index; i<size; i++) {
			str[bracket.get(i)[0]] = ' ';
			str[bracket.get(i)[1]] = ' ';
			answers.add(trim());
			remove(cnt+1, i+1);
			str[bracket.get(i)[0]] = '(';
			str[bracket.get(i)[1]] = ')';
		}
	}
	
	static String trim() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length; i++) {
			if(str[i]!=' ') sb.append(str[i]);
		}
		return sb.toString();
	}

}
