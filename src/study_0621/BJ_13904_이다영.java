package study_0621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_13904_이다영 {
	static List<Homework> list = new ArrayList<>();
	static int N;
	static int sum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, (o1, o2) -> o1.d == o2.d? o2.w - o1.w : o2.d - o1.d);
		
		int lastDay = list.get(0).d;
		
		for (int i = lastDay; i > 0; i--) {
			Homework ans = new Homework(0, 0);
			
			for (Homework hw : list) {
				if(i <= hw.d) {
					if(ans.w < hw.w) {
						ans = hw;
					}
				}
				else break;
			}
			
			sum += ans.w;
			list.remove(ans);
		}
		System.out.println(sum);
	}
	
	static class Homework {

		int d, w;

		Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
}
