package study_0325;

import java.io.*;
import java.util.*;

public class BJ_1522_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Character> s = new ArrayList<>();
		int a = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') a++;
			s.add(str.charAt(i));
		}
		for(int i=0; i<a-1; i++) {
			s.add(s.get(i));
		}
		
		int cnt = 0;
		for(int i=0; i<a; i++) {
			if(s.get(i)=='b') cnt++;
		}
		int answer = cnt;
		
		for(int i=a; i<s.size(); i++) {
			if(s.get(i-a)=='b') cnt--;
			if(s.get(i)=='b') cnt++;
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
	}
	
}
