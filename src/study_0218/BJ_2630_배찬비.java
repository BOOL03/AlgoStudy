package study_0218;
import java.io.*;
import java.util.*;

public class BJ_2630_배찬비 {
	
	static int white, blue;
	static int[][] paper;
	
	static void divide(int n, int x, int y) {
		int color = paper[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(paper[i][j]!=color) {
					divide(n/2, x, y);
					divide(n/2, x, y+n/2);
					divide(n/2, x+n/2, y);
					divide(n/2, x+n/2, y+n/2);
					return;
				}
			}
		}
		if(color==1) blue++;
		else white++;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(n, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

}
