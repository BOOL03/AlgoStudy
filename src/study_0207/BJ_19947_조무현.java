package study_0207;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19947_조무현 {
	static int H, Y;
	static int max[] = new int[11];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		max[0] = H;
		for (int i = 0; i <= Y; i++) {
			if(i+1 <= Y) max[i+1] = Math.max(max[i+1], (int)(max[i] * 1.05));
			// 1년과 3년이자의 비교
			if(i+3 <= Y) max[i+3] = Math.max(max[i+3], (int)(max[i] * 1.2));
			
			if(i+5 <= Y) max[i+5] = Math.max(max[i+5], (int)(max[i] * 1.35));
			// 1년과 5년이자의 비교
		}
		System.out.println(max[Y]);
	}
	
	static void tooja1() {
		
	}

}
