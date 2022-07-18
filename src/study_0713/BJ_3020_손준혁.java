package study_0713;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020_손준혁 {
	
	static int[] ceil,floor;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		ceil= new int[H+1];
        floor = new int[H+1];

        for (int i = 0; i < N/2 ; i++) {
            floor[Integer.parseInt(br.readLine())]++;
            ceil[Integer.parseInt(br.readLine())]++;
        }

        for (int i = H-1; i >0 ; i--) {
            ceil[i] += ceil[i+1];
            floor[i] += floor[i+1];
        }

        int[] stone = new int[H+1];
        int min = N+1;

        for (int i = 1; i <= H ; i++) {
            stone[i] = floor[i] + ceil[H-i+1];
            min = Math.min(min, stone[i]);
        }
        int cnt = 0;
        for (int i = 1; i <= H ; i++) {
            if(stone[i] == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);      
	}

}

