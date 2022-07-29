package study_0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


// https://stack07142.tistory.com/49 참고함

public class BJ_13415_이다영 {
	
	static int N, K;
	
	static Deque<Integer> orderSet;
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sortedArr = new int[N];
		
		orderSet = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		K = Integer.parseInt(br.readLine());
		
		int max = 0;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken()); //오름차순
			int minus = Integer.parseInt(st.nextToken()); //내림차순
			
			max = Math.max(max, Math.max(plus, minus));
			
			while( (!orderSet.isEmpty()) && (Math.abs(orderSet.getLast()) <= plus)) {
				orderSet.pollLast();
			}
			orderSet.addLast(plus);
			
			while( (!orderSet.isEmpty()) && (Math.abs(orderSet.getLast()) <= minus)) {
				orderSet.pollLast();
			}
			orderSet.addLast(-minus);
		}
		
		Arrays.sort(arr, 0, max);
		
		for (int i = max; i < N ; i++) {
			sortedArr[i] = arr[i];
		}
		
		int descendIdx = 0;
		int ascendIdx = max-1;
		int sortedArrIdx = max-1;
		
		while(!orderSet.isEmpty()) {
			int num = orderSet.pollFirst();
			int next = 0;
			if(!orderSet.isEmpty()) next = orderSet.getFirst();
	
			if(num < 0) { //내림차순
				int diff = Math.abs(num) - Math.abs(next);
				for (int i = 0; i < diff; i++) {
					sortedArr[sortedArrIdx--] = arr[descendIdx++];
				}
				
			}else {//오름차순
				int diff = Math.abs(num) - Math.abs(next);
				for (int i = 0; i < diff; i++) {
					sortedArr[sortedArrIdx--] = arr[ascendIdx--];
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) {
            sb.append(sortedArr[i] + " ");
        }
		
		System.out.println(sb);
	}
}
