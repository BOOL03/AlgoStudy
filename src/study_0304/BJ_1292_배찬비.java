package study_0304;
import java.io.*;
import java.util.*;

public class BJ_1292_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[b+1];
		int cnt = 0;
		int num = 1;
		for(int i=1; i<=b; i++) {
			arr[i] = num;
			if(++cnt==num) {
				cnt = 0;
				num++;
			}
		}
		int answer = 0;
		for(int i=a; i<=b; i++) {
			answer += arr[i];
		}
		System.out.println(answer);
	}
}
