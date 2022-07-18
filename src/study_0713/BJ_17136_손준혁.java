package study_0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136_손준혁 {

	static int[][] map = new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int[] papers = {5,4,3,2,1}, sizes = new int[5];
	static int[] paper = {0,5,5,5,5,5};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				if(map[i][j] == 1 && visited[i][j] == false) {
//					calc(i,j);
//				}
//			}
//		}
//		int result = 0;
//		for (int data : sizes) {
//			if(data > 3) {
//				System.out.println(-1);
//				return;
//			}
//			result += data;
//			System.out.print(data + " ");
//		}
//		System.out.println(result);
		
		DFS(0,0,0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	static void calc(int y, int x) {
		int size = -1;
		for (int i = 0; i < 5; i++) {
			int dx = x + papers[i];
			int dy = y + papers[i];
			if(dx < 0 || dx > 9 || dy < 0 || dy > 9) continue;
			
			boolean result = search(i, y, x);
			if(result) {
				size = i;
				break;
			}
		}
		visited[y][x] = true;
		if(size < 0) return;
		sizes[size]++;
		for (int dy = 0; dy < papers[size]; dy++) {
			for (int dx = 0; dx < papers[size]; dx++) {
				visited[y+dy][x+dx] = true;
			}
		}
	}
	static boolean search(int i, int y, int x) {
		for (int rx = 0; rx < papers[i]; rx++) {
			if(map[y][x+rx] == 0 || visited[y][x+rx]) {
				return false;
			}
			for (int ry = 0; ry < papers[i]; ry++) {
				if(map[y+ry][x] == 0 || visited[y+ry][x]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void DFS(int x, int y, int cnt) {
        if (x >= 9 && y > 9) {
            result = Math.min(result, cnt);
            return;
        }
        else if (result <= cnt) return;
        else if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }
 
        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0);
                    paper[i]--;
                    DFS(x, y + 1, cnt + 1);
                    attach(x, y, i, 1); 
                    paper[i]++;
                }
            }
        } else {
            DFS(x, y + 1, cnt);
        }
    }
 
    public static void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }
 
    public static boolean isAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
 
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
