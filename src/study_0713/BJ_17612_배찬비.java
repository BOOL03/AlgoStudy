package study_0713;
import java.io.*;
import java.util.*;

public class BJ_17612_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<Counter> counter = new PriorityQueue<>((e1, e2) -> e1.time==e2.time? e1.num-e2.num : e1.time-e2.time);
		PriorityQueue<Customer> customer = new PriorityQueue<>((e1, e2) -> e1.time==e2.time? e2.couNum-e1.couNum : e1.time-e2.time);
		
		for(int i=0; i<n && i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			customer.offer(new Customer(id, w, i+1));
			counter.offer(new Counter(i+1, w));
		}
		
		for(int i=k; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Counter tmp = counter.poll();
			int num = tmp.num;
			int time = tmp.time;
			customer.offer(new Customer(id, w+time, num));
			counter.offer(new Counter(num, w+time));
		}
		
		long answer = 0;
		long cnt = 1;
		while(!customer.isEmpty()) {
			Customer tmp = customer.poll();
			answer += (long)tmp.cusNum*cnt;
			cnt++;
		}
		
		System.out.println(answer);
		
	}
	
	static class Counter{
		int num, time;
		Counter(int num, int time){
			this.num = num;
			this.time = time;
		}
	}
	
	static class Customer{
		int cusNum, time, couNum;
		Customer(int cusNum, int time, int couNum){
			this.cusNum = cusNum;
			this.time = time;
			this.couNum = couNum;
		}
	}

}
