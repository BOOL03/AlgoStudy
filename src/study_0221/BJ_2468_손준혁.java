package study_0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_손준혁 {
	static int count = 0, N;
	static int[][] map;
	static boolean[][] underWater, visited; 
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		underWater = new boolean[N][N];
		visited = new boolean[N][N];
		
		int height_tmp = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(height_tmp < map[i][j]) height_tmp=map[i][j];
			}
		}
		search(height_tmp);
		System.out.println(count);
	}
	static int dfs(int x, int y, int height) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +delta_x[i];
			int ny = y +delta_y[i];
			
			if(nx<0 || ny<0 || nx>N-1 || ny >N-1) continue;
			if(visited[nx][ny]) continue;
			if(map[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		return 1;
	}
	
	static void search(int maxHeight) {
		for(int height=0; height<=maxHeight; height++) {
			visited = new boolean[N][N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j] > height){
						cnt+=dfs(i,j,height);
					}
					
				}
			}
			count = Math.max(count, cnt);
		}
	}
}
