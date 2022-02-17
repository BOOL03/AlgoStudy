package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2512_손준혁 {
	static int N, Max;
	static int[] require;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		require = new int[N];
		int sum_require = 0;
		int mid =0, min = 0, tmp = 0, max = 0, result = 0;
		for (int i = 0; i < N; i++) {
			require[i] = Integer.parseInt(st.nextToken());
			sum_require += require[i];
			max = Math.max(max, require[i]);
		}
		Max = Integer.parseInt(br.readLine());
		if(sum_require <= Max) {
			System.out.println(max);
			return;
		}
		while(true) {
			mid = (max + min)/2;
			tmp = 0;
			if(mid == min) break;
			 for(int i = 0; i < N; i++) {
				 if(mid < require[i]) tmp += mid;
				 else tmp+= require[i];
             }
             if(tmp <= Max) {
                 result = Math.max(mid, result);
                 min = mid;
             } else {
                 max = mid;
             }
		}
		System.out.println(result);
	}

}
