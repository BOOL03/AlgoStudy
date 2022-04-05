package study_0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2565_조무현 {
	static int N;
	static Wire[] wires;
	static int[] LIS;
	static class Wire{
		int left;
		int right;
		public Wire(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return "Wire [left=" + left + ", right=" + right + "]";
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wires = new Wire[N];
		LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
		}
		Arrays.sort(wires, (w1, w2)->w1.left - w2.left);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(wires[i].right > wires[j].right) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(LIS[i], max);
		}
		
		System.out.println(N - max);
		
	}

}
