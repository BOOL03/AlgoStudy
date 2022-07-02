package study_0629;
import java.io.*;
import java.util.*;

public class BJ_24513_배찬비 {
	
	static int n, m;
	static int[] answer = new int[4];
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] visited;
	static Queue<Node> Q = new ArrayDeque<>();
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					Q.offer(new Node(i, j, 1, 1));
					visited[i][j] = 1;
					answer[1]++;
				} else if(arr[i][j]==2) {
					Q.offer(new Node(i, j, 2, 1));
					visited[i][j] = 1;
					answer[2]++;
				}
			}
		}
		
		bfs();
		System.out.println(answer[1]+" "+answer[2]+" "+answer[3]);
		
	}
	
	static int bfs() {
		
		while(!Q.isEmpty()) {
			Node tmp = Q.poll();
			if(arr[tmp.x][tmp.y]==3) continue;
			
			for(int i=0; i<4; i++) {
				int xx = tmp.x + dx[i];
				int yy = tmp.y + dy[i];
				
				if(xx<0 || xx>=n || yy<0 || yy>=m || arr[xx][yy]==-1) continue;
				if(tmp.num==1 && arr[xx][yy]==2 && visited[xx][yy]==tmp.time+1) {
					arr[xx][yy] = 3;
					answer[3]++;
					answer[2]--;
				} else if(tmp.num==2 && arr[xx][yy]==1 && visited[xx][yy]==tmp.time+1) {
					arr[xx][yy] = 3;
					answer[3]++;
					answer[1]--;
				} else if(arr[xx][yy]==0) {
					Q.offer(new Node(xx, yy, tmp.num, tmp.time+1));
					arr[xx][yy] = tmp.num;
					visited[xx][yy] = tmp.time+1;
					answer[tmp.num]++;
				}
			}
		}
		
		return -1;
	}
	
	static class Node{
		int x, y, num, time;
		Node(int x, int y, int num, int time){
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
	}
	

}
