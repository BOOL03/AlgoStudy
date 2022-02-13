package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_손준혁 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Stack<int[]> top = new Stack<>(); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < n) 
					top.pop();
				else { 
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}
			
			if(top.empty()) 
				System.out.print("0 ");
			top.push(new int[] {n, i+1});
		}
			
	}
}
