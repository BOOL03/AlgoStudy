package study_0225;
import java.io.*;
import java.util.*;

public class BJ_2564_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[][] store = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int type = Integer.parseInt(st.nextToken());
		int pos = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			if(type == store[i][0]) answer += Math.abs(pos-store[i][1]);
			else if(type == 1) {
				if(store[i][0] == 2) answer += col+Math.min(pos+store[i][1], 2*row-(pos+store[i][1]));
				else if(store[i][0] == 3) answer += pos+store[i][1];
				else answer += row-pos+store[i][1];
			} else if(type == 2) {
				if(store[i][0] == 1) answer += col+Math.min(pos+store[i][1], 2*row-(pos+store[i][1]));
				else if(store[i][0] == 3) answer += pos+col-store[i][1];
				else answer += row-pos+col-store[i][1];
			} else if(type == 3) {
				if(store[i][0] == 4) answer += row+Math.min(pos+store[i][1], 2*col-(pos+store[i][1]));
				else if(store[i][0] == 1) answer += pos+store[i][1];
				else answer += col-pos+store[i][1];
			} else {
				if(store[i][0] == 3) answer += row+Math.min(pos+store[i][1], 2*col-(pos+store[i][1]));
				else if(store[i][0] == 1) answer += pos+row-store[i][1];
				else answer += col-pos+row-store[i][1];
			}
		}
		
		System.out.println(answer);
	}
}
