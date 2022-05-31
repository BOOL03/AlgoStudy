package study_0520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2800_손준혁 {
	static char[] arr;
	static List<Case> list = new ArrayList<Case>();
	
	static int[] src;
	static boolean[] selected;
	static boolean check = false;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();

		int last_i = -1;
		int count_i = 0;
		int case_count = 0;
		
		int start_i = -1;
		int cnt_i = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '(') {
				case_count++;
				list.add(new Case(i, 0, case_count));
				count_i = 0;
				if(i-start_i == 1) cnt_i++;
				start_i = i;
			}
			else if(arr[i] == ')') {
				count_i++;
				if(last_i > 0 && last_i - i == -1 && count_i > 1) {
					if(cnt_i > 0) {
						arr[list.get(list.size()-1).start] = 0;
						arr[i] = 0;
						list.remove(list.size()-1);
						cnt_i--;
					}
					
				}
				else {
					for (int j = list.size()-1; j >= 0; j--) {
						if(list.get(j).place == case_count && list.get(j).end == 0) {
							list.get(j).end = i;
							break;
						}
					}
				}
				last_i = i;
				case_count--;
			}
			else count_i = 0;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			if(c!=0) sb.append(c);
		}
		System.out.println(sb.toString());
		src = new int[list.size()];
		selected = new boolean[list.size()];
		subSet(0);
	}
	static void subSet(int idx) {
		if(idx == src.length) {
			if(check) print();
			check = true;
			return;
		}
		
		selected[idx] = true;
		subSet(idx+1);
		
		selected[idx] = false;
		subSet(idx+1);	
	}
	static void print() {
		char[] tmp = arr.clone();
		for (int i = 0; i < selected.length; i++) {
			if(!selected[i]) {
				tmp[list.get(i).start] = 0;
				tmp[list.get(i).end] = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : tmp) {
			if(c!=0) sb.append(c);
		}
		System.out.println(sb.toString());
	}
	static class Case{
		int start;
		int end;
		int place;
		public Case(){}
		public Case(int start,int end, int place) {
			this.start = start;
			this.end = end;
			this.place = place;
		}
	}
}
