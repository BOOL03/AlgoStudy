package study_0318;
import java.io.*;
import java.util.*;

public class BJ_17837_배찬비 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n, k;
	static int[][] color;
	static Player[] player;
	static ArrayList<Integer>[][] chess;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		color = new int[n][n];
		player = new Player[k];
		chess = new ArrayList[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				chess[i][j] = new ArrayList<Integer>();
			}
		}
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			player[i] = new Player(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
			chess[player[i].x][player[i].y].add(i);
		}
		
		for(int i=1; i<=1000; i++) {
			int result = move();
			if(result==1) {
				System.out.println(i);
				return;
			} else if(result==2) {
				System.out.println("-1");
				return;
			}
		}
		
		System.out.println("-1");
	}
	
	static int move() {
		int cnt = 0;
		
		for(int i=0; i<k; i++) {
			int x = player[i].x;  // 현재 
			int y = player[i].y; 
			int d = player[i].d;
			int num = player[i].num;
			
			int xx = x+dx[d];  // 다음 
			int yy = y+dy[d];
			
			if(xx<0 || xx>=n || yy<0 || yy>=n || color[xx][yy]==2) {  // 체스판을 넘어가거나 파란색인 경우 
				if(d==1) d=0;
				else if(d==0) d=1;
				else if(d==2) d=3;
				else d=2;
				player[i].d = d;
				xx = x+dx[d]; 
				yy = y+dy[d];
				if(xx<0 || xx>=n || yy<0 || yy>=n || color[xx][yy]==2) {  //앞뒤로 다 못움직이니까 앞으로도 못움직임 
					cnt++;
				} else if(color[xx][yy]==0) {
					if(white(xx, yy, i)) return 1;
				} else {
					if(red(xx, yy, i)) return 1;
				}
				
			} else if(color[xx][yy]==0) {  //흰색인 경우 
				if(white(xx, yy, i)) return 1;
			} else { //빨간색인 경우 
				if(red(xx, yy, i)) return 1;
			}
		}
		
		if(cnt==k) return 2;
		return 0;
	}
	
	static boolean white(int xx, int yy, int seq) {
		int x = player[seq].x;
		int y = player[seq].y;
		int index = chess[xx][yy].size();
		int s = player[seq].num;
		int e = chess[x][y].size();
		
		for(int i=s; i<e; i++) {
			int tmp = chess[x][y].get(i);
			chess[xx][yy].add(tmp);
			player[tmp].num = index++;
			player[tmp].x = xx;
			player[tmp].y = yy;
		}
		for(int i=s; i<e; i++) {
			chess[x][y].remove(chess[x][y].size()-1);
		}
		if(chess[xx][yy].size()>=4) return true;
		return false;
	}
	
	static boolean red(int xx, int yy, int seq) {
		int x = player[seq].x;
		int y = player[seq].y;
		int index = chess[xx][yy].size();
		int s = chess[x][y].size()-1;
		int e = player[seq].num;
		
		for(int i=s; i>=e; i--) {
			int tmp = chess[x][y].get(i);
			chess[xx][yy].add(tmp);
			player[tmp].num = index++;
			player[tmp].x = xx;
			player[tmp].y = yy;
		}
		for(int i=s; i>=e; i--) {
			chess[x][y].remove(chess[x][y].size()-1);
		}
		if(chess[xx][yy].size()>=4) return true;
		return false;
	}

	static class Player{
		int x, y, d, num;
		public Player(int x, int y, int d, int num) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.num = num;
		}	
	}
}
