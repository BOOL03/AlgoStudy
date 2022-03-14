package study_0314;
import java.io.*;
import java.util.*;

public class BJ_16637_배찬비 {
	
	static int n, answer=Integer.MIN_VALUE;
	static char[] num;
	
	static void DFS(int index, int sum, char sign) {
		if(index==n-1) {
			int tmp = Integer.MIN_VALUE;
			if(sign=='+') tmp = sum+(num[n-1]-'0');
			else if(sign=='-') tmp = sum-(num[n-1]-'0');
			else if(sign=='*') tmp = sum*(num[n-1]-'0');
			answer = Math.max(answer, tmp);
			return;
		} else if(index>=n) {
			answer = Math.max(sum, answer);
			return;
		}
		if(sign=='+') {
			if(num[index+1]=='+') DFS(index+4, sum+((num[index]-'0')+(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='-') DFS(index+4, sum+((num[index]-'0')-(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='*') DFS(index+4, sum+((num[index]-'0')*(num[index+2]-'0')), num[index+3]);
			DFS(index+2, sum+(num[index]-'0'), num[index+1]);
		} else if(sign=='-') {
			if(num[index+1]=='+') DFS(index+4, sum-((num[index]-'0')+(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='-') DFS(index+4, sum-((num[index]-'0')-(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='*') DFS(index+4, sum-((num[index]-'0')*(num[index+2]-'0')), num[index+3]);
			DFS(index+2, sum-(num[index]-'0'), num[index+1]);
		} else if(sign=='*') {
			if(num[index+1]=='+') DFS(index+4, sum*((num[index]-'0')+(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='-') DFS(index+4, sum*((num[index]-'0')-(num[index+2]-'0')), num[index+3]);
			else if(num[index+1]=='*') DFS(index+4, sum*((num[index]-'0')*(num[index+2]-'0')), num[index+3]);
			DFS(index+2, sum*(num[index]-'0'), num[index+1]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = (br.readLine()+"+").toCharArray();
		
		DFS(0, 0, '+');
		
		System.out.println(answer);
		
	}

}
