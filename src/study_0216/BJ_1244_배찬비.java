package study_0216;
import java.io.*;
import java.util.*;

public class BJ_1244_배찬비 {
	
	static int n, m;
	static boolean[] light;
	
	static void girl(int num) {
		light[num] = !light[num];
		int left = num-1;
		int right = num+1;
		while(true) {
			if(left<1 || right>n) break;
			if(light[left]==light[right]) {
				light[left] = !light[left];
				light[right] = !light[right];
				left--;
				right++;
			}
			else break;
		}
	}
	
	static void boy(int num) {
		for(int i=num; i<=n; i+=num) {
			light[i] = !light[i];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		light = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			if(Integer.parseInt(st.nextToken())==1) light[i] = true;
		}
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int fm = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(fm==1) boy(num);
			else girl(num);
		}
		
		for(int i=1; i<=n; i++) {
			if(light[i]) answer.append("1 ");
			else answer.append("0 ");
			if(i%20==0) answer.append("\n");
		}
		
		System.out.println(answer.toString());
		
	}
	
}