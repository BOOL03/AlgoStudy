package study_0323;
import java.io.*;
import java.util.*;

public class BJ_16113_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = n/5;
		char[][] num = new char[5][m];
		String str = br.readLine();
		for(int i=0; i<5; i++) {
			num[i] = str.substring(i*m, i*m+m).toCharArray();
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<m; i++) {
			if(num[0][i]=='#') {
				int cnt = 0;
				for(int j=0; j<5; j++) {
					if(num[j][i]=='#') cnt++;
				}
				if(cnt==5) {
					if(i+1<m && num[0][i+1]=='#') {
						if(num[2][i+1]=='.') answer.append("0");
						else if(num[1][i+2]=='.') answer.append("6");
						else answer.append("8");
						i +=3;
					} else {  // 1 
						answer.append("1");
						i++;
					}
				} else if(cnt==4) {
					if(num[1][i]=='.') answer.append("2");
					else if(num[1][i+2]=='.') answer.append("5");
					else answer.append("9");
					i += 3;
				} else if(cnt==3) {
					if(num[1][i]=='.') answer.append("3");
					else if(num[0][i+1]=='.') answer.append("4");
					i+=3;
				} else if(cnt==1) {
					answer.append("7");
					i+=3;
				}
			}
		}
		
		System.out.println(answer.toString());
		
	}
}
