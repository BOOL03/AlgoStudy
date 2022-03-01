package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_거짓말_1043 {
	static int N, M, S, ans;
	static boolean[] secret;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		secret = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		for (int i = 0; i < S; i++) {
			secret[Integer.parseInt(st.nextToken())] = true;
		}
		
		int[][] party = new int[M][];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			
			party[i] = new int[size];
			for (int j = 0; j <size; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		Arrays.sort(party, (n1, n2) -> n2.length - n1.length );
		
		
		
		for (int i = 0; i < M; i++) {
			boolean chk = true;
			int size = party[i].length;
			int [] temp = new int[size];
			
			for (int j = 0; j < size; j++) {
				if(secret[party[i][j]]) chk = false;
			}
			if(chk) ans++;
			else {
				for (int j = 0; j < size; j++) {
					secret[party[i][j]] = true;
				}
			}
		}
	

//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int size = Integer.parseInt(st.nextToken());
//			boolean chk = true;
//			int [] temp = new int[size];
//			for (int j = 0; j < size; j++) {
//				temp[j] = Integer.parseInt(st.nextToken());
//				if(secret[temp[j]]) chk = false;
//			}
//			if(chk) ans++;
//			else {
//				for (int j = 0; j < size; j++) {
//					secret[temp[j]] = true;
//				}
//			}
//		}
		System.out.println(ans);
	}
}
