package study_0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1149_조무현 {

	static int N;
	static int MIN_COST = Integer.MAX_VALUE;
	static ArrayList<int[]> house = new ArrayList<>();
	static int[] cost;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int red, green, blue = 0;

		cost = new int[N];
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			red = Integer.parseInt(st.nextToken());
			green = Integer.parseInt(st.nextToken());
			blue = Integer.parseInt(st.nextToken());
			house.add(new int[] {red, green, blue});
		}
//		subset(0, 0, -1);
		int[] first = house.get(0);
		for (int t = 0; t < 3; t++) {
			// 첫번째 집
			cost[0] = first[t];
			int before_color = t;
			// 두번째 집부터 dp
			for (int i = 1; i < N; i++) {
				// 색깔별로 확인
				int[] curHouse = house.get(i); 
				for (int j = 0; j < 3; j++) {
					if(before_color != j) {
						before_color = j;
						cost[i] = cost[i-1] + curHouse[j];
					}
				}
			}
			MIN_COST = Math.min(MIN_COST, cost[N-1]);
			
		}
		
		// 모든 집들의 경우의 수
		// 대신 다음집은 옆에 집이랑 다른 색이여야함
		System.out.println(cost[N-1]);
	}
	
	

}


