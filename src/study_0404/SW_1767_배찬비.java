package study_0404;
import java.io.*;
import java.util.*;

public class SW_1767_배찬비 {
	
	static int n, maxCell, minLine;
	static int[][] arr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static ArrayList<int[]> cell;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			cell = new ArrayList<>();
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						if(i==0 || i==n-1 || j==0 || j==n-1) cnt++;
						else cell.add(new int[] {i, j});
					}
				}
			}
			
			maxCell = cnt;
			minLine = Integer.MAX_VALUE;
			if(!cell.isEmpty()) dfs(0, 0, cnt);
			
			sb.append("#"+t+" "+minLine+"\n");
		}
		
		System.out.println(sb.toString());
	}

	static void dfs(int index, int line, int cnt) {
		if(index==cell.size()) {
			if(cnt>maxCell) {
				minLine = line;
				maxCell = cnt;
			}
			else if(cnt==maxCell) minLine = Math.min(line, minLine);
			return;
		}
		for(int i=0; i<4; i++) {
			int x = cell.get(index)[0];
			int y = cell.get(index)[1];
			int l = 0;
			while(true) {
				x+=dx[i];
				y+=dy[i];
				if(x==-1 || x==n || y==-1 || y==n) {
					dfs(index+1, line+l, cnt+1);
					while(true) {
						x-=dx[i];
						y-=dy[i];
						if(x==cell.get(index)[0] && y==cell.get(index)[1]) break;
						arr[x][y] = 0;
					}
					break;
				}
				if(arr[x][y]==1) {
					while(true) {
						x-=dx[i];
						y-=dy[i];
						if(x==cell.get(index)[0] && y==cell.get(index)[1]) break;
						arr[x][y] = 0;
					}
					break;
				}
				arr[x][y] = 1;
				l++;
			}
		}
		dfs(index+1, line, cnt);
	}
	
}
