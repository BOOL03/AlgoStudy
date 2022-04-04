package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_이다영 {
	static char[] arr1;
	static char[] arr2;
	static char[] arr3;
	static char[] arr4;
	
	static int N, K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr1 = br.readLine().toCharArray();
		arr2 = br.readLine().toCharArray();
		arr3 = br.readLine().toCharArray();
		arr4 = br.readLine().toCharArray();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(num, dir, 0);
		}
		int sum = 0;
		sum += (arr1[0] == '1'? 1 : 0);
		sum += (arr2[0] == '1'? 2 : 0);
		sum += (arr3[0] == '1'? 4 : 0);
		sum += (arr4[0] == '1'? 8 : 0);
		
		System.out.println(sum);
	}
	static void rotate(int num, int dir, int before) {
		if(num == 1) {
			char right = arr1[2];
			char next = arr2[6];
			if(right != next && before!=2) {
				if(dir == 1) {
					rotate(2, -1, 1);
				}
				else {
					rotate(2, 1, 1);
				}
			}
			if(dir == 1) rotateR(arr1);
			else rotateL(arr1);
		}else if(num == 4) {
			char left = arr4[6];
			char next = arr3[2];
			if(left != next && before!=3) {
				if(dir == 1) {
					rotate(3, -1, 4);
				}
				else {
					rotate(3, 1, 4);
				}
			}
			if(dir == 1) rotateR(arr4);
			else rotateL(arr4);
		}else if(num == 2) {
			char left = arr2[6];
			char nextL = arr1[2];
			char right = arr2[2];
			char nextR = arr3[6];
			if(left != nextL && before!=1) {
				if(dir == 1) {
					rotate(1, -1, 2);
				}
				else {
					rotate(1, 1, 2);
				}
			}
			if(right != nextR && before!=3) {
				if(dir == 1) {
					rotate(3, -1, 2);
				}
				else {
					rotate(3, 1, 2);
				}
			}
			if(dir == 1) rotateR(arr2);
			else rotateL(arr2);
		}
		else if(num == 3) {
			char left = arr3[6];
			char nextL = arr2[2];
			char right = arr3[2];
			char nextR = arr4[6];
			if(left != nextL && before!= 2) {
				if(dir == 1) {
					rotate(2, -1, 3);
				}
				else {
					rotate(2, 1, 3);
				}
			}
			if(right != nextR && before!=4) {
				if(dir == 1) {
					rotate(4, -1, 3);
				}
				else {
					rotate(4, 1, 3);
				}
			}
			if(dir == 1) rotateR(arr3);
			else rotateL(arr3);
		}
	}
	
	static void rotateR(char[] arr) {
		char temp = arr[7];
		for (int i = 6; i >= 0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = temp;
	}
	static void rotateL(char[] arr) {
		char temp = arr[0];
		for (int i = 0; i <= 6 ; i++) {
			arr[i] = arr[i+1];
		}
		arr[7] = temp;
	}
}
