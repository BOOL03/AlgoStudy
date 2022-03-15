package study_0311;

import java.util.Scanner;

public class BJ_9625_조무현 {
	static String ans="";
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();


		String str = "A";
		if(K == 1) {
			System.out.println("0 1");
		}else if(K > 1) {
			int k = 1;
			int[] bef = new int[]{1, 0};
			int[] aft = new int[]{0, 1};
			while(k != K) {
				int[] tmp = new int[2];
				tmp[0] = aft[0];
				tmp[1] = aft[1];
				
				aft[0] += bef[0];
				aft[1] += bef[1];
				bef[0] = tmp[0];
				bef[1] = tmp[1];
				k++;
			}
			System.out.println(aft[0] + " " + aft[1]);
		}


	}
	
	

}
