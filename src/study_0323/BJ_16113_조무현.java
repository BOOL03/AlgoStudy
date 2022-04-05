package study_0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16113_조무현 {
	static int N;
	static char[][] signal;
	static int cl;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cl = N/5;
		signal = new char[5][cl];
		char[] input = br.readLine().toCharArray();
		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < cl; j++) {
				signal[i][j] = input[index++];
			}
		}
		checkNum(0);
		System.out.println(sb.toString());

	}
	
	static void checkNum(int j) {
		if(j >= cl) return;
		if(signal[0][j] != '#') {
			checkNum(j+1);
			return;
		}
		// 0~9의 숫자 배열 원소가 해당 숫자인지
		if(one(j)) {
			sb.append(1);
			checkNum(j+2);
			return;
		}
		if(eight(j)) {
			sb.append(8);
			checkNum(j+4);
			return;
		}
		if(nine(j)) {
			sb.append(9);
			checkNum(j+4);
			return;
		}
		
		if(zero(j)) {
			sb.append(0);
			checkNum(j+4);
			return;
		}
		
		if(two(j)) {
			sb.append(2);
			checkNum(j+4);
			return;
		}
		if(three(j)) {
			sb.append(3);
			checkNum(j+4);
			return;
		}
		if(seven(j)) {
			sb.append(7);
			checkNum(j+4);
			return;
		}
		if(four(j)) {
			sb.append(4);
			checkNum(j+4);
			return;
		}
		if(six(j)) {
			sb.append(6);
			checkNum(j+4);
			return;
		}
		if(five(j)) {
			sb.append(5);
			checkNum(j+4);
			return;
		}

		checkNum(j+1);
		
	}
	
	static boolean zero(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&&signal[1][j] == '#' &&signal[1][j+2] == '#' 
					&&signal[2][j] == '#' &&signal[2][j+2] == '#' 
					&& signal[3][j] == '#' &&signal[3][j+2] == '#' 
					&& signal[4][j] == '#' &&signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean one(int j) {
		if(j < cl-1) { //유효
			if(signal[0][j] == '#' && signal[1][j] == '#' &&signal[2][j] == '#' &&signal[3][j] == '#' &&signal[4][j] == '#' 
					&& signal[0][j+1] == '.' && signal[1][j+1] == '.' &&signal[2][j+1] == '.' &&signal[3][j+1] == '.' &&signal[4][j+1] == '.')
				return true;
			
		}
		if(j == cl-1) {
			if(signal[0][j] == '#' && signal[1][j] == '#' &&signal[2][j] == '#' &&signal[3][j] == '#' &&signal[4][j] == '#')
				return true;
		}
		else {
			return false;
		}
		return false;
	}
	static boolean two(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j+2] == '#' 
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean three(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j+2] == '#' 
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j+2] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean four(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j] == '#' && signal[1][j+2] == '#' 
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j+2] == '#' 
					&& signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean five(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j] == '#' 
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j+2] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean six(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j] == '#' 
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j] == '#' && signal[3][j+2] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean seven(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&&signal[1][j+2] == '#' 
					&&signal[2][j+2] == '#' 
					&&signal[3][j+2] == '#' 
					&& signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean eight(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j] == '#' && signal[1][j+2] == '#'
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j] == '#' && signal[3][j+2] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	static boolean nine(int j) {
		if(j+2 < cl) { //유효
			if(signal[0][j] == '#' && signal[0][j+1] == '#' &&signal[0][j+2] == '#' 
					&& signal[1][j] == '#' && signal[1][j+2] == '#'
					&& signal[2][j] == '#' && signal[2][j+1] == '#' && signal[2][j+2] == '#' 
					&& signal[3][j+2] == '#' 
					&& signal[4][j] == '#' && signal[4][j+1] == '#' && signal[4][j+2] == '#') {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	
	

}
