package study_0401;
import java.io.*;
import java.util.*;

public class BJ_2023_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
		list[0].add(0);
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<list[i-1].size(); j++) {
				int num = list[i-1].get(j);
				for(int k=1; k<10; k++) {
					if(isPrime(num*10+k)) list[i].add(num*10+k);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list[n].size(); i++) {
			sb.append(list[n].get(i)+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean isPrime(int num) {
		for(int i=2; i*i<=num; i++) {
			if(num%i==0) return false;
		}
		if(num==1) return false;
		return true;
	}
	
}
