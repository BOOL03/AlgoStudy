package study_0311;
import java.io.*;
import java.util.*;

public class BJ_2615_배찬비 {
	
	static int[] dx = {-1, 0, 1, 1};
	static int[] dy = {1, 1, 1, 0};
	static int[][] arr = new int[20][20];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				if(arr[i][j]!=0) {
					for(int k=0; k<4; k++) {
						if(poss(i, j, k, arr[i][j])) {
							System.out.println(arr[i][j]);
							System.out.println(i+" "+j);
							return;
						}
					}
				}
			}
		}
		
		System.out.println("0");
	}
	
	static boolean poss(int i, int j, int num, int color) {
		for(int k=1; k<5; k++) {
			int x = i+dx[num]*k;
			int y = j+dy[num]*k;
			if(x<1 || x>=20 || y<1 || y>=20) return false;
			if(arr[x][y]!=color) return false;
		}
		//뒤 확인 
		int x = i+dx[num]*5;
		int y = j+dy[num]*5;
		if(x>0 && x<20 && y>0 && y<20 && arr[x][y]==color) return false;
		//앞 확인 
		x = i-dx[num];
		y = j-dy[num];
		if(x>0 && x<20 && y>0 && y<20 && arr[x][y]==color) return false;
		return true;
	}
	
}
