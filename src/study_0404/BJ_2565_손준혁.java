package study_0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2565_손준혁 {
	static List<Line>powerPole = new ArrayList<>();
	static List<Integer> powerPoleList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			powerPole.add(new Line(a,b));
		}
		Collections.sort(powerPole);
		int count = 0, maxCount = 0;
		int listSize = 0;
		for (int i = 0; i < T; i++) {
			for (int j = i+1; j < T; j++) {
				if(powerPole.get(i).a < powerPole.get(j).a) {
					count++;
					powerPoleList.add(j);
				}
			}
			if(count >= maxCount) {
				maxCount = count;
				count = 0;
				listSize = Math.max(listSize, powerPoleList.size());
			}
			powerPoleList = new ArrayList<>();
		}
		System.out.println(powerPole.size() - listSize);
	}
	static class Line implements Comparable<Line>{
		int a;
		int b;
		public Line(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			if(o.b < this.b) {
				return 1;
			}
			else if(o.b > this.b) {
				return -1;
			}
			return 0;
		}
	}
}
