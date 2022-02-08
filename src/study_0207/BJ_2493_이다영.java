package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 69574
 * 00224
 */
public class BJ_2493_이다영 {
	static int N;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if (num > stack.peek()[1]) {
					stack.pop();
				}else {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
			}
			if(stack.isEmpty()) System.out.print("0 ");
			stack.push(new int[] {i, num});
		}	
	}
}
