package study_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_손준혁 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		int[][] local = new int[n+1][2];
		for(int i=0; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			local[i][0] = Integer.parseInt(st.nextToken());
			local[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int dir = local[n][0];
		int num = local[n][1];
		
		if(dir == 1) { //상
			for(int i=0; i<n; i++) {
				if(local[i][0] == 1) {
					count += Math.abs(local[i][1] - num);
				}else if(local[i][0] == 2) {
					count += Math.min(h + local[i][1] + num, h + (w - local[i][1]) + (w - num));
				}else if(local[i][0] == 3) {
					count += local[i][1] + num;
				}else {
					count += (h - local[i][1]) + num;
				}
			}
		}
		else if(dir == 2){ //하
			for(int i=0; i<n; i++) {
				if(local[i][0] == 1) {
					count += Math.min(h + local[i][1] + num, h + (w - local[i][1]) + (w - num));
				}else if(local[i][0] == 2) {
					count += Math.abs(local[i][1] - num);
				}else if(local[i][0] == 3) {
					count += (h - local[i][1]) + num;
				}else {
					count += (h - local[i][1]) + (w - num);
				}
			}
		}
		else if(dir == 3) { //좌
			for(int i=0; i<n; i++) {
				if(local[i][0] == 1) {
					count += num + local[i][1];
				}else if(local[i][0] == 2) {
					count += (h - num) + local[i][1];
				}else if(local[i][0] == 3) {
					count += Math.abs(local[i][1] - num);
				}else {
					count += Math.min(w + local[i][1] + num, w + (h - local[i][1]) + (h - num));
				}
			}
		}
		else if(dir == 4) { //우
			for(int i=0; i<n; i++) {
				if(local[i][0] == 1) {
					count += num + (w - local[i][1]);
				}else if(local[i][0] == 2) {
					count += (h - num) + (w - local[i][1]);
				}else if(local[i][0] == 3) {
					count += Math.min(w + local[i][1] + num, w + (h - local[i][1]) + (h - num));
				}else {
					count += Math.abs(local[i][1] - num);
				}
			}
		}
		
		System.out.println(count);
	}

}