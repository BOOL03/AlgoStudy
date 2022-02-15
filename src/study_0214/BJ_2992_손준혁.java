package study_0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2992_손준혁 {
	static int X;
	static int[] X_array;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		X_array = new int[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			X_array[i] = tmp.charAt(i) - '0';
		}
		if(np()) {
			for (int i = X_array.length - 1; i >= 0; i--) {
				X += X_array[X_array.length - i - 1]*(Math.pow(10, i));
			}
			System.out.println(X);
		}
		else System.out.println("0");
	}
	static boolean np() {
		int[] src = X_array;
		
		int i = src.length - 1;
		while(i>0 && src[i-1] >= src[i]) --i;
		if(i == 0) return false;
		
		int j = src.length - 1;
		while(src[i-1] >= src[j]) --j;
		swap(src, i-1, j);
		
		int k = src.length-1;
		int temp = 0;
		/*while(i<k) {
		    temp=src[i];
			src[i]=src[k];
			src[k]=temp;
			++i; --k;
		}*/
		
//		int k = src.length - 1;
//		while( i < k) {
//			swap(src, i++, k);
//		}
//		
		return true;
	}
	static void swap(int[] array, int i , int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
