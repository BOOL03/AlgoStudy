package study_0719;
import java.io.*;
import java.util.*;

public class BJ_12764_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] com = new int[n+1];
		Time[] per = new Time[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			per[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(per, (e1, e2) -> e1.p==e2.p ? e1.q-e2.q : e1.p-e2.p);
		
		int cnt = 1;
		com[0]++;
		PriorityQueue<Use> Q = new PriorityQueue<>((e1, e2) -> e1.end==e2.end ? e1.num-e2.num : e1.end-e2.end);
		PriorityQueue<Integer> seat = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			while(!Q.isEmpty()&& Q.peek().end<=per[i].p) {
				seat.offer(Q.poll().num);
			}
			if(!seat.isEmpty()) {
				int num = seat.poll();
				Q.offer(new Use(per[i].q, num));
				com[num]++;
			} else {
				com[cnt]++;
				Q.offer(new Use(per[i].q, cnt++));
			}
		}
		
		bw.write((cnt-1)+"\n");
		for(int i=1; i<cnt; i++) {
			bw.write(com[i]+" ");
		}
		
		bw.flush();
	}
	
	static class Time{
		int p, q;
		Time(int p, int q){
			this.p = p;
			this.q = q;
		}
	}
	
	static class Use{
		int end, num;
		Use(int end, int num){
			this.end = end;
			this.num = num;
		}
	}

}
