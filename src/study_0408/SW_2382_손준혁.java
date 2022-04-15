package study_0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2382_손준혁 {
	static int N,M,K;
	static int[][] map,copy_map;
	static List<bacteria> bacterias;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			bacterias = new ArrayList<>();
			bacterias.add(new bacteria(0,0,0,0));
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				bacterias.add(new bacteria(x,y,c,dir));
				//map[y][x] = k;
			}
			
			for (int m = 0; m < M; m++) {
				time();
				map = new int[N][N];
			}
			int sum = 0;
			for (int i = 0; i < bacterias.size(); i++) {
				sum += bacterias.get(i).c;
			}
			System.out.println("#"+(t+1)+" "+sum);
		}
	}
	static void time() {
		for (int i = 1; i < bacterias.size(); i++) {
			bacteria bac = bacterias.get(i);
			int x = bac.x;
			int y = bac.y;
			//map[y][x] = 0;
			switch(bac.dir) {
			case 1: // up
				y--;
				break;
			case 2: // down
				y++;
				break;
			case 3: // left
				x--;
				break;
			case 4: // right
				x++;
				break;
			}
			
			if(x == 0 || x == N-1 || y == 0 || y == N-1) { // side of map
				map[y][x] = i;
				bacterias.get(i).c = bac.c/2;
				bacterias.get(i).x = x;
				bacterias.get(i).y = y;
				if((bac.dir & 1) == 1) {
					bacterias.get(i).dir++;
				}
				else {
					bacterias.get(i).dir--;
				}
				continue;
			}
			int count = map[y][x];
			if(count > 0) {
				bacteria bac_before = bacterias.get(count);
				if(bac_before.c > bac.c) {
					bacterias.get(count).c += bac.c;
					bacterias.remove(i);
					minCount(i);
					i--;
				}
				else {
					map[y][x] = i;
					bacterias.get(i).c += bac_before.c;
					bacterias.get(i).x = x;
					bacterias.get(i).y = y;
					bacterias.remove(count);
					minCount(count);
					i--;
				}
			}
			else {
				map[y][x] = i;
				bacterias.get(i).x = x;
				bacterias.get(i).y = y;
			}
		}
	}
	static void minCount(int I) {
		for (int i = I; i < bacterias.size(); i++) {
			bacteria bac = bacterias.get(i);
			if(map[bac.y][bac.x] > 0) map[bac.y][bac.x]--;
		}
	}
	static class bacteria{
		int x;
		int y;
		int c;
		int dir;
		public bacteria(int x, int y, int c, int dir) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.dir = dir;
		}
	}
}
