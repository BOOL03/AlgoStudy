package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_손준혁 {
    static int[] delta_x = {0,0,1,-1};
    static int[] delta_y = {1,-1,0,0};
	
    static int n, m;
    static int[][] map;
    static int min = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
		
        map = new int[n][m];
		
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++) {
          		map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
    }
    static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
					dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        int[][] virusMap = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(virusMap[i][j] == 2) q.offer(new Pair(i,j));
            }
        }

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + delta_x[i];
                int ny = y + delta_y[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(virusMap[nx][ny] == 0) {
                        virusMap[nx][ny] = 2;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
        cal(virusMap);
    }

    static void cal(int[][] virusMap) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(virusMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        min = Math.max(cnt, min);
    }
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
