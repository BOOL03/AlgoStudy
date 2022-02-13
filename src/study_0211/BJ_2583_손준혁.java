package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583_손준혁 {
	 
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int M,N,K;
    static boolean[][] visited;
    static int[][] map;
    static PriorityQueue<Integer> queue_data = new PriorityQueue<>();
  
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        visited = new boolean[M][N];
        int count = 0;

        int[] square_list = new int[4];
		for (int repeat = 0; repeat < K; repeat++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				square_list[j] = Integer.parseInt(st.nextToken());
			}
			for (int i = square_list[1]; i < square_list[3]; i++) { //y
				for (int j = square_list[0]; j < square_list[2]; j++) { // x
					map[i][j] = 1;
				}
			}
		}
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    int data = bfs(i, j);
                    queue_data.add(data);
                    count++;
                }
            }
        }
 
        System.out.println(count);
        while(!queue_data.isEmpty()) {
        	System.out.print(queue_data.poll()+" ");
        }
    }
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;
 
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int curX = data[0];
            int curY = data[1];
 
            for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
 
                if(nextX >=0 && nextY >=0 && nextX < M && nextY < N) {
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
