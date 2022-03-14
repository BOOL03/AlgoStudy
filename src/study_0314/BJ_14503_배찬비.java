package study_0314;
import java.io.*;
import java.util.*;

public class BJ_14503_배찬비 {
	
	static int n, m, answer, px, py, pd;
	static int[][] area;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		px = Integer.parseInt(st.nextToken());
		py = Integer.parseInt(st.nextToken());
		pd = Integer.parseInt(st.nextToken());
		area = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			// 1. 현재 위치를 청소한다.
			if(area[px][py]==0) {
				answer++;
				area[px][py] = 2;
			}
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
			boolean flag = false;
			for(int i=0; i<4; i++) {
				pd = pd==0?3:pd-1;
				int xx = px+dx[pd];
				int yy = py+dy[pd];
				if(area[xx][yy]==0) {
					px = xx;
					py = yy;
					flag = true;
					break;
				}
			}
			if(!flag) {
				if(area[px-dx[pd]][py-dy[pd]]==1) break;
				px -= dx[pd];
				py -= dy[pd];
			}
		}
		
		System.out.println(answer);
		
	}

}
