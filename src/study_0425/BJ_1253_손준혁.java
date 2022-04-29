package study_0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1253_손준혁 {
	static int N;
	static int[] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[N];
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			list[i] = n;

		}
		Arrays.sort(list);
		System.out.println(calc());
	}

	static int calc() {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int left = 0, right = N - 1;
			while (true) {
				if (left == i) left++;
				if (right == i) right--;
				if (left >= right) break;
				
				int sum = list[left] + list[right];
				if (sum == list[i]) {
					answer++;
					break;
				}
				
				if (sum < list[i]) left++;
				if (sum > list[i]) right--;
			}
		}
		
		return answer;
	}
}
