package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583_조무현 {
	static int M, N, K;
	static int map[][];
	static Queue<Node> queue = new LinkedList<>();
	static ArrayList<Integer> area = new ArrayList<>();
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < K; i++) {
			int x1, x2, y1, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			fill(x1, y1, x2, y2);
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					int count = 1;
					queue.add(new Node(i, j));
					while(!queue.isEmpty()) {
						Node node = queue.poll();
						map[node.y][node.x] = 1;
						for (int k = 0; k < 4; k++) {
							int ny = node.y + dy[k];
							int nx = node.x + dx[k];
							if(ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
							if(map[ny][nx] == 0) {
								queue.add(new Node(ny, nx));
								map[ny][nx] = 1;
								count++;
							}
						}
					}
					area.add(count);
					
				}
				
			}
		}
		
		Collections.sort(area);
		System.out.println(area.size());
		for (int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i) + " ");
		}
		
		
	}
	
	static void fill(int x1, int y1, int x2, int y2) {
		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {
				map[y][x] = 1;
			}
		}
	}
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}

}
