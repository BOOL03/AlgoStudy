package study_0511;
import java.io.*;
import java.util.*;

public class BJ_16927_배찬비 {
	
	static int[][] arr;
	static void lotation(int sx, int sy, int n, int m) {
		int tmp = arr[sx][sy];
		for(int i=sy+1; i<m; i++) arr[sx][i-1] = arr[sx][i];
		for(int i=sx+1; i<n; i++) arr[i-1][m-1] = arr[i][m-1];
		for(int i=m-2; i>=sy; i--) arr[n-1][i+1] = arr[n-1][i];
		for(int i=n-2; i>sx; i--) arr[i+1][sy] = arr[i][sy];
		arr[sx+1][sy] = tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sx = 0, sy = 0, x=n, y=m; 
		
		while(true) {
			int cnt = (x-sx-1)*2+(y-sy-1)*2;
			int tr = r%cnt;
			for(int i=0; i<tr; i++) lotation(sx, sy, x, y);
			sx++;
			sy++;
			x--;
			y--;
			if(x-sx<1 || y-sy<1) break;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
