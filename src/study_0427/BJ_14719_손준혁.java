package study_0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_손준혁 {
	static int rain = 0;
	static int[] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		list = new int[W];
		st = new StringTokenizer(br.readLine());
		int num = 0, place = 0;
		for (int i = 0; i < W; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			if(num < list[i]) {
				num = list[i];
				place = i;
			}
		}
		calc(place, 2);
		System.out.println(rain);
	}

	static void calc(int place, int mode) { // mode 0 : left, 1 : right 2 : first run
		int num = 0, point = 0;
		if(mode == 0 || mode == 2) {
			for (int i = place - 1; i >= 0; i--) {
				if(num <= list[i]) {
					num = list[i];
					point = i;
				}
			}
			for (int i = point+1; i < place; i++) {
				int water = num - list[i];
				if(water < 0) water = 0;
				rain += water;
			}
			if( point > 1) calc(point, 0);
		}
		if(mode == 1 || mode == 2) {
			num = 0;
			point = list.length - 1;
			for (int i = place+1; i < list.length; i++) {
				if(num <= list[i]) {
					num = list[i];
					point = i;
				}
			}
			for (int i = place+1; i < point; i++) {
				int water = num - list[i];
				if(water < 0) water = 0;
				rain += water;
			}
			if( point < list.length-2) calc(point, 1);
		}
		
	}
}
