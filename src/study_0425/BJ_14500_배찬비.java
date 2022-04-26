package study_0425;
import java.util.*;
import java.io.*;

public class BJ_14500_배찬비 {

	static int n, m, answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
				check(i, j);
			}
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int cnt, int sum) {
		if(cnt==4) {
			answer = Math.max(sum, answer);
			return;
		}
		for(int i=0; i<4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<0 || xx>=n || yy<0 || yy>=m || visited[xx][yy]) continue;
			visited[xx][yy] = true;
			dfs(xx, yy, cnt+1, sum+arr[xx][yy]);
			visited[xx][yy] = false;
		}
	}
	
	static void check(int x, int y) {  // ㅗ ㅜ ㅓ ㅏ 모양 체크 
		if(x>0 && x<n-1) {
			if(y>0) answer = Math.max(answer, arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y-1]);
			if(y<m-1) answer = Math.max(answer, arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y+1]);
		}
		if(y>0 && y<m-1) {
			if(x>0) answer = Math.max(answer, arr[x][y] + arr[x][y-1] + arr[x][y+1] + arr[x-1][y]);
			if(x<n-1) answer = Math.max(answer, arr[x][y] + arr[x][y-1] + arr[x][y+1] + arr[x+1][y]);
		}
	}
}
