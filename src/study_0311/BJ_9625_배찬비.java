package study_0311;
import java.io.*;
import java.util.*;

public class BJ_9625_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		
		int a = 1;
		int b = 0;
		
		for(int i=0; i<n; i++) {
			int tmp = a;
			a = b;
			b += tmp;
		}
		
		System.out.println(a+" "+b);
	}
	
}
