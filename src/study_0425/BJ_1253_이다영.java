package study_0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1253_이다영 {
	static int N;
	static int[] nums;
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N <= 2) {
			System.out.println(0);
			return;
		}
		
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int ans = 0;
		
		List<Integer> list = null;
		
		for (int i = 0; i < N; i++) {
			int num = nums[i];
			list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				list.add(nums[j]);
			}
			int size = list.size();
			for (int j = 0; j < size; j++) {
				int num2 = list.get(0);
				list.remove(0);
				if(find(num - num2, list)) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
	
	static boolean find(int num, List<Integer> list) {
		int length = list.size();
		int left = 0;
		int right = list.size();
		int mid = 0;
		
		while(true) {
			if(left > right || left >= length || right < 0) return false;
			
			if( (left + right) == 0) mid = 0;
			else mid = (left + right) / 2;
			
			int cmp = list.get(mid);
			if(cmp == num) return true;
			else if(cmp > num ) {
				right = mid - 1;
			}
			else if(cmp < num) {
				left = mid + 1;
			}
		}
	}
}
