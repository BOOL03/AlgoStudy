package study_0520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BJ_2800_괄호제거 {
	static char[] base;
	static int N;
	static List<int[]> bracket;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
	static Set<String> answerSet = new HashSet<>();
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		
		base = str.toCharArray();
		bracket = new ArrayList<>();
		
		int len = str.length();
		N = 0;
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if(ch == '(') N++;
		}
		
		select = new boolean[N];
		
//		int fromS = 0;
//		int fromE = len-1;
//		for (int i = 0; i < N; i++) {
//			fromS = str.indexOf('(', fromS);
//			fromE = str.lastIndexOf(')', fromE);
//			bracket.add(new int[] {fromS++, fromE--});
//		}
		int fromS = 0;
		int fromE = 0;
		for (int i = 0; i < N; i++) {
			int cntS = 0;
			int cntE = 0;
			for (int j = fromS; j < len; j++) {
				char ch = str.charAt(j);
				if(ch == '(' && cntS ==0) {
					fromS = j;
					cntS ++;
				}else if(ch == '(') cntS ++;
				else if (ch == ')' && cntS!= 0 && ++cntE == cntS ) {
					fromE = j;
					bracket.add(new int[] {fromS++, fromE});
					break;
				}
			}
		}
		
		subset(0);
		List<String> answer = new ArrayList<>();
		
		for (String string : answerSet) {
			answer.add(string);
		}
		Collections.sort(answer);
		
		
		for (String string : answer) {
			sb.append(string + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void subset(int srcIdx) {
		if(srcIdx == N) {
			//complete code
			if(++cnt == Math.pow(2, N)) return;
			
			printSubset();
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void printSubset() {
		String tmp = "";
		for (char c : base) {
			tmp += c;
		}
		
		for (int i = 0; i < N; i++) {
			if(select[i]) {
				int idx1 = bracket.get(i)[0];
				int idx2 = bracket.get(i)[1];
				
				base[idx1] = '.';
				base[idx2] = '.';
				

			}
		}
		String tmp2 = "";
		for (char c : base) {
			if(c != '.') tmp2 +=c;
		}
		answerSet.add(tmp2);
		
		base = tmp.toCharArray();
	}
}
