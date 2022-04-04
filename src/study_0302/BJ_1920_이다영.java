package study_0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_이다영 {
	static int N, M;
	static int[] nArray;
	static int[] mArray;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nArray = new int[N];
		for (int i = 0; i < N; i++) {
			nArray[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		mArray = new int[M];
		for (int i = 0; i < M; i++) {
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArray);
		
		for (int i = 0; i < M; i++) {
			binarySearch(mArray[i]);
		}
		
		System.out.println(sb);
	}
	
	static void binarySearch(int num) {
		
		int start = 0;
		int end = N-1;
		int mid = 2/N;
		
		while(start <= end) {
			mid = (start+end)/2;
			if(num == nArray[mid]) {
				sb.append(1).append("\n");
				return;
			}else if(num > nArray[mid]) {
				start =  mid+1;
				continue;
			}else {
				end = mid-1;
				continue;
			}
		}
		sb.append(0).append("\n");
	}
}
