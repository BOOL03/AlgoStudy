package study_0216;
import java.io.*;
import java.util.*;

public class BJ_1080_배찬비 {
	
	static int n, m, answer;
	static char[][] a, b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n][m];
		b = new char[n][m];
		
		for(int i=0; i<n; i++) a[i] = br.readLine().toCharArray();
		for(int i=0; i<n; i++) b[i] = br.readLine().toCharArray();
		
		if(n<3 || m<3) {   // n,m이 3이하이면 뒤집기 불가 
			if(equalArr()) System.out.println("0");  // a,b 가 원래 같다면 뒤집지 않고도 일치함 
			else System.out.println("-1");  // 다르다면 뒤집기 못하니까 -1 
			return;
		}
		
		for(int i=0; i<n-2; i++) {    //3*3 으로 뒤집을 수 있는 자릿수를 모두 확인한다 (왼쪽상단에서 우측하단으로 이동)
			for(int j=0; j<m-2; j++) { 
				if(a[i][j]!=b[i][j]) {  // 비교하는 자리가 같지 않다면 무조건 뒤집어야 하는 자리(이미 지나온 자리는 영향을 받지 않으므로 그리디) 
					change(i, j);  // 뒤집기 
					answer++;  //뒤집기한 횟수 
				}
			}
		}
		if(!equalArr()) answer = -1;  // 다 뒤집고나서 같은지 확인 했는데 다르면 -1 
		
		System.out.println(answer);
		
	}
	
	static void change(int x, int y) {  // 3*3 뒤집는 함수 
		for(int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				if(a[i][j]=='0') a[i][j] = '1';
				else a[i][j] = '0';
			}
		}
	}
	
	static boolean equalArr() {  // 배열이 서로 같은지 확인 하는 함수 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]!=b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}