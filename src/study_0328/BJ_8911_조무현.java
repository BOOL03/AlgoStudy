package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8911_조무현 {

	static int T;
	static int x, y;
	static int[] dy = {1, -1, 0, 0}; //상 하 좌 우
	static int[] dx = {0, 0, -1, 1}; //0 1 2 3
	static int dir = 0; // 처음 북쪽
	// 왼쪽 모서리
	static int lty = 0, ltx = 0;
	// 오른쪽 모서리
	static int rby = 0, rbx = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		x = 0;
		y = 0;
		String input="";
		for (int t = 0; t < T; t++) {
			x = 0;
			y = 0;
			dir = 0;
			lty = 0;
			ltx = 0;
			rby = 0;
			rbx = 0;
			input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				move(input.charAt(i));
			}
			
			
			if(lty == rby || ltx == rbx) {
				System.out.println(0);
			}else {
				System.out.println(Math.abs(lty-rby) * Math.abs(rbx - ltx));
			}
			
		}
		
		
	}
	
	static void move(char s) {
		int ny = y;
		int nx = x;
		switch(s) {
		case 'F':
			ny += dy[dir];
			nx += dx[dir];
			break;
		case 'B':
			// 반대 방향으로 움직임
			if(dir == 0 || dir == 1) {
				ny += dy[1-dir];
				nx += dx[1-dir];
			}else {
				ny += dy[5-dir];
				nx += dx[5-dir];
			}
			break;
		case 'L':
			if(dir == 0) {
				dir = 2;
			}else if(dir == 1){
				dir = 3;
			}else if(dir == 2) {
				dir = 1;
			}else {
				dir = 0;
			}
			break;
		case 'R':
			if(dir == 0) {
				dir = 3;
			}else if(dir == 1){
				dir = 2;
			}else if(dir == 2) {
				dir = 0;
			}else {
				dir = 1;
			}
			break;
		}
		// 좌표의 왼쪽위와 오른쪽 아래 기록
		
		lty = Math.max(lty, ny);
		ltx = Math.min(ltx, nx);
		
		rby = Math.min(rby, ny);
		rbx = Math.max(rbx, nx);
		
		x = nx;
		y = ny;
		
	}

}
