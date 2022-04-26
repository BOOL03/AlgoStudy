package study_0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20304_손준혁 {
	static int maxCost = 0,pw=0;
	static int[] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pw |= (1<<Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			int tmpcount = Integer.MAX_VALUE;
			for(int j=0;j<18;j++) {
				if((pw&(1<<j)) == (1<<j)) {
					tmpcount = Math.min(tmpcount, Integer.bitCount(j^i));
				}
			}
			maxCost = Math.max(maxCost, tmpcount);
		}
		System.out.println(maxCost);
	}

}
