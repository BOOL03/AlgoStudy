package study_0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767_손준혁 {
	static int T,N;
	static int core_count, wire_len;
	static int[][] cell;
	
	static List<Core> coreList = null;
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			cell = new int[N][N];
			core_count = Integer.MIN_VALUE;
			wire_len = Integer.MAX_VALUE;
			coreList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
					if(cell[i][j] == 1) {
						if(i != 0 && j != 0) coreList.add(new Core(j,i));
						else core_count++;
					}
				}
			}
			ConnectCore(0,0,0);
			System.out.println("#"+(t+1)+" "+wire_len);
		}
		
	}
	static void ConnectCore(int dp, int coreCnt, int wireLen) {
		if(dp == coreList.size()) {
			if(coreCnt > core_count) {
				wire_len = wireLen;
				core_count = coreCnt;
			}
			else if(coreCnt == core_count) {
				wire_len = Math.min(wireLen, wire_len);
			}
			return;
		}
		int x = coreList.get(dp).x;
		int y = coreList.get(dp).y;

		for (int i = 0; i < 4; i++) {
			int dx = x;
			int dy = y;
			int lentmp = wireLen;
			boolean wireCheck = false;
			while(true) {
				dx += delta_x[i];
				dy += delta_y[i];
				if(dx < 0 || dx >= N || dy < 0 || dy >= N) {
					wireCheck = true;
					break;
				}
				if(cell[dy][dx] == 1) break;
				
			}
			if(wireCheck) {
				dx = x;
				dy = y;
				while(true) {
					dx += delta_x[i];
					dy += delta_y[i];
					if(dx < 0 || dx >= N || dy < 0 || dy >= N) break;
					cell[dy][dx] = 1;
					lentmp++;
				}
				ConnectCore(dp+1, coreCnt+1, lentmp);
				dx = x;
				dy = y;
				while(true) {
					dx += delta_x[i];
					dy += delta_y[i];
					if(dx < 0 || dx >= N || dy < 0 || dy >= N) break;
					cell[dy][dx] = 0;
					
				}
			}
			else {
				ConnectCore(dp+1, coreCnt, wireLen);
			}
		}
	}
	static class Core{
		int x;
		int y;
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

