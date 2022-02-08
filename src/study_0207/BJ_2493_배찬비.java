package study_0207;
import java.util.*;
import java.io.*;


public class BJ_2493_배찬비 {	
	static class Top{
		int h, index;
		Top(int h, int index){
			this.h = h;
			this.index = index;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		Top[] stack = new Top[n];
		int[] tops = new int[n];
		int cnt = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1; i>=0; i--) {
			while(cnt>=0) {
				if(stack[cnt].h<tops[i]) {
					answer[stack[cnt].index] = i+1;
					cnt--;
				} 
				else break;
			}
			stack[++cnt] = new Top(tops[i], i);
		}
		for(int i=0; i<n; i++) System.out.print(answer[i]+" ");
		
	}
}
