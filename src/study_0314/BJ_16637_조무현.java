package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16637_조무현 {
	static int N;
	static int[] num;
	static int[] dp;
	static ArrayList<Integer> valid_num = new ArrayList<>();
	static ArrayList<Character> valid_op = new ArrayList<>();
	static char[] operator;
	static boolean[] selected;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		num = new int[N/2 + 1];
		selected = new boolean[N/2];
		operator = new char[N/2];
		// 입력
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if(i%2 == 0) {
				num[i/2] = Character.getNumericValue(input[i]);
			}else {
				operator[i/2] = input[i];
			}
		}
		if(N == 1) {
			System.out.println(num[0]);
			return;
		}

		subSet(0);
		System.out.println(ans);
	}
	// 괄호를 놓을 수 있는 모든 경우의 수를 고려
	static void subSet(int tgtIdx) {
		if(tgtIdx >= N/2) {
			valid_num.clear();
			valid_op.clear();
			
			for (int i = 0; i < N/2; i++) {
				// 괄호에 포함되는 연산자인 경우
				if(selected[i]) {
					// 바로 계산해서 valid_num 배열에 추가
					valid_num.add(opResult(operator[i], i));
				}
				// 괄호에 포함되지 않는 연산자인 경우
				else {
					valid_op.add(operator[i]);
					
					if(i == 0) {
						valid_num.add(num[i]);
					}
					if(i+1 < N/2 && !selected[i+1]) {
						valid_num.add(num[i+1]);						
					}
					if(i+1 >= N/2) {
						valid_num.add(num[i+1]);
					}
				}
			}
			
			int sum = valid_num.get(0);
			for (int i = 0; i < valid_op.size(); i++) {
				char op = valid_op.get(i);
				sum = validResult(sum, op, i, valid_num);
			}
			ans = Math.max(ans, sum);
			return;
		}
		selected[tgtIdx] = true;
		subSet(tgtIdx + 2);
		selected[tgtIdx] = false;
		subSet(tgtIdx + 1);
	}
	
	static int opResult(char op, int i) {
		switch(op) {
		case '+':
			return num[i] + num[i+1];
		case '-':
			return num[i] - num[i+1];
		case '*':
			return num[i] * num[i+1];
		}
		return 0;
	}
	
	static int validResult(int tmp, char op, int i, ArrayList<Integer> valid_num) {
		switch(op) {
		case '+':
			return tmp + valid_num.get(i+1);
		case '-':
			return tmp - valid_num.get(i+1);
		case '*':
			return tmp * valid_num.get(i+1);
		}
		return 0;
	}
}
