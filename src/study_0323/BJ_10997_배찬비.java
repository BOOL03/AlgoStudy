package study_0323;

import java.io.*;
import java.util.*;

public class BJ_10997_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println("*");
			return;
		}
		int r = 3+4*(n-1);
		int c = 1+4*(n-1);
		char[][] arr = new char[r][c];
		
		int x = 0;
		int y = 0;
		for(int i=n; i>=1; i--) {
			for(int j=x; j<r-x; j++) {
				arr[j][y] = '*';
				arr[j][c-y-1] = '*';
			}
			for(int j=y; j<c-y; j++) {
				arr[x][j] = '*';
				arr[r-x-1][j] = '*';
			}
			if(i!=1) {
				arr[x+1][c-y-1] = ' ';
				arr[x+2][c-y-2] = '*';
			}
			x += 2;
			y += 2;
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<r; i++) {
			if(i==1) {
				answer.append("*\n");
				continue;
			}
			for(int j=0; j<c; j++) {
				if(arr[i][j]=='*') answer.append(arr[i][j]);
				else answer.append(" ");
			}
			answer.append("\n");
		}
		answer.deleteCharAt(answer.length()-1);
		System.out.println(answer.toString());
	}
}
