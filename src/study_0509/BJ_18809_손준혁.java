package study_0509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18809_손준혁 {
	static int N,M,G,R,flower = 0;
	static int[][] map, spread; // 0 : 호수, 1 : 배양액 땅, 2 : 일반 땅, 3 : 꽃 | 1 : green, 2: red
	static ArrayList<Land> landList = new ArrayList<>();
	static ArrayList<Land> greenList = new ArrayList<>();
	static ArrayList<Land> redList = new ArrayList<>();
	
	static int[] tgtList, tgtList2;
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		spread = new int[N][M];
		tgtList = new int[G+R];
		tgtList2 = new int[G+R];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) landList.add(new Land(j,i));
			}
		}
		comb(0,0);
		System.out.println(flower);
	}
	static void comb(int src, int tgt) {
		if(tgt == G+R) {
			comb_RG(0,0);
			return;
		}
		for (int i = src; i < landList.size(); i++) {
			tgtList[tgt]  = i;
			comb(i+1, tgt+1);
		}
	}
	static void comb_RG(int src, int tgt) {
		if(tgt == G) {
			boolean[] greenlist = new boolean[G+R];
			for (int i = 0; i < tgtList2.length; i++) {
				greenlist[tgtList2[i]] = true;
			}
			for (int i = 0; i < tgtList.length; i++) {
				if(greenlist[i]) {
					greenList.add(landList.get(i));
				}
				else {
					redList.add(landList.get(i));
				}
			}
			BFS();
			greenList.clear();
			redList.clear();
			tgtList = new int[G+R];
			tgtList2 = new int[G+R];
			return;
		}
		for (int i = 0; i < tgtList.length; i++) {
			tgtList2[tgt] = i;
			comb_RG(i+1, tgt+1);
		}
	}
	static void BFS() {
		Queue<Land> greenlist = new LinkedList<>();
		Queue<Land> redlist = new LinkedList<>();
		int flower_tmp = 0;
		int[][] tmp_map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp_map[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < greenList.size(); i++) {
			greenlist.offer(greenList.get(i));
		}
		for (int i = 0; i < redList.size(); i++) {
			redlist.offer(redList.get(i));
		}
		
		while(!greenlist.isEmpty() || !redlist.isEmpty()) {
			int greenSize = greenlist.size();
			int redSize = redlist.size();
			for (int i = 0; i < greenSize; i++) {
				Land green = greenlist.poll();
				for (int d = 0; d < 4; d++) {
					int dx = green.x + delta_x[d];
					int dy = green.y + delta_y[d];
					
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(tmp_map[dy][dx] == 0 || tmp_map[dy][dx] == 3) continue;
					if(spread[dy][dx] != 0) continue;
					spread[dy][dx] = 1;
					greenlist.offer(new Land(dx,dy));
				}
			}
			for (int i = 0; i < redSize; i++) {
				Land red = redlist.poll();
				for (int d = 0; d < 4; d++) {
					int dx = red.x + delta_x[d];
					int dy = red.y + delta_y[d];
					
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(tmp_map[dy][dx] == 0 || tmp_map[dy][dx] == 3) continue;
					if(spread[dy][dx] == 1 && tmp_map[dy][dx] == 0) {
						tmp_map[dy][dx] = 3;
						flower_tmp++;
					}
					else if(spread[dy][dx] != 0) continue;
					else{
						spread[dy][dx] = 1;
						redlist.offer(new Land(dx,dy));
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmp_map[i][j] == 2) continue;
					tmp_map[i][j] = spread[i][j];
				}
			}
		}
		flower = Math.max(flower_tmp, flower);
	}
	
	static class Land{
		int x;
		int y;
		public Land() {}
		public Land(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
