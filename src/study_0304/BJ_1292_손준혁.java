package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1292_손준혁 {
	static int[] arr = new int[1000];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int sum = 1, count = 0;
		boolean check = true;
		while(true) {
			for (int i = 0; i < sum; i++) {
				arr[count++] = sum;
				if(count >= 1000) {
					check = false;
					break;
				}
			}
			sum++;
			if(!check) break;
		}
		int result = 0;
		for (int i = start-1; i < end; i++) {
			result += arr[i];
		}
		System.out.println(result);
	}

}
