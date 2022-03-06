package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1920_손준혁 {
	static int N, M;
	static int[] arr_n, arr_m, arr_find;
	
	static Queue<Integer> queue_m = new LinkedList<>();
	static ArrayList<Integer> list_m = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr_n = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr_n[i] = Integer.parseInt(st.nextToken());
		
		}
		Arrays.sort(arr_n);
		
		M = Integer.parseInt(br.readLine());
		arr_m = new int[M];
		arr_find = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(binaryCompare(Integer.parseInt(st.nextToken())) == -1) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
//			arr_m[i] = Integer.parseInt(st.nextToken());
//			queue_m.offer(arr_m[i]);
		}
		
		
		
		//Arrays.sort(arr_m);
		
		//compare();
		
//		while(!queue_m.isEmpty()) {
//			if(list_m.contains(queue_m.poll())) {
//				System.out.println(1);
//			}
//			else {
//				System.out.println(0);
//			}
//		}
	}
	static int binaryCompare(int k) {
		int low = 0;	
		int height = N - 1;	
 
		while(low <= height) {
 
			int mid = (low + height) / 2;	

			if(k < arr_n[mid]) {
				height = mid - 1;
			}
			else if(k > arr_n[mid]) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	static void compare() {
		int n=0,m=0;
		while(true) {
			if(arr_n[n] == arr_m[m]) {
				list_m.add(arr_m[m]);
				n++;
				m++;
			}
			else if(arr_n[n] > arr_m[m]) {
				m++;
			}
			else if(arr_n[n] < arr_m[m]) {
				n++;
			}
			if(n == N || m == M) break;
		}
	}
}
