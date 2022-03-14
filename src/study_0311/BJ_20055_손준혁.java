package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20055_손준혁 {
	static int N, K, count = 0;
	static Belt[] belt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new Belt[2*N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=2*N;i++) {
			belt[i] = new Belt(false, Integer.parseInt(st.nextToken()));
		}
		//print();
		while(true) {
			boolean result = spinBelt();
			if(result) {
				System.out.println(count);
				break;
			}
		}
	}
	static boolean spinBelt() {
		print();
		belt[0] = belt[N];
		for (int i = 2*N-1; i > 0; i--) {
			belt[i] = belt[i-1];
		}
		if(belt[N].load) belt[N].load = false;
		if(belt[1].dura > 0) belt[N].dura--;
		for (int i = N; i > 0; i--) {
			if(belt[i].load && !belt[i-1].load && belt[i-1].dura > 0) {
				belt[i].load = false;
				belt[i-1].load = true;
			}
		}
		if(belt[N].load) belt[N].load = false;
		count++;
		int sum = 0;
		for(int i = 1;i<2*N;i++) {
			if(belt[i].dura == 0) sum++;
		}
		if(sum == K) return true;
		return false;
	}
	static void print() {
		for (int i = 1; i < belt.length; i++) {
			System.out.print(belt[i].dura+" ");
		}
		System.out.println();
	}
	static class Belt{
		boolean load;
		int dura;
		public Belt(boolean l, int d) {
			this.load = l;
			this.dura = d;
		}
	}
}

