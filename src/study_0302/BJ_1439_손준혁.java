package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1439_손준혁 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		int zero = 0, one = 0;
		boolean check = false;// false : 0, true : 1
		if(arr[0].equals("0")) zero++;
		else {
			check = true;
			one++;
		}
		for (int i = 1; i < arr.length; i++) {
			if(!arr[i-1].equals(arr[i])) {
				if(!check) {//arr[i-1] = 0
					check = true;
					one++;
				}
				else {
					check = false;
					zero++;
				}
			}
		}
		System.out.println(Math.min(zero, one));
	}

}
