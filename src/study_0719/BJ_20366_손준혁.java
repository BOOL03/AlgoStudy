package study_0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20366_손준혁 {
	static int[] list;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(list);
        calc(N);
        
        System.out.println(min);
	}
	static void calc(int N) {
		for (int i = 0; i < N; i++) {
        	for (int j = i+1; j < N; j++) {
        		int smallSnowMan = list[i] + list[j];
        		int start = 0;
        		int end = N-1;
        		while(start < end) {
        			if(start == i || start == j) {
        				start++;
        				continue;
        			}
        			if(end == i || end == j) {
        				end--;
        				continue;
        			}
        			int bigSnowMan = list[start] + list[end];
        			if(min > Math.abs(bigSnowMan - smallSnowMan)) {
        				min = Math.abs(bigSnowMan - smallSnowMan);
        			}
        			
        			if(smallSnowMan < bigSnowMan) end--;
        			else if(smallSnowMan > bigSnowMan) start++;
        			else {
        				min = 0;
        				return;
        			}
        		}
			}
		}
	}

}
