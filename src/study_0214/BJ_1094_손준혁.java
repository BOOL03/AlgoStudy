package study_0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1094_손준혁 {
	static int X, count = 0, stick = 64;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		cal();
		System.out.println(count);
	}
	static void cal() {
		while(true) {
			if(stick > X) stick = stick/2;
			else if(X <= 0)break;
			else {
				count++;
				X -= stick;
			}
		}
	}
}
