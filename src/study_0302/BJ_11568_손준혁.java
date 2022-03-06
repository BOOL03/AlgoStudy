package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11568_손준혁 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		
		long max = 0, longMax = 0; 
		int count = 1;
		arr[0] = Long.parseLong(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if(arr[i] > max) max = arr[i];

		}
		boolean check = false;
		long tmp = 0;
		int count_low = 1, count_height = 1;
		for (int i = 1; i < N; i++) {
			if(check) {
				if(tmp > arr[i]) {
					count_low++;
				}
				else {
					if(count_low > count_height) count_height = count_low;
					count_low = 1;
				}
			}
			else {
				if(arr[i-1] < arr[i]) {
					count_height++;
				}
				else {
					check = true;
					tmp = arr[i-1];
					count_low = 1;
				}
			}
		}
		System.out.println(count_height);
	}

}
