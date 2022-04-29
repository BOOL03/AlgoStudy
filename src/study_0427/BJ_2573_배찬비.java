package study_0427;
import java.util.*;
import java.io.*;

public class BJ_2573_배찬비 {
	
	static int n, m;
	static int[][] arr;
	static Queue<int[]> Q = new ArrayDeque<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) Q.offer(new int[] {i, j});  // 빙산이 있는 자리 
			}
		}
		
		int answer = 1;
		while(!Q.isEmpty()) {  // 다녹지 않으면 계속 진행 
			melt();  // 빙산 녹이기 
			if(!bfs()) break;  // 한덩이인지 
			answer++;  // 년도 
		}
		
		if(Q.size()==0) System.out.println("0");  // 남은 빙산이 없다는건 다녹을떄까지 한덩이였다는 것 
		else System.out.println(answer);
	}
	
	static void melt() {
		Queue<int[]> tmp = new ArrayDeque<>();  // 녹고나서도 존재하는 빙산들을 저장 
		int[][] arr2 = new int[n][m];  // 원래 빙산높이를 저장해줄 배열 (arr은 녹고난값을 저장하기때문에 이전 상태를 체크해줘야함)
		
		while(!Q.isEmpty()) {
			int[] t = Q.poll();
			int cnt = 0;
			for(int i=0; i<4; i++) {  
				int x = t[0] + dx[i];
				int y = t[1] + dy[i];
				if(x<0 || x>=n || y<0 || y>=m) continue;
				if(arr[x][y] == 0 && arr2[x][y] == 0) cnt++;  // 현재랑 이전 둘다 0이면 원래 0이니까 cnt++
			}
			arr2[t[0]][t[1]] = arr[t[0]][t[1]];  // 원래 값을 저장 
			if(arr[t[0]][t[1]]-cnt<=0) {  // 빙산이 다 녹아 없어진다면 
				arr[t[0]][t[1]] = 0;
			} else {  // 좀 남아있다면 
				tmp.offer(t);  // tmp 에 저장 
				arr[t[0]][t[1]] -= cnt;
			}
		}
		
		Q = tmp;  // 녹고도 남아있는 빙산들의 위치를 다시 Q로 넘겨준다 
	}
	
	static boolean bfs() {
		if(Q.isEmpty()) return true;  // 다 녹았다면 한덩이인지 체크안함 
		
		Queue<int[]> tmp = new ArrayDeque<>();  
		boolean[][] visited = new boolean[n][m];
		int[] s = Q.peek();
		tmp.offer(s);
		int cnt = 1;
		visited[s[0]][s[1]] = true;
		
		while(!tmp.isEmpty()) {
			int[] t = tmp.poll();
			for(int i=0; i<4; i++) {
				int x = t[0] + dx[i];
				int y = t[1] + dy[i];
				if(x<0 || x>=n || y<0 || y>=m || arr[x][y]==0 || visited[x][y]) continue;
				cnt++;
				visited[x][y] = true;
				tmp.offer(new int[] {x,y});
			}
		}
		
		if(cnt==Q.size()) return true;  // 둘이 같다는건 한덩이라는 뜻 
		else return false;
	}

}
