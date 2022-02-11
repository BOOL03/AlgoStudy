package study_0211;
import java.io.*;
import java.util.*;

public class BJ_2583_배찬비 {
	static int n, m, k;
	static int[][] paper;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static ArrayList<Integer> answer = new ArrayList<>();
	
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		
		for(int t=0; t<k; t++) {
			st = new StringTokenizer(br.readLine());
			draw(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paper[i][j]==0) find(i, j);
			}
		}
		Collections.sort(answer);
		bw.write(answer.size()+"\n");
		for(int a : answer) bw.write(a+" ");
		bw.flush();
	}
	static void draw(int sx, int sy, int ex, int ey) {
		for(int i=sx; i<ex; i++) {
			for(int j=sy; j<ey; j++) {
				paper[j][i] = 1;
			}
		}
	}
	static void find(int x, int y) {
		int cnt = 1;
		Queue<Pos> Q = new LinkedList<>();
		Q.offer(new Pos(x, y));
		paper[x][y] = 1;
		while(!Q.isEmpty()) {
			Pos p = Q.poll();
			for(int i=0; i<4; i++) {
				int xx = p.x+dx[i];
				int yy = p.y+dy[i];
				if(xx<0 || xx>=n || yy<0 || yy>=m || paper[xx][yy]==1) continue;
				cnt++;
				paper[xx][yy] = 1;
				Q.offer(new Pos(xx, yy));
			}
		}
		answer.add(cnt);
	}

}