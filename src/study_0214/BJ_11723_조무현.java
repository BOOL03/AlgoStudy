package study_0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11723_조무현 {
	static int M;
	static int S = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			switch(order) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				S = S | 1 << num;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb = ((S & 1 << num) > 0)? sb.append("1\n"): sb.append("0\n");
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				S = S & ~(1 << num);
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				S = S ^ (1 << num);
				break;
			case "all":
				S = S | Integer.MAX_VALUE;
				break;
			case "empty":
				S = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
