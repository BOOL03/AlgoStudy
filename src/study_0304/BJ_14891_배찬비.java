package study_0304;
import java.io.*;
import java.util.*;

public class BJ_14891_배찬비 {
	
	static char[][] gear = new char[4][8];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) gear[i] = br.readLine().toCharArray();
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			int[] d = new int[4];
			d[num] = dir;
			
			for(int j=num; j>0; j--) {
				if(gear[j][6]!=gear[j-1][2]) {
					if(d[j]==1) d[j-1] = -1;
					else d[j-1] = 1;
				} else break;
			}
			for(int j=num; j<3; j++) {
				if(gear[j][2]!=gear[j+1][6]) {
					if(d[j]==1) d[j+1] = -1;
					else d[j+1] = 1;
				} else break;
			}
			for(int j=0; j<4; j++) {
				if(d[j]==1) rotation(j);
				else if(d[j]==-1) reverse(j);
			}
		}
		int answer = 0;
		if(gear[0][0]=='1') answer += 1;
		if(gear[1][0]=='1') answer += 2;
		if(gear[2][0]=='1') answer += 4;
		if(gear[3][0]=='1') answer += 8;
		
		System.out.println(answer);
	}
	
	static void rotation(int n) {
		char tmp = gear[n][7];
		for(int i=6; i>=0; i--) {
			gear[n][i+1] = gear[n][i];
		}
		gear[n][0] = tmp;
	}
	static void reverse(int n) {
		char tmp = gear[n][0];
		for(int i=0; i<7; i++) {
			gear[n][i] = gear[n][i+1];
		}
		gear[n][7] = tmp;
	}
}
