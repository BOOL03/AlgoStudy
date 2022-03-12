package study_0311;
import java.io.*;
import java.util.*;

public class BJ_20055_배찬비 {
	
	static int n, k, cnt;
	static int[][] belt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new int[2*n+1][2];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=2*n; i++) {
			belt[i][0] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 1;
		while(true) {
			step1();
			step2();
			step3();
			if(cnt>=k) break;
			answer++;
		}
		System.out.println(answer);
	}
	
	static void step1() {
		int[] tmp = belt[2*n];
		for(int i=2*n; i>1; i--) {
			belt[i] = belt[i-1];
		}
		belt[1] = tmp;
		if(belt[n][1]==1) belt[n][1] = 0;
	}
	
	static void step2() {
		for(int i=n-1; i>=1; i--) {
			if(belt[i][1]==1 && belt[i+1][1]==0 && belt[i+1][0]>0) {
				belt[i][1] = 0;
				belt[i+1][1] = 1;
				belt[i+1][0]--;
				if(belt[i+1][0]==0) cnt++;
			}
		}
		if(belt[n][1]==1) belt[n][1] = 0;
	}
	
	static void step3() {
		if(belt[1][0]>0) {
			belt[1][0]--;
			belt[1][1] = 1;
			if(belt[1][0]==0) cnt++;
		}
	}
}
