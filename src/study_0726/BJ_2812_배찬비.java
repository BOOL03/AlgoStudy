package study_0726;
import java.io.*;
import java.util.*;

public class BJ_2812_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		int[] num = new int[n];
		for(int i=0; i<n; i++) num[i] = str.charAt(i)-'0';
		
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		int index = n-1;
		
		for(int i=0; i<n; i++) {
			while(cnt<k && !stack.isEmpty() && stack.peek()<num[i]) {
				stack.pop();
				cnt++;
			}
			stack.push(num[i]);
			if(cnt==k) {
				index = i;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb = sb.reverse();
		for(int i=index+1; i<n; i++) {
			sb.append(num[i]);
		}
		
		System.out.println(sb.substring(0, n-k));
	}

}
