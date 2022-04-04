package study_0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BJ_2023_손준혁 {
	static int[] prime_one = {2,3,5,7};
	static PriorityQueue<Integer> list = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 4; i++) {
			list.offer(prime_one[i]);
		}
		for (int i = 1; i < N; i++) {
			int list_size = list.size();
			for (int j = 0; j < list_size; j++) {
				int list_num = list.poll();
				for (int k = 1; k < 10; k++) {
					int num = (int) (list_num * 10 + k);
					
					if(PrimeCheck(num)) {
						list.offer(num);
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int list_size = list.size();
		for (int i = 0; i < list_size; i++) {
			bw.write(list.poll()+"\n");
		}
		bw.close();
	}
	static boolean PrimeCheck(int num) {
		int sqrt = (int) Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
