package study_0613;
import java.io.*;
import java.util.*;

public class BJ_12731_배찬비 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=n; t++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int na = Integer.parseInt(st.nextToken());
			int nb = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> train = new ArrayList<>();
			
			for(int i=0; i<na; i++) {
				st = new StringTokenizer(br.readLine());
				int s = transminute(st.nextToken());
				int e = transminute(st.nextToken());
				train.add(new int[] {s, e, 1});
			}
			for(int i=0; i<nb; i++) {
				st = new StringTokenizer(br.readLine());
				int s = transminute(st.nextToken());
				int e = transminute(st.nextToken());
				train.add(new int[] {s, e, 2});
			}
			
			Collections.sort(train, (e1, e2)->e1[0]==e2[0]?e1[1]-e2[1]:e1[0]-e2[0]);
			
			int ab = 0;
			int ba = 0;
			PriorityQueue<Integer> abQ = new PriorityQueue<>((e1, e2)->e1-e2);
			PriorityQueue<Integer> baQ = new PriorityQueue<>((e1, e2)->e1-e2);
			abQ.offer(1440);
			baQ.offer(1440);
			
			for(int i=0; i<na+nb; i++) {
				if(train.get(i)[2]==1) {  // A->B
					if(train.get(i)[0]<abQ.peek()) {
						ab++;
						baQ.offer(train.get(i)[1]+T);
					} else {
						abQ.poll();
						baQ.offer(train.get(i)[1]+T);
					}
				} else {
					if(train.get(i)[0]<baQ.peek()) {
						ba++;
						abQ.offer(train.get(i)[1]+T);
					} else {
						baQ.poll();
						abQ.offer(train.get(i)[1]+T);
					}
				}
			}
			sb.append("Case #"+t+": "+ab+" "+ba+"\n");
			
		}
		System.out.println(sb.toString());
		
	}
	
	static int transminute(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3, 5));
		return hour*60+minute;
	}


}
