package study_0509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1052_손준혁 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(calc(N,K));
	}
	static int calc(int n, int k) {
		int count = 0;
		while(true) {
			int tmp = n+count;
			int bottle = 0;
			while(tmp > 0){
				if(tmp%2 != 0) bottle++;
				tmp = tmp/2;
			}
			if(bottle <= k) break;
			count++;
		}
		return count;
	}
}
