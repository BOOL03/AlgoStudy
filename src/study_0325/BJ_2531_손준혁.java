package study_0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531_손준혁 {
	static int N,d,k,c,max;
	static int[] board, eat;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 종류
		k = Integer.parseInt(st.nextToken()); // 연속 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		board = new int[N];
		eat = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		count();
		System.out.println(max);
	}
	static void count() {
		int count = 0;
		for (int i = 0; i < k; i++) {
			if(eat[board[i]] == 0) count++;
			eat[board[i]]++;
		}
		max = count;
		for (int i = 1; i < N; i++) {
			if(max <= count) {
				if(eat[c]==0) max = count + 1;
				else max = count;
			}
			eat[board[i-1]]--;
			if(eat[board[i-1]] == 0) count--;
			
			if(eat[board[(i+k-1)%N]] == 0) count++;
			eat[board[(i+k-1)%N]]++;
		}
		
	}
}
