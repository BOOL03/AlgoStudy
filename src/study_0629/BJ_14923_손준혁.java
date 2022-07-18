package study_0629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14923_손준혁 {
	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] map, root;
	
	static Queue<Point> list = new LinkedList<>();
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken());
        Hy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        root = new int[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        root[Hy][Hx] = -1;
        list.offer(new Point(Hx, Hy));
	}

	static void BFS() {
		int count = 1;
		while(!list.isEmpty()) {
			Point p = list.poll();
			for (int d = 0; d < 4; d++) {
				int dx = p.x + delta_x[d];
				int dy = p.y + delta_y[d];
				
				if(dx <= 0 || dx > M || dy <= 0 || dy > N) continue;
				if(map[dy][dx] == 1) continue;
				if(root[dy][dx] != 0) continue;
				
			}
		}
	}
	static class Point{
		int x;
		int y;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
