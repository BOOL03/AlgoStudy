package study_0511;
import java.io.*;
import java.util.*;

public class BJ_1525_배찬비 {
	
	static char[][] puzzle = new char[3][3];
	static int[][] success = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer = Integer.MAX_VALUE;
	static Set<String> visited = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = 0, y = 0;
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				puzzle[i][j] = st.nextToken().charAt(0);
				if(puzzle[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}

		System.out.println(bfs(x, y));
	}
	
	static int bfs(int x, int y) {
		Queue<Data> Q = new ArrayDeque<>();
		char[][] tp = new char[3][3];
		copyArray(tp, puzzle);
		Q.offer(new Data(tp, 0, x, y));
		visited.add(trans(tp));
		
		while(!Q.isEmpty()) {
			Data d = Q.poll();
			String str = trans(d.p);
			if(str.equals("123456780")) {
				return d.cnt;
			}
			for(int i=0; i<4; i++) {
				int xx = d.x+dx[i];
				int yy = d.y+dy[i];
				if(xx<0 || xx>=3 || yy<0 || yy>=3) continue;
				char[][] p = new char[3][3];
				copyArray(p, d.p);
				swap(p, d.x, d.y, xx, yy);
				String tstr = trans(p);
				if(!visited.contains(tstr)) {
					visited.add(tstr);
					Q.offer(new Data(p, d.cnt+1, xx, yy));
				}
			}
		}
		
		return -1;
	}
	
	static String trans(char[][] p) {
		return String.valueOf(p[0])+String.valueOf(p[1])+String.valueOf(p[2]);
	}
	
	static void swap(char[][] p, int x1, int y1, int x2, int y2) {
		char tmp = p[x1][y1];
		p[x1][y1] = p[x2][y2];
		p[x2][y2] = tmp;
	}
	
	static char[][] copyArray(char[][] p1, char[][] p2){
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				p1[i][j] = p2[i][j];
			}
		}
		return p1;
	}
	
	static class Data{
		char[][] p;
		int cnt, x, y;
		Data(char[][] p , int cnt, int x, int y){
			this.p = p;
			this.cnt = cnt;
			this.x = x;
			this.y = y;
		}
	}
}
