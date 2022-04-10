package study_0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class SW_2382_이다영 {
	static int T, N, M, K, ans;
	
	static PriorityQueue<Node> queue;
	static Node[][] map;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 한변 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
			
			queue = new PriorityQueue<>();
			map = new Node[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				queue.offer(new Node(y, x, cnt, dir));
			}
			
			System.out.println("#"+ t + " " + move());
		}
	}
	
	static int move() {
		int time = M, ny, nx, remainCnt = 0;
		
		while(time-- > 0) {
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				ny = node.y + dy[node.dir];
				nx = node.x + dx[node.dir];
				
				node.y = ny;
				node.x = nx;
				
				// 1. 다음 칸으로 갈 때 약품 구역에 존재하는지?
				if(ny== 0 || nx == 0 || ny == N-1 || nx == N-1) {
					node.cnt /= 2;
					if(node.cnt == 0) continue; //군집 사라짐
					
					if(node.dir %2 == 1) node.dir++;
					else node.dir--;
				}
				
				// 2. 아무것도 아닌경우
				if(map[ny][nx] == null) {
					map[ny][nx] = node;
				}else {
					// 3. 두 개 이상의 군집이 한 셀에 모이는 경우
					map[ny][nx].cnt += node.cnt;
				}
			}
			remainCnt = reset();
		}
		return remainCnt;
	}
	static int reset() {
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null) {
					queue.offer(map[i][j]);
					total += map[i][j].cnt;
					map[i][j] = null;
				}
			}
		}

		return total;
	}
	
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int cnt;
		int dir;
		
		public Node(int y, int x, int cnt, int dir) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			return o.cnt - this.cnt; // 내림차순 
		}
	}

}
