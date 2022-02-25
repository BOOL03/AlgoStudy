package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2304_손준혁 {
	static int sum = 0,maxHeight = 0;
	static int[][] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			if(maxHeight < list[i][1]) {
				maxHeight = list[i][1];
			}
		}
		Arrays.sort(list, Comparator.comparingInt(l1->l1[0]));

		int max_a = left(N);
		int max_b = right(N-1);
		sum += maxHeight*(max_b - max_a);
		System.out.println(sum);
	}
	static int left(int n) {
		int tmpHeight = 0, startPlace = list[0][0];
		for (int i = 0; i < n; i++) {
			if(list[i][1] > tmpHeight) {
				sum += (list[i][0] - startPlace) * tmpHeight;
				if(list[i][1] == maxHeight) return list[i][0];
				startPlace = list[i][0];
				tmpHeight = list[i][1];
				System.out.println(sum);
			}
		}
		return -1;
	}
	static int right(int n) {
		int tmpHeight = 0, startPlace = list[n][0]+1;
		for (int i = n; i >= 0; i--) {
			if(list[i][1] > tmpHeight) {
				sum += (startPlace - (list[i][0] + 1)) * tmpHeight;
				if(list[i][1] == maxHeight) return list[i][0]+1;
				startPlace = list[i][0]+1;
				tmpHeight = list[i][1];
				System.out.println(sum);
				
			}
		}
		return -1;
	}
}
