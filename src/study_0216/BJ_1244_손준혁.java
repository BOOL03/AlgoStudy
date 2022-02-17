package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_손준혁 {
	static int N, student, gender, num;
	static int[] switchs;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switchs = new int[N+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			num();
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(switchs[i]+" ");
			if(i%20 == 0) System.out.println();
		}
	}
	static void num() {
		if(gender == 1) {
			for (int i = num; i <= N; i+=num) {
				switchs[i] = 1 - switchs[i];
			}
		}
		else if(gender == 2){
			int repeat = 1;
			switchs[num] = 1 - switchs[num];
			while(true) {
				if(repeat+num > N || num-repeat < 1) break;
				if(switchs[repeat+num] == switchs[num-repeat]) {
					switchs[repeat+num] = 1 - switchs[repeat+num];
					switchs[num-repeat] = 1 - switchs[num-repeat];
					repeat++;
				}
				else break;
			}
		}
	}

}
