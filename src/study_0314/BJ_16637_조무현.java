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
					// 첫번째 연산자 인경우에는 왼쪽 숫자를 추가
					if(i == 0) {
						valid_num.add(num[i]);
					}
					// 현재 연산자의 다음연산자가 괄호에 포함되지 않은 연산자라면 
					// 연산자의 오른쪽 위치 숫자를 추가
					// (1+2) + (2+3) 이런 경우를 배제하기 위해서
					// (1+2) + 2 + 3  이런 경우에는 추가
					if(i+1 < N/2 && !selected[i+1]) {
						valid_num.add(num[i+1]);						
					}
					// 현재 연산자의 다음연산자가 없다면 오른쪽 숫자 추가
					// (1+2) + 2 이런경우
					if(i+1 >= N/2) {
						valid_num.add(num[i+1]);
					}
				}
			}
			// 괄호안에 있는걸 다 계산 해준 결과이므로
			// 숫자(valid_num)와 연산자(valid_op)만 남음
			int sum = valid_num.get(0);
			for (int i = 0; i < valid_op.size(); i++) {
				char op = valid_op.get(i);
				sum = validResult(sum, op, i, valid_num);
			}
			ans = Math.max(ans, sum);
			return;
		}
		selected[tgtIdx] = true;
		// 현재 위치의 연산자를 선택하면 바로 다음위치의 연산자는
		// 괄호에 포함시킬수없음
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
