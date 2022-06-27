package study_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ_11559_손준혁 {
	static int crash = 0;
	
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static Stack<Block> record = new Stack<>();
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();			
		}
		
		while(true) {
			int count = 0;
			for (int i = 11; i >= 0 ; i--) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j] != '.' && !visited[i][j]) {
						count += BFS(map[i][j], new Block(j,i));
					}
					if(map[i][j] == '.') visited[i][j] = true;
				}
			}
			if(count != 0) crash++;
			else break;
			
			while(!record.isEmpty()) {
				Block b = record.pop();
				map[b.y][b.x] = '.';
			}
			blockDown();
			visited = new boolean[12][6];
			
		}
		
		System.out.println(crash);
	}
	static int BFS(char color, Block block) {
		Queue<Block> list = new LinkedList<>();
		
		list.offer(block);
		record.push(block);
		
		int count = 1;
		
		while(!list.isEmpty()) {
			Block b = list.poll();
			visited[b.y][b.x] = true; 
			for (int d = 0; d < 4; d++) {
				int dx = b.x + delta_x[d];
				int dy = b.y + delta_y[d];
				if(dx < 0 || dx > 5 || dy < 0 || dy > 11) continue;
				if(visited[dy][dx]) continue;
				if(color != map[dy][dx]) continue;
				visited[dy][dx] = true;
				count++;
				list.offer(new Block(dx,dy));
				record.push(new Block(dx,dy));
			}
		}
		if(count >= 4) {
			//crash++;
			return 1;
		}
		for (int i = 0; i < count; i++) {
			record.pop();
		}
		return 0;
	}
	static void blockDown() {
		for (int x = 0; x < 5; x++) {
			int count = 0;
			for (int y = 11; y >= 0; y--) {
				if(map[y][x] == '.') {
					count++;
				}
				else {
					fallBlock();
					break;
				}
			}
		}
	}
	static void fallBlock() {        
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                        	map[j][i] = map[k][i];
                        	map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
	static class Block{
		int x;
		int y;
		public Block() {};
		public Block(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
