package study_0516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14600_손준혁 {
	//static int[][] tile;
	
	static int x, y;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;
		if(k == 1) {
			int[][] tile = new int[2][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					tile[i][j] = 1;
				}
			}
			tile[1-y][x] = -1;
			print(tile, 2);
		}
		else {
			//tile = new int[4][4];
			int[][] tile = {{1,1,2,2},{1,3,3,2},{4,3,3,5},{4,4,5,5}};
			tile[3-y][x] = -1;
			if(!((x>0 && x< 3) && (y>0 && y<3))) {
				if(x < 2 && 3-y < 2) {
					tile[1][1] = 1;
				}
				else if(x < 2 && 3-y > 1) {
					tile[2][1] = 4;
				}
				else if(x > 1 && 3-y < 2) {
					tile[1][2] = 2;
				}
				else if(x > 1 && 3-y > 1) {
					tile[2][2] = 5;
				}
			}
			print(tile, 4);
		}
		
		
	}
	static void print(int[][] tile, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(tile[i][j]+" ");
			}
			System.out.println();
		}
	}

}
