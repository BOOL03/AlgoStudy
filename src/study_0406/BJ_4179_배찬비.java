package study_0406;
import java.io.*;
import java.util.*;

public class BJ_4179_배찬비{
	
	static int r, c, t; //t는 현재 시간 
	static char[][] miro;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static Queue<int[]> FQ = new ArrayDeque<>();  // 불이 번지는 위치들 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		miro = new char[r][c];
		visited = new boolean[r][c];
		
		int x = 0, y = 0; // 지훈이 처음 위치 
		for(int i=0; i<r; i++) {
			miro[i] = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				if(miro[i][j]=='J') { // 지훈이 위치 
					x = i; y = j;
				} else if(miro[i][j]=='F') { // 불 위치 
					FQ.offer(new int[] {i, j, 0});
				}
			}
		}
		
		int answer = bfs(x, y);
		if(answer == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(answer+1);
	}
	
	static int bfs(int x, int y) {

		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while(!Q.isEmpty()) {
			int[] tmp = Q.poll();
			if(tmp[2]!=t) t++;  // 현재 시간과 지훈이의 시간이 일치 하지 않는다는 것은 1분동안 이동을 끝냈다는 것이므로 1분 추가 
			if(!FQ.isEmpty() && FQ.peek()[2]== t) fire();  // 1분뒤에 불번짐 
			for(int i=0; i<4; i++) {
				int xx = tmp[0] + dx[i];
				int yy = tmp[1] + dy[i];
				if(xx<0 || xx>=r || yy<0 || yy>=c) return tmp[2];  // 빠져나왔을 때 바로 return
				if(visited[xx][yy] || miro[xx][yy]!='.') continue;  // 이미 지나왔거나 갈 수 있는 곳이 아니라면 continue
				visited[xx][yy] = true;
				Q.offer(new int[] {xx, yy, tmp[2]+1});
			}
		}
		
		return -1;
	}
	
	static void fire() {
		while(true) {
			if(FQ.isEmpty() || FQ.peek()[2]!=t) return;  // 더이상 번질 불이 없거나 다음에 번질 불 이라면 그만 번진다. 
			int[] tmp = FQ.poll();
			for(int i=0; i<4; i++) {
				int xx = tmp[0] + dx[i];
				int yy = tmp[1] + dy[i];
				if(xx<0 || xx>=r || yy<0 || yy>=c || miro[xx][yy]=='#' || miro[xx][yy]=='F') continue; // 벽이나 불인 곳은 확인안한다 
				miro[xx][yy] = 'F';
				FQ.offer(new int[] {xx, yy, tmp[2]+1});
			}
		}
	}
}
