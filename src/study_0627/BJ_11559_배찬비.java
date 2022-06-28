package study_0627;
import java.io.*;
import java.util.*;

public class BJ_11559_배찬비 {
	
	static char[][] arr = new char[12][6];
	static List<int[]> pang;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		while(true) {
			int cnt = find();
			if(cnt!=0) {
				answer++;
				down();
			}
			else break;
		}
		
		System.out.println(answer);
	}
	
	static int find() {
		int cnt = 0;
		for(int i=11; i>=0; i--) {
			for(int j=0; j<6; j++) {
				if(arr[i][j]=='.') continue;
				if(isFour(i, j)) cnt++;
			}
		}
		return cnt;
	}
	
	static boolean isFour(int x, int y) {
		pang = new ArrayList<>();
		pang.add(new int[] {x, y});
		
		char color = arr[x][y];
		boolean[][] visited = new boolean[12][6];
		visited[x][y] = true;
		
		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {x, y});
		
		while(!Q.isEmpty()) {
			int[] t = Q.poll();
			for(int i=0; i<4; i++) {
				int xx = t[0]+dx[i];
				int yy = t[1]+dy[i];
				if(xx<0 || xx>=12 || yy<0 || yy>=6 || visited[xx][yy] || arr[xx][yy]!=color) continue;
				visited[xx][yy] = true;
				Q.add(new int[] {xx, yy});
				pang.add(new int[] {xx, yy});
			}
		}
		
		if(pang.size()>=4) {
			for(int i=0; i<pang.size(); i++) {
				arr[pang.get(i)[0]][pang.get(i)[1]] = '.';
			}
			return true;
		}
		else return false;
	}
	
	static void down() {
		for(int j=0; j<6; j++){
			int index = 11;
			for(int i=11; i>=0; i--) {
				if(arr[i][j]!='.') {
					arr[index--][j] = arr[i][j];
				}
			}
			for(int i=index; i>=0; i--) arr[i][j] = '.';
		}
	}

}
