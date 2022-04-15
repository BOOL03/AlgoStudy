package study_0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096_손준혁 {
	static int N;
	static int[][] max,min;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = new int[2][3];
		min = new int[2][3];
		N = Integer.parseInt(br.readLine());
		int repeat = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			max[repeat][0] = Math.max(max[1-repeat][0], max[1-repeat][1]) + x;
			max[repeat][1] = Math.max(Math.max(max[1-repeat][0], max[1-repeat][1]), max[1-repeat][2]) + y;
			max[repeat][2] = Math.max(max[1-repeat][1], max[1-repeat][2]) + z;
			
			min[repeat][0] = Math.min(min[1-repeat][0], min[1-repeat][1]) + x;
			min[repeat][1] = Math.min(Math.min(min[1-repeat][0], min[1-repeat][1]), min[1-repeat][2]) + y;
			min[repeat][2] = Math.min(min[1-repeat][1], min[1-repeat][2]) + z;
			
			repeat = 1 - repeat;
		}
		int max_data = max[repeat][1] = Math.max(Math.max(max[1-repeat][0], max[1-repeat][1]), max[1-repeat][2]);
		int min_data = min[repeat][1] = Math.min(Math.min(min[1-repeat][0], min[1-repeat][1]), min[1-repeat][2]);
		System.out.println(max_data+" "+min_data);
	}

}
