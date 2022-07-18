package study_0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17612_손준혁_ {

	//static Queue<Customer>[] list;
	static List<Queue<Customer>> list = new LinkedList<>();
	
	static int[] waitingTimes;
	static int[] payTimes, customerIds;
	static int resultCount = 1;
	static long result = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        waitingTimes = new int[K];
        payTimes = new int[K];
        customerIds = new int[K];
        
        for (int k = 0; k < K; k++) {
        	Queue<Customer> q = new LinkedList<>();
        	list.add(q);
		}
        
        for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			Customer c = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			wait(c);
		}
        pay(N);
        System.out.println(result);
	}
	static void wait(Customer c) {
		int countNum = 0;
		int tmp = waitingTimes[0];
		for (int i = 0; i < waitingTimes.length; i++) {
			if(tmp > waitingTimes[i] ) {
				countNum = i;
				tmp = waitingTimes[i];
			}
		}
		list.get(countNum).offer(c);
		waitingTimes[countNum] += c.w;
		
	}
	static void pay(int N) {
		for (int p = payTimes.length-1; p >= 0; p--) {
			Customer tmpC = list.get(p).poll();
			payTimes[p] = tmpC.w;
			customerIds[p] = tmpC.id;
		}
		while(true) {
			int min = 0;
			for (int p = payTimes.length-1; p >= 0; p--) {
				if(min < payTimes[p]) min = payTimes[p];
			}
			if(min == 0) {
				for (int p = payTimes.length-1; p >= 0; p--) {
					if(payTimes[p] != 0) {
						payTimes[p]--;
					}
					else{
						Customer tmpC = list.get(p).poll();
						if(tmpC != null) {
							result += resultCount * customerIds[p];
							resultCount++;
							payTimes[p] = tmpC.w-1;
							customerIds[p] = tmpC.id;
						}
						else if(customerIds[p] != 0){
							result += resultCount * customerIds[p];
							resultCount++;
							customerIds[p] = 0;
						}
					}
				}
			}
			else {
				for (int p = payTimes.length-1; p >= 0; p--) {
					payTimes[p] -= min;
				}
			}
//			for (int p = payTimes.length-1; p >= 0; p--) {
//				if(payTimes[p] == 0) {
//					Customer tmpC = list.get(p).poll();
//					if(tmpC != null) {
//						result += resultCount * customerIds[p];
//						resultCount++;
//						payTimes[p] = tmpC.w-1;
//						customerIds[p] = tmpC.id;
//					}
//					else if(customerIds[p] != 0){
//						result += resultCount * customerIds[p];
//						resultCount++;
//						customerIds[p] = 0;
//					}
//				}
//				else {
//					payTimes[p]--;
//				}
//			}
			if(resultCount > N) break;
		}
	}
	static class Customer{
		int id;
		int w;
		public Customer() {}
		public Customer(int id, int w) {
			this.id = id;
			this.w = w;
		}
	}
}
