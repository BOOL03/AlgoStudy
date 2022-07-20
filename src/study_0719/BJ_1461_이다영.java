package study_0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1461_이다영 {
	
	static int N, M;
	static int answer;
	static List<Integer> minus;
	static List<Integer> plus;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		minus = new LinkedList<>();
		plus = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0) minus.add(Math.abs(num));
			else plus.add(num);
		}
		
		
		Collections.sort(minus, (n1, n2) -> n2 - n1);
		Collections.sort(plus, (n1, n2) -> n2 - n1);
		
		int max = 0;
		if(minus.size() > 0 && plus.size() > 0) {
			max = Math.max(minus.get(0), plus.get(0));
		}else if(minus.size() > 0) {
			max = minus.get(0);
		}else if(plus.size() > 0) {
			max = plus.get(0);
		}
		
		minusCal();
		plusCal();
		
		answer -= max;
		
		System.out.println(answer);
	}
	static void minusCal() {
		// 음수 왕복 계산
		while(!minus.isEmpty()) {
			int val = minus.get(0);
			for (int i = 0; i < M; i++) {
				minus.remove(0);
				if(minus.isEmpty()) break;
			}
			answer += val*2;
		}
	}
	static void plusCal() {
		while(!plus.isEmpty()) {
			int val = plus.get(0);
			for (int i = 0; i < M; i++) {
				plus.remove(0);
				if(plus.isEmpty()) break;
			}
			answer += val*2;
		}
	}
}
