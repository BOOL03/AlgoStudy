package study_0214;
import java.io.*;

public class BJ_1094_배찬비 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int tmp = 64;
		while(n>0) {
			if(n-tmp>=0) {
				answer++;
				n -= tmp;
			}
			tmp /= 2;
		}
		System.out.println(answer);
	}	
}