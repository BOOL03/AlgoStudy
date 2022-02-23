package study_0223;
import java.io.*;
import java.util.*;

public class BJ_2304_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pos[] col = new Pos[n];
		Pos high = new Pos(0, 0);
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			col[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			if(col[i].y>high.y) {
				high = col[i];
			}
		}
		Arrays.sort(col, (c1, c2)->c1.x-c2.x);
		
		int answer = 0;
		int sx = 0;
		int sy = 0;
		for(int i=0; i<n; i++) {
			if(col[i].y>=sy) {
				answer += (col[i].x-sx)*sy;
				sx = col[i].x;
				sy = col[i].y;
			}
			if(col[i] == high) break;
		}
		sx = 1000;
		sy = 0;
		for(int i=n-1; i>=0; i--) {
			if(col[i].y>=sy) {
				answer += (sx-col[i].x)*sy;
				sx = col[i].x;
				sy = col[i].y;
			}
			if(col[i] == high) break;
		}
		answer += high.y;
		
		System.out.println(answer);
	}
	
	static class Pos{
		int x, y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

