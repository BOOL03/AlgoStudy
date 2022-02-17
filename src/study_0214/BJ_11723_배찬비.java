package study_0214;
import java.io.*;
import java.util.*;

public class BJ_11723_배찬비 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int x = 0;
		int mask = 0;
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			
			if(oper.equals("add")) {
				x = Integer.parseInt(st.nextToken());
				mask = mask | 1<<(x-1);
			} else if(oper.equals("remove")) {
				x = Integer.parseInt(st.nextToken());
				mask = mask & ~(1<<(x-1));
			} else if(oper.equals("check")) {
				x = Integer.parseInt(st.nextToken());
				if(((1<<(x-1)) & mask) != 0) answer.append("1\n");
				else answer.append("0\n");
			} else if(oper.equals("toggle")) {
				x = Integer.parseInt(st.nextToken());
				mask = mask ^ 1<<(x-1);
			} else if(oper.equals("all")) {
				mask = ~(1<<20);
			} else if(oper.equals("empty")) {
				mask = 0;
			}
		}
		System.out.println(answer.toString());
	}
}