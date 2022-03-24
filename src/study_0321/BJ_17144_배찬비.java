package study_0321;
import java.io.*;
import java.util.*;

public class BJ_17144_배찬비 {
	
	static int r, c, T;
	static int[][] room;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Machine m = new Machine(-1, -1, -1, -1);
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[r][c];
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					if(m.x1==-1) {
						m.x1 = i;
						m.y1 = j;
					} else {
						m.x2 = i;
						m.y2 = j;
					}
				}
			}
		}
		
		for(int t=1; t<=T; t++) {
			step1();
			step2();
		}
		
		int answer = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				answer += room[i][j];
			}
		}
		System.out.println(answer+2);
		
	}
	
	static void step1() {
		int[][] room2 = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(room[i][j]!=0) {
					int dust = room[i][j]/5;
					for(int k=0; k<4; k++) {
						int x = i+dx[k];
						int y = j+dy[k];
						if(x<0 || x>=r || y<0 || y>=c || room[x][y]==-1) continue;
						room2[x][y] += dust;
						room[i][j] -= dust;
					}
					room2[i][j] += room[i][j];
				}
			}
		}
		room = room2;
	}
	
	static void step2() {
		for(int i=m.x1-1; i>0; i--) room[i][0] = room[i-1][0];
		for(int i=1; i<c; i++) room[0][i-1] = room[0][i];
		for(int i=1; i<=m.x1; i++) room[i-1][c-1] = room[i][c-1];
		for(int i=c-1; i>0; i--) room[m.x1][i] = room[m.x1][i-1];
		room[m.x1][1] = 0;
		
		for(int i=m.x2+2; i<r; i++) room[i-1][0] = room[i][0];
		for(int i=1; i<c; i++) room[r-1][i-1] = room[r-1][i];
		for(int i=r-1; i>m.x2; i--) room[i][c-1] = room[i-1][c-1];
		for(int i=c-1; i>0; i--) room[m.x2][i] = room[m.x2][i-1];
		room[m.x2][1] = 0;
	}
	
	static class Machine{
		int x1, y1, x2, y2;
		public Machine(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
