package study_0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10775_이다영 {
	static int G, P;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		arr = new int[G+1];
		
		for (int i = 1; i <= G; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			int num = find(Integer.parseInt(br.readLine()));
			if(num == 0) break;
			arr[num] = num-1;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int find(int x) {
		if (x == arr[x]) return x;
		else return arr[x] = find(arr[x]);
	}
}
