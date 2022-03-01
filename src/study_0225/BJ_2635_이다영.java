package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_수이어가기_2635 {
	static int N, ans;
	static List<Integer> answer;
	static List<Integer> temp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		answer = new ArrayList<>();
		temp = new ArrayList<>();
		
		int size = 0;
		
		for (int i = 1; i <= N; i++) {
			temp.clear();
			temp.add(N);
			calc(N, i);
			size = temp.size();
			if(ans < size) {
				ans = size;
				answer.clear();
				for (int j = 0; j < size; j++) {
					answer.add(temp.get(j));
				}
			}
		}
		sb.append(ans).append("\n");
		for (int i = 0; i < ans; i++) {
			sb.append(answer.get(i)).append(" ");
		}
		sb.setLength(sb.length() -1 );
		System.out.println(sb);
	}
	static void calc(int before, int num) {
		temp.add(num);
		if(before - num < 0) return;
		calc(num, before-num);
	}
}
