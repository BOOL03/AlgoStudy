package study_0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615_손준혁 {
	static int count = 0;
	
	static int[] delta_x = {-1,0,1,1};
	static int[] delta_y = {1,1,1,0};
	
	static int[][] map = new int[20][20];
	static boolean[][][] visited = new boolean[20][20][4];
	//static boolean[][] visited = new boolean[20][20];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[j][i] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						if(visited[j][i][dir]) continue;
						visited[j][i][dir] = true;
						boolean result = DFS(dir, i, j);
						count = 0;
						if(result) {
							System.out.println(map[j][i]);
							System.out.println(j+" "+i);
							return;
						}
					}
//					if(visited[i][j] == false) {
//						
//					}
				}
			}
		}
		System.out.println(0);
	}
	static boolean DFS(int dir, int x, int y) {
		count++;
		//if(count == 5) return true;
		int dx = delta_x[dir] + x;
		int dy = delta_y[dir] + y;
		if(dx < 1 || dx > 19 || dy < 1 || dy > 19) return false;
		if(map[dy][dx] == map[y][x]) {
			boolean result = DFS(dir, dx, dy);
			if(count == 5) return true;
		}
		return false;
	}

}
