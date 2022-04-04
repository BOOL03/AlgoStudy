package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2628_이다영 {
	
	static int H, W, N, max;
	static int [][]map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		map = new int[H][W];
		max = Integer.MIN_VALUE;
		
		
		int cntH = 0;
		int cntW = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(n == 0) { // 가로 자르기
				cntH++;
				for (int j = 0; j < W; j++) {
					map[num][j] = 1;
				}
			}
			else { // 세로 자르기
				cntW++;
				for (int j = 0; j < H; j++) {
					map[j][num] = 1;	
				}
			}
		}
		
		
		int[] h = new int[cntH+1];
		int[] w = new int[cntW+1];
		
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < H; i++) {
			if(map[i][0] == 1) {
				h[idx++] = cnt;
				cnt = 0;
			}
			else if(i==H-1) h[idx++] = ++cnt;
			cnt++;
		}
		
		cnt = 0;
		idx = 0;
		for (int i = 0; i < W; i++) {
			if(map[0][i] == 1){
				w[idx++] = cnt;
				cnt = 0;
			}
			else if(i==W-1) w[idx++] = ++cnt;
			cnt++;
		}
		
		for (int i = 0; i < cntH+1; i++) {
			for (int j = 0; j < cntW+1; j++) {
				int size = h[i] * w[j];
				max = Math.max(max, size);
			}
		}
		System.out.println(max);
	}
}
