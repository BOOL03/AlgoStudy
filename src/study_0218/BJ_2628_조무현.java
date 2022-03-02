package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2628_조무현 {
	static int R, C, N;
	static int max;
	static ArrayList<Integer> row = new ArrayList<>();
	static ArrayList<Integer> col = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) row.add(Integer.parseInt(st.nextToken()));
			else col.add(Integer.parseInt(st.nextToken()));
		}
		row.add(0);
		row.add(R);
		col.add(0);
		col.add(C);
		
		Collections.sort(row);
		Collections.sort(col);
		
		int tl_y, tl_x, br_y, br_x;
		for (int i = 0; i < row.size()-1; i++) {
			for (int j = 0; j < col.size()-1; j++) {
				tl_y = row.get(i);
				tl_x = col.get(j);
				br_y = row.get(i+1);
				br_x = col.get(j+1);
				
				max = Math.max(paperSize(tl_y, tl_x, br_y, br_x), max);
			}
		}
		
		System.out.println(max);
	}
	
	static int paperSize(int y1, int x1, int y2, int x2) {
		return (Math.abs(y1 - y2) * Math.abs(x1 - x2));
	}
	

}
