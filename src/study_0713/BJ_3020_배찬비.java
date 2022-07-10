package study_0713;
import java.io.*;
import java.util.*;

public class BJ_3020_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] stone = new int[2][h+1];
		int[] destroy = new int[h+1];
		int min = 0;
		int cnt = 0;
		
		for(int i=0; i<n/2; i++) {
			stone[0][Integer.parseInt(br.readLine())]++;
			int k = Integer.parseInt(br.readLine());
			stone[1][h-k+1]++;
		}
		
		for(int i=h-1; i>0; i--) stone[0][i] += stone[0][i+1];
		for(int i=1; i<=h; i++) stone[1][i] += stone[1][i-1];
		for(int i=1; i<=h; i++) {
			destroy[i] = stone[0][i] + stone[1][i];
			//System.out.println(stone[0][i]+" "+stone[1][i]+" "+destroy[i]+" ");
		}
		
		Arrays.sort(destroy);
		min = destroy[1];
		for(int i=1; i<=h; i++) {
			if(min==destroy[i]) cnt++;
			else break;
		}
		
		System.out.println(min+" "+cnt);
		
	}

}
