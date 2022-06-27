package study_0530;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_3190_손준혁 {
	static int[] delta_x = {0, 1, 0, -1};
	static int[] delta_y = {-1, 0, 1, 0};
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        Map<Integer, String> dirSet = new HashMap<>();
        
        for(int i = 0; i < N+2; i++) {
            map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 1;
        }
        // 사과 설정
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2;
        }
 
        // 방향 설정
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            dirSet.put(x, st.nextToken());
        }
        calc(dirSet);
        
	}
	static int calc(Map<Integer, String> dirSet) {
		int dir = 1;
        int time = 0;
        
        Deque<Location> snake = new ArrayDeque<>();
        snake.add(new Location(1,1));
        while(true) {
            time++;
            Location head = snake.peekLast();
            int nX = head.x + delta_x[dir];
            int nY = head.y + delta_y[dir];
            if(map[nY][nX] == 1) {
                break;
            }
            if(map[nY][nX] != 2) {
                Location tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[nY][nX] = 1;
            snake.addLast(new Location(nY, nX));
            if(dirSet.containsKey(time)) {
                dir = (dirSet.get(time).equals("D")) ? (dir+1) % 4 : (dir+3) % 4;
            }
        }
        System.out.println(time);
        
		return 0;
	}
    static class Location {
        int x;
        int y;
        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
