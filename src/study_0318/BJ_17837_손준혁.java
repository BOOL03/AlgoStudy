package study_0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17837_손준혁 {
	static int N, K,clash = 0;
	static int[][][] map; // y, x, clash order
	static Piece[] pieces;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N][K+1];
		pieces = new Piece[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			//map[y][x][i+1] = dir;
			pieces[i] = new Piece(x,y,dir);
		}
		for (int i = 0; i < K; i++) {
			for (int j = 1; j <= K; j++) {
				if(map[pieces[i].y][pieces[i].x][j] != 0) continue;
				map[pieces[i].y][pieces[i].x][j] = i+1;
				break;
			}
		}
		calc();
		System.out.println(clash);
	}
	static void calc() {
		int count = 0;
		while(true) {
			if(count >= 1000) {
				clash = -1;
				break;
			}
			count++;
			for (int i = 0; i < K; i++) {
				int x = pieces[i].x, y = pieces[i].y;
				switch(pieces[i].dir) {
				case 1: // right
					x++;
					break;
				case 2: // left
					x--;
					break;
				case 3: // up
					y--;
					break;
				case 4: // down
					y++;
					break;
				}
				int color = -1;
				if(x < 0 || x >= N || y < 0 || y >= N) color = 2;
				else color = map[y][x][0];
				switch(color) {
				case 0: // white
					for (int origin = 1; origin <= K; origin++) {
						if(map[pieces[i].y][pieces[i].x][origin] == 0) break;
						for (int copy = 1; copy < K; copy++) {
							if(map[y][x][copy] != 0) continue;
							map[y][x][copy] = map[pieces[i].y][pieces[i].x][origin];
							map[pieces[i].y][pieces[i].x][origin] = 0;
							break;
						}
					}
					for (int replace = 1; replace <= K; replace++) {
						if(map[y][x][replace] == 0) continue;
						int tmp = map[y][x][replace]-1;
						pieces[tmp].y = y;
						pieces[tmp].x = x;
					}
					break;
				case 1: // red
					for (int origin = K; origin > 0; origin--) {
						if(map[pieces[i].y][pieces[i].x][origin] == 0) break;
						for (int copy = 1; copy < K; copy++) {
							if(map[y][x][copy] != 0) continue;
							map[y][x][copy] = map[pieces[i].y][pieces[i].x][origin];
							map[pieces[i].y][pieces[i].x][origin] = 0;
							break;
						}
					}
					for (int replace = 1; replace <= K; replace++) {
						if(map[y][x][replace] == 0) continue;
						int tmp = map[y][x][replace];
						pieces[tmp].y = y;
						pieces[tmp].x = x;
					}
					break;
				case 2: // blue
					// check back block
					/*
					 * 
					 * 
					 * 
					 * */
					for (int origin = 0; origin < K; origin++) {
						if(pieces[origin].dir % 2 == 1) pieces[origin].dir++;
						else pieces[origin].dir--;
					}
					break;
				}
			}
			check();
			if(clash == K) break;
		}
	}
	static void check() {
		for (int i = 0; i < K; i++) {
			int sum = 1;
			for (int j = i; j < K; j++) {
				if(pieces[i].x == pieces[j].x && pieces[i].y == pieces[j].y) {
					sum++;
				}
			}
			clash = Math.max(clash, sum);
		}
	}
	static class Piece{
		int x;
		int y;
		int dir;
		public Piece(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

}
