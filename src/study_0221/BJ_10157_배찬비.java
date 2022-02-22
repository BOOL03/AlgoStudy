package study_0221;
import java.io.*;
import java.util.*;

public class BJ_10157_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());
		
		if(num>c*r) {
			System.out.println("0");
			return;
		}
		
		int[][] arr = new int[c][r];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int cnt = 1;
		int x = 0, y = 0, d = 0;
		
		while(true) {
			if(cnt==num) {
				System.out.println((x+1)+" "+(y+1));
				break;
			}
			arr[x][y]=cnt++;
			if(x+dx[d]<0 || x+dx[d]>=c || y+dy[d]<0 || y+dy[d]>=r || arr[x+dx[d]][y+dy[d]]!=0) d = (d+1)%4;
			x = x+dx[d];
			y = y+dy[d];
		}
	}

}
