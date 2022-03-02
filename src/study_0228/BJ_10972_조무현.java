package study_0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10972_조무현 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int result = np();
		if(result == -1) {
			System.out.println("-1");
		}else {
			for (int i = 0; i < N; i++) {
				System.out.print(num[i] + " ");
			}
		}
	}
	
	static int np() {
		// 꼭대기 찾기
		int i = N-1;
		while(i > 0 && num[i-1] >= num[i]) i--;
		
		if( i == 0 ) return -1;
		
		// 꼭대기 바로 왼쪽값보다 큰 값을 찾기
		int j = N-1;
		while(num[i-1] >= num[j]) j--;
		swap(i-1, j);
		int k = N-1;
		while(i < k) swap(i++, k--);
		return 1;
	}

	static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
