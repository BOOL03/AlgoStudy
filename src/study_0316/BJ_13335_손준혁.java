package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335_손준혁 {
	static int N,W,L;
	static int[] bridge;
	static Queue<Integer>list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		bridge = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0, max = 0;
		while(true) {
			count++;
			rotation();
			max = returnMax();
			if(!list.isEmpty() && max + list.peek() <= L) {
				bridge[0] = list.poll();
			}
			else {
				bridge[0] = 0;
			}
			
			if(returnMax() == 0 && list.size() == 0) break;
		}
		System.out.println(count);
	}
	static void rotation() {
		for (int i = W-1; i >0; i--) {
			bridge[i] = bridge[i-1];
		}
		bridge[0] = 0;
	}
	static int returnMax() {
		int sum = 0;
		for (int i = 0; i < W; i++) {
			sum += bridge[i];
		}
		return sum;
	}
}
