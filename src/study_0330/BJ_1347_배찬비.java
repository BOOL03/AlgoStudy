package study_0330;
import java.io.*;
import java.util.*;

public class BJ_1347_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		char[] move = br.readLine().toCharArray();
		
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, -1, 0, 1};
		ArrayList<int[]> pos = new ArrayList<>();
		pos.add(new int[] {0,0});
		int x = 0, y = 0, d = 0;
		int minx = 0, miny = 0, maxx=0, maxy=0;
		
		for(int i=0; i<n; i++) {
			if(move[i]=='F') {
				x += dx[d];
				y += dy[d];
				minx = Math.min(minx, x);
				miny = Math.min(miny, y);
				maxx = Math.max(maxx, x);
				maxy = Math.max(maxy, y);
				pos.add(new int[]{x, y});
			} else if(move[i]=='L') {
				if(d==0) d=3;
				else d--;
			} else {
				d = (d+1)%4;
			}
		}
		
		int h = maxx-minx;
		int w = maxy-miny;
		char[][] answer = new char[h+1][w+1];
		for(int i=0; i<pos.size(); i++) {
			answer[pos.get(i)[0]-minx][pos.get(i)[1]-miny] = '.';
		}
		
		for(int i=0; i<=h; i++) {
			for(int j=0; j<=w; j++) {
				if(answer[i][j]=='.') bw.write('.');
				else bw.write('#');
			}
			bw.write("\n");
		}
		
		bw.flush();
	}

}
