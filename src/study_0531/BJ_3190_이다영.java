package study_0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3190_이다영 {
	static int N, K, L, time;
	static int[][] map;
	
	static int[] dy = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] dx = {1, 0, -1, 0};
	
	static int my = 0; // 시작방향은 오른 쪽
	static int mx = 0;
	
	static int y = 0; // 현재 좌표
	static int x = 0;
	
	static Queue<int[]> snake = new ArrayDeque<>();
	
	static List<Node> command = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) -1][Integer.parseInt(st.nextToken())-1] = 2; // 2 사과
		}
		
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			command.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}
		
		snake.offer(new int[] {y, x});
		
		while(true) {
			int ny = y + dy[my];
			int nx = x + dx[mx];
			
			if(ny >= N || nx >= N || ny <0 || nx < 0 || map[ny][nx] == 1) break; //벽 또는 자기자신의 몸과 부딪히면 게임 끝
			
			if(map[ny][nx] == 2) { // 사과가 있는 경우
				map[ny][nx] = 1; // 머리 이동
				snake.offer(new int[] {ny, nx});
				y = ny; // 현재 좌표 이동
				x = nx; 
			}else if (map[ny][nx] == 0) {
				map[ny][nx] = 1; //머리 이동
				snake.offer(new int[] {ny, nx});
				
				int[] tail = snake.poll(); // 꼬리 이동
				map[tail[0]][tail[1]] = 0; //꼬리 이동
				y = ny; // 현재 좌표 이동
				x = nx;
			}
			
			time++;
			
			if(command.size() > 0 && time == command.get(0).t) {
				char com = command.get(0).c;
				if(com == 'L') {
					my = my-1 < 0 ? 3 : my-1;
					mx = mx-1 < 0 ? 3 : mx-1;
				}else {
					my = my+1 > 3 ? 0 : my+1;
					mx = mx+1 > 3 ? 0 : mx+1;
				}
				command.remove(0);
			}
		}
		time++;
		System.out.println(time);
	}
	public static class Node{
		int t;
		char c;
		
		public Node (int t, char c) {
			this.t = t;
			this.c = c;
		}
	}

}
