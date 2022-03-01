package study_0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10972_손준혁 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		int[] tmp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp[i] = N-i;
		}
		if(Arrays.equals(tmp, arr)) {
			System.out.println(-1);
			return;
		}
		comb(0, N);
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	static void comb(int dp, int N) {
		int i = N - 1, j = N - 1;;
        while (i > 0 && arr[i - 1] >= arr[i]) {
        	i--; 
        }
 
        while (arr[j] <= arr[i - 1]) {
        	j--; 
        }
 
        swap(i - 1, j);
        j = N - 1;
        while (i < j) {
            swap(i, j);
            i++; 
            j--;
        }
  
	}
	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
