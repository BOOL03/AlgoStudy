package study_0613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_12731_손준혁 {
	static ArrayList<Train> train = new ArrayList<>();
	static boolean[] trainCount;
	static int trainA, trainB;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int r = 0; r < T; r++) {
        	trainA = 0;
        	trainB = 0;
        	
			int delay = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int train_a = Integer.parseInt(st.nextToken());
 			int train_b = Integer.parseInt(st.nextToken());
			int[] tmp = new int[train_a + train_b];
			int[] trainOrder = new int[train_a+train_b];
        	for (int t = 0; t < train_a+train_b; t++) {
				String[] time = br.readLine().split(" ");
				String[] times = time[0].split(":");
				int start = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
				times = time[1].split(":");
				int arrive = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
				if(t < train_a) {
					train.add(new Train(start, arrive, true));
					tmp[t] = start;
				}
				else {
					train.add(new Train(start, arrive, false));
					tmp[t] = start;
				}
				trainOrder[t] = t;
			}

        	for (int i = 0; i < train_a+train_b; i++) {
				for (int j = 0; j < train_a+train_b-1-i; j++) {
					if(tmp[j] > tmp[j+1]) {
						int tmp_int = tmp[j];
						tmp[j] = tmp[j+1];
						tmp[j+1] = tmp_int;
						
						tmp_int = trainOrder[j];
						trainOrder[j] = trainOrder[j+1];
						trainOrder[j+1] = tmp_int;
					}
				}
			}

        	
        	trainCount = new boolean[train_a+train_b];
        	
        	for (int t = 0; t < train_a+train_b; t++) {
				if(trainCount[trainOrder[t]]) continue;
				boolean way;
				if(trainOrder[t] < train_a) way = true;
				else way = false;
				if(way) trainA++;
				else trainB++;
				run(train_a, trainOrder[t], delay, way);
			}
        	
        	System.out.println("Case #"+(r+1)+": "+trainA+" "+trainB);
        	train.clear();
        	
		}
	}
	
	static void run(int num, int count, int delay, boolean way) {
		if(trainCount[count]) {
			return;
		}
		trainCount[count] = true;
		
		int start, end;
		if(way) { // b to a train
			start = num;
			end = trainCount.length;
		}
		else {
			start = 0;
			end = num;
		}
		int minTime = Integer.MAX_VALUE;
		int arriveTime = train.get(count).arrive + delay;
		int place = -1;
		for (int i = start; i < end; i++) {
			if(minTime > (arriveTime - train.get(i).start) && (arriveTime - train.get(i).start) <= 0) {
				place = i;
			}
		}
		if(place != -1) {
			run(num, place, delay, !way);
		}
	}
	
	static class Train{
		int start;
		int arrive;
		boolean way;
		public Train() {};
		public Train(int start, int arrive, boolean way) {
			this.start = start;
			this.arrive = arrive;
			this.way = way;
		};
	}
}
