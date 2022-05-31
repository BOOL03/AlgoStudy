package study_0530;
import java.io.*;
import java.util.*;

public class BJ_3190_배찬비 {
	
	static int[][] arr;
	static int n, d = 0, x=0, y=0, answer=1;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;  // 사과 
		}
		arr[0][0] = 2;
		Deque<int[]> snake = new ArrayDeque<>();
		snake.offer(new int[] {0, 0}); // 뱀의 몸 위치들 
		
		int l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			for(int j=answer; j<=t; j++) {
				x += dx[d];
				y += dy[d];
				if(x<0 || x>=n || y<0 || y>=n || arr[x][y]==2) {
					System.out.println(j);
					return;
				}
				else if(arr[x][y]==0) { // 사과 없으면 꼬리는 다시 줄어듬
					int[] e = snake.pollLast();
					arr[e[0]][e[1]] = 0;
				}
				snake.offerFirst(new int[] {x,y});
				arr[x][y] = 2;
				
			}
			
			answer = t+1;
			if(c=='L') d = d==0? 3: d-1;
			else d = (d+1)%4;
		}
		
		while(true) {
			x += dx[d];
			y += dy[d];
			if(x<0 || x>=n || y<0 || y>=n || arr[x][y]==2) {
				System.out.println(answer);
				return;
			}
			else if(arr[x][y]==0) { // 사과 없으면 꼬리는 다시 줄어듬 
				arr[x-dx[d]][y-dy[d]] = 0;
			}
			arr[x][y] = 2;
			answer++;
		}
		
	}


}
