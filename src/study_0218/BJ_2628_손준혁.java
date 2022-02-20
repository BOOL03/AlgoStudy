package study_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2628_손준혁 {
	static int N, M, MaxCount = 0;
	
	static Queue<Paper> papers = new LinkedList<Paper>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		papers.add(new Paper(0,N,0,M));
		
		int repeat = Integer.parseInt(br.readLine());
		for (int i = 0; i < repeat; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			
			divide(direction, point);
		}
		while(!papers.isEmpty()) {
			Paper p = papers.poll();
			int size = (p.x_right - p.x_left) * (p.y_bottom - p.y_top);
			if(size > MaxCount) MaxCount = size;
		}
		System.out.println(MaxCount);
	}
	static void divide(int dir, int point) {
		int count_papers = papers.size();
		while(count_papers > 0) {
			Paper p = papers.poll();
			if(dir == 0) {// 가로로 자름
				if(p.y_top > point || p.y_bottom < point) papers.add(p);
				else {
					papers.add(new Paper(p.x_left, p.x_right, p.y_top, point));
					papers.add(new Paper(p.x_left, p.x_right, point, p.y_bottom));
				}
			} else { // 세로로 자름
				if(p.x_right < point || p.x_left > point) papers.add(p);
				else {
					papers.add(new Paper(p.x_left, point, p.y_top, p.y_bottom));
					papers.add(new Paper(point, p.x_right, p.y_top, p.y_bottom));
				}
			}
			count_papers--;
		}
	}
	static class Paper{
		int x_left;
		int x_right;
		int y_top;
		int y_bottom;
		public Paper() {}
		public Paper(int x_l, int x_r, int y_top, int y_bottom) {
			this.x_left = x_l;
			this.x_right = x_r;
			this.y_top = y_top;
			this.y_bottom = y_bottom;
		}
	}
}
