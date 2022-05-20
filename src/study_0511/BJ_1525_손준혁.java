package study_0511;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1525_손준혁 {
	static int Count = -1;
	static int[] arr = {1,2,3,4,5,6,7,8,0};
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Count);
	}
	static void BFS(int[][] map, int x, int y) {
		Queue<Point> list = new LinkedList<>();
		list.offer(new Point(x,y, new Point(x,y)));
		while(list.isEmpty()) {
			int size = list.size();
			Point p = list.poll();
			for (int d = 0; d < size; d++) {
				int dx = delta_x[d] + p.x;
				int dy = delta_y[d] + p.y;
				if(dx < 0 || dx >= 3 || dy < 0 || dy >= 3) continue;
				Point p_save = p.save;
				if(p_save.x == dx && p_save.y == dy) continue;
				list.offer(new Point(dx,dy,new Point(p.x,p.y)));
				
			}
		}
	
	}
	static boolean Check(int[][] map) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(map[i][j] != arr[i*3+j]) return false;
			}
		}
		return true;
	}
	static class Point{
		int x;
		int y;
		Point save;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, Point save) {
			this.x = x;
			this.y = y;
			this.save = save;
		}
	}
}
