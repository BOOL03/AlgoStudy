package study_0323;
import java.io.*;
import java.util.*;

public class BJ_1780_배찬비 {
	
	static int[] answer = new int[3];
	static int[][] paper;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper= new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(n, 0, 0);
		for(int i : answer) System.out.println(i);
	}
	
	static void cut(int n, int x, int y) {
		int num = paper[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(paper[i][j]!=num) {
					cut(n/3, x, y);
					cut(n/3, x+n/3, y);
					cut(n/3, x+(n/3)*2, y);
					cut(n/3, x, y+n/3);
					cut(n/3, x+n/3, y+n/3);
					cut(n/3, x+(n/3)*2, y+n/3);
					cut(n/3, x, y+(n/3)*2);
					cut(n/3, x+n/3, y+(n/3)*2);
					cut(n/3, x+(n/3)*2, y+(n/3)*2);
					return;
				}
			}
		}
		answer[num+1]++;
	}
}
