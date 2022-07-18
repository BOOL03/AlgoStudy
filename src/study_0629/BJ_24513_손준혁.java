package study_0629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_24513_손준혁 {
	static int N, M, time = 0;
	static int[][][] viliage;
	static int[] viruses = new int[3];
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	
	static Queue<House> virus1 = new LinkedList<>();
	static Queue<House> virus2 = new LinkedList<>();
	
	static Queue<House> virus1Root = new LinkedList<>();
	static Queue<House> virus2Root = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        viliage = new int[N][M][2];
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				viliage[i][j][0] = Integer.parseInt(st.nextToken());
				if(viliage[i][j][0] == 1) {
					viruses[0] = 1;
					virus1.offer(new House(j,i));
				}
				else if(viliage[i][j][0] == 2) {
					viruses[1] = 1;
					virus2.offer(new House(j,i));
				}
			}
		}
        BFS(1,1);
	}
	static void BFS(int countA, int countB) {
		int count1 = countA, count2 = countB;
		while(count1+count2 != 0) {
			count1 = SpreadVirusA(count1);
			count2 = SpreadVirusB(count2);
			time++;
		}
		System.out.println(viruses[0]+" "+viruses[1]+" "+viruses[2]+" ");
	}

	static int SpreadVirusA(int repeat) {
		int count = 0;
		for (int i = 0; i < repeat; i++) {
			if(!virus1.isEmpty()) {
				House house = virus1.poll();
				if(viliage[house.y][house.x][0] == 3) continue;
				for (int d = 0; d < 4; d++) {
					int dx = house.x + delta_x[d];
					int dy = house.y + delta_y[d];
					
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(viliage[dy][dx][0] == -1 || viliage[dy][dx][0] == 1 || viliage[dy][dx][0] == 3) continue;
					if(viliage[dy][dx][0] == 0) {
						viliage[dy][dx][0] = 1;
						viliage[dy][dx][1] = time;
						viruses[0]++;
						virus1.offer(new House(dx, dy));
						count++;
					}
				}
			}
			else break;
		}
		return count;
		
	}
	static int SpreadVirusB(int repeat) {
		int count = 0;
		for (int i = 0; i < repeat; i++) {
			if(!virus2.isEmpty()) {
				House house = virus2.poll();
				if(viliage[house.y][house.x][0] == 3) continue;
				for (int d = 0; d < 4; d++) {
					int dx = house.x + delta_x[d];
					int dy = house.y + delta_y[d];
					
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(viliage[dy][dx][0] == -1 || viliage[dy][dx][0] == 2 || viliage[dy][dx][0] == 3) continue;
					if(viliage[dy][dx][0] == 0) {
						viliage[dy][dx][0] = 2;
						viliage[dy][dx][1] = time;
						viruses[1]++;
						virus2.offer(new House(dx, dy));
						count++;
					}
					else if(viliage[dy][dx][0] == 1 && viliage[dy][dx][1] == time) {
						viliage[dy][dx][0] = 3;
						viruses[0]--;
						viruses[2]++;
					}
				}
			}
			else break;
		}
		return count;
	}
	static class House{
		int x;
		int y;
		public House() {}
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
