package study_0330;
import java.io.*;
import java.util.*;

public class BJ_15787_배찬비 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] train = new char[n+1][21];
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=20; j++) train[i][j]='0';
		}
	
		
		for(int t=0; t<m; t++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			if(type.equals("1")) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				train[i][x] = '1';
			} 
			else if(type.equals("2")) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				train[i][x] = '0';
			} 
			else if(type.equals("3")) {
				int i = Integer.parseInt(st.nextToken());
				for(int j=19; j>=0; j--) {
					train[i][j+1] = train[i][j];
				}
			} 
			else {
				int i = Integer.parseInt(st.nextToken());
				for(int j=1; j<20; j++) {
					train[i][j] = train[i][j+1];
				}
				train[i][20] = '0';
			}
		}
		
		
		Set<String> set = new HashSet<>();
		int answer = 0;
		for(int i=1; i<=n; i++) {
			String str = String.valueOf(train[i]);
			if(!set.contains(str)) {
				answer++;
				set.add(str);
			}
		}
		
		System.out.println(answer);
	}
}
