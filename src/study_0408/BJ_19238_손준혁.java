package study_0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238_손준혁 {
	static int N,M,K;
	static int[] taxi = new int[2];
	static int[][] map;
	static boolean[][] visited;
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		//visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken())-1;
		int x = Integer.parseInt(st.nextToken())-1;
		//map[y][x] = 2;
		taxi[0] = y;
		taxi[1] = x;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp_y = Integer.parseInt(st.nextToken())-1;
			int tmp_x = Integer.parseInt(st.nextToken())-1;
			map[tmp_y][tmp_x] = (i+1)*10;
			tmp_y = Integer.parseInt(st.nextToken())-1;
			tmp_x = Integer.parseInt(st.nextToken())-1;
			map[tmp_y][tmp_x] = (i+1)*10+1;
		}
		for (int i = 0; i < M; i++) {
			visited = new boolean[N][N];
			int[] result = findCustormer(taxi[1], taxi[0]);
			if(result == null) {
				System.out.println(-1);
				return;
			}
			System.out.println("findCustormer is finished : "+result[0]+","+result[1]+" | " + result[2]);
			visited = new boolean[N][N];
			//map[result[0]][result[1]] = 0;
			int goal = map[result[0]][result[1]]+1;
			System.out.println("goal : " + goal);
			map[result[0]][result[1]] = 0;
			int distance = findplace(result[1], result[0], goal);
			//System.out.println("findplce is finished : ");
			K -= (distance + result[2]);
			if(K < 0) {
				System.out.println(-1);
				return ;
			}
			K += distance*2;
			
		}
		System.out.println(K);
	}
	static int[] findCustormer(int x, int y) {
		Queue<int[]> list= new LinkedList<>();
		list.offer(new int[] {y,x});
		int count = 0;
		while(true) {
			int size = list.size();
			if(size == 0 ) {
				return null;
			}
			count++;
			for (int i = 0; i < size; i++) {
				//count++;
				int[] tmps = list.poll();
				int[] tmps_custormer = new int[2];
				boolean check = false;
				for (int d = 0; d < 4; d++) {
					int dx = tmps[1] + delta_x[d];
					int dy = tmps[0] + delta_y[d];
					if(dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dy][dx] || map[dy][dx] == 1) continue;
					visited[dy][dx] = true;
					if(map[dy][dx] > 1 && (map[dy][dx] & 1) == 0) {
						if(check) {
							if(dy < tmps_custormer[0]) {
								tmps_custormer[0] = dy;
								tmps_custormer[0] = dx;	
								//total_count = count;
							}
							else if(dy == tmps_custormer[0]) {
								if(dx < tmps_custormer[1]) {
									tmps_custormer[0] = dy;
									tmps_custormer[0] = dx;
									//total_count = count;
								}
							}
						}
						else {
							check = true;
							tmps_custormer[0] = dy;
							tmps_custormer[1] = dx;
							//total_count = count;
						}
					}
					else list.offer(new int[] {dy,dx});
				}
				if(check) {
					return new int[] {tmps_custormer[0],tmps_custormer[1],count};
				}
				
			}
		}
		//return true;
	}

	static int findplace(int x, int y, int goal) {
		Queue<int[]> list = new LinkedList<>();
		list.offer(new int[] {y,x});
		int count = 0;
		while(true) {
			int size = list.size();
			count++;
			for (int i = 0; i < size; i++) {
				//count++;
				int[] tmps = list.poll();
				for (int d = 0; d < 4; d++) {
					int dx = tmps[1] + delta_x[d];
					int dy = tmps[0] + delta_y[d];
					if(dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dy][dx]) continue;
					visited[dy][dx] = true;
					if(map[dy][dx] == goal) {
						taxi[0] = dy;
						taxi[1] = dx;
						map[dy][dx] = 0;
						System.out.println("findplcae : " + dy+","+dx);
						return count;
					}
					list.offer(new int[] {dy, dx});
				}
			}
		}
	}
}

