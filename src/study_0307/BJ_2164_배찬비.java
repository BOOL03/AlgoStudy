package study_0307;
import java.io.*;
import java.util.*;

public class BJ_2164_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new ArrayDeque<>();
		
		for(int i=1; i<=n; i++) Q.offer(i);
		
		while(Q.size()>1) {
			Q.poll();
			Q.offer(Q.poll());
		}
		
		System.out.println(Q.poll());
	}
	
}
