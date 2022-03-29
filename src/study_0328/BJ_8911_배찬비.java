package study_0328;

import java.io.*;
import java.util.*;

public class BJ_8911_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		StringBuilder answer = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int minx = 0, miny = 0, maxx = 0, maxy = 0;
			int x = 0, y = 0, d = 0;
			char[] arr = br.readLine().toCharArray();
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j]=='F') {
					x+=dx[d];
					y+=dy[d];
					minx = Math.min(minx, x);
					miny = Math.min(miny, y);
					maxx = Math.max(maxx, x);
					maxy = Math.max(maxy, y);
				} else if(arr[j]=='B') {
					x-=dx[d];
					y-=dy[d];
					minx = Math.min(minx, x);
					miny = Math.min(miny, y);
					maxx = Math.max(maxx, x);
					maxy = Math.max(maxy, y);
				} else if(arr[j]=='L') {
					if(d==0) d=3;
					else d--;
				} else {
					d = (d+1)%4;
				}
			}
			int size = (maxx-minx)*(maxy-miny);
			answer.append(size+"\n");
		}
		System.out.println(answer.toString());
	}
	
}
