package study_0408;
import java.io.*;
import java.util.*;

public class SW_2382_배찬비 {
	
	static int n, m, k;
	static Cell[][] cell;
	static Queue<Node> Q = new ArrayDeque<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Q.offer(new Node(x, y, num, d-1));
			}
			
			move();
			int answer = 0;
			while(!Q.isEmpty()) {
				answer += Q.poll().num;
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void move() {
		for(int i=0; i<m; i++) {
			cell = new Cell[n][n];
			int s = Q.size();
			for(int j=0; j<s; j++) {
				Node tmp = Q.poll();
				int d = tmp.d;
				int x = tmp.x+dx[d];
				int y = tmp.y+dy[d];
				if(cell[x][y]==null) {
					cell[x][y] = new Cell(tmp.num, d, tmp.num);
				} else {
					if(cell[x][y].max<tmp.num) {
						cell[x][y] = new Cell(tmp.num, d, tmp.num+cell[x][y].sum);
					}
					else cell[x][y].sum += tmp.num;
				}
				Q.offer(new Node(x, y, cell[x][y].sum, cell[x][y].d));
			}
			
			for(int j=0; j<s; j++) {
				Node tmp = Q.poll();
				int d = tmp.d;
				int x = tmp.x;
				int y = tmp.y;
				int num = tmp.num;
				if(cell[x][y].sum != num) continue;
				if(x==0 || x==n-1 || y==0 || y==n-1) {
					num /=2;
					if(d==0) d=1;
					else if(d==1) d=0;
					else if(d==2) d=3;
					else d=2;
				}
				Q.offer(new Node(x, y, num, d));
			}
		}
	}
	
	
	static class Node{
		int x, y, num, d; // 위치, 개수, 방향
		public Node(int x, int y, int num, int d) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.d = d;
		}
		
	}
	
	static class Cell{
		int max, d, sum; // 젤 많은 값, 방향, 더한 값 
		public Cell(int max, int d, int sum) {
			this.max = max;
			this.d = d;
			this.sum = sum;
		}
		
	}
	
}
