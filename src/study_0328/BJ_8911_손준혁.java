package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8911_손준혁 {
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {-1,0,1,0};
	static int[] turtle = {0,0};// 0 : y , 1 : x
	static int dir = 0;
	static int right = 0, left = 0, top = 0, bottom = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			turtle[0] = 0;
			turtle[1] = 0;
			dir = right = left = top = bottom = 0;
			String tmp = br.readLine();
			char[] orders = tmp.toCharArray();
			for (int m = 0; m < orders.length; m++) {
				switch(orders[m]) {
				case 'F':
					turtle[0] += delta_y[dir];
					turtle[1] += delta_x[dir];
					//check x, y
					calc();
					break;
				case 'B':
					int move = (dir+2)%4;
					turtle[0] += delta_y[move];
					turtle[1] += delta_x[move];
					// check x, y
					calc();
					break;
				case 'L':
					dir = (dir+3)%4;
					break;
				case 'R':
					dir = (dir+5)%4;
					break;
				}
			}
			int row = Math.abs(right-left);
			int col = Math.abs(top - bottom);
			System.out.println(row*col);
		}

	}
	static void calc(){
		if(turtle[0] < top) top = turtle[0];
		else if(turtle[0] > bottom) bottom = turtle[0];
		
		if(turtle[1] < left) left = turtle[1];
		else if(turtle[1] > right) right = turtle[1];
	}
}
