package study_0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_손준혁 {
	
	static int[][] map;
	static int[] dice = new int[6];
	static int x,y,N,M;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int move = Integer.parseInt(st.nextToken());
			Move(move);
		}
	}
	static void Move(int move) {
		int printPosion = -1;
		int dx = x, dy = y;
		switch(move) {
		case 1: // move east
			dx += 1;
			if(dx >= M) printPosion = -1;
			else {
				x++;
				int tmp = 0;
				if(map[y][x] == 0) tmp = dice[2];
				else tmp = map[y][x];
				
				dice[2] = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = tmp;
				
				if(map[y][x] != 0) map[y][x] = 0;
				else map[y][x] = tmp;
				printPosion = 1;
			}
			break;
		case 2: // move west
			dx -= 1;
			if(dx < 0) printPosion = -1;
			else {
				x--;
				int tmp = 0;
				if(map[y][x] == 0) tmp = dice[3];
				else tmp = map[y][x];
				
				dice[3] = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = tmp;
				if(map[y][x] != 0) map[y][x] = 0;
				else map[y][x] = tmp;
				printPosion = 1;
			}
			break;
		case 3: // move north
			dy -= 1;
			if(dy < 0) printPosion = -1;
			else {
				y--;
				
				int tmp = 0;
				if(map[y][x] == 0) tmp = dice[1];
				else tmp = map[y][x];
				
				dice[1] = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = tmp;
				if(map[y][x] != 0) map[y][x] = 0;
				else map[y][x] = tmp;
				printPosion = 1;
			}
			break;
		case 4: // move south
			dy += 1;
			if(dy >= N) printPosion = -1;
			else {
				y++;
				
				int tmp = 0;
				if(map[y][x] == 0) tmp = dice[4];
				else tmp = map[y][x];
				
				dice[4] = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = tmp;
				if(map[y][x] != 0) map[y][x] = 0;
				else map[y][x] = tmp;
				printPosion = 1;
			}
			break;
		}
		if(printPosion != -1) {
			System.out.println(dice[0]);
		}
	}
}
