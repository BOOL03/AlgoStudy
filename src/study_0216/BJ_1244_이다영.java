package study_0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_이다영 {
	static int N;
	static int[] switches;
	static int M;
	static Student[]  student; 
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		switches = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		student = new Student[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			student[i] = new Student(s, n);
		}
		
		for (int i = 0; i < M; i++) {
			if(student[i].s == 1) boy(student[i].n);
			else girl(student[i].n);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(switches[i]).append(" ");
			if(i%20 == 0) sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	static void boy(int num) {
		for (int i = 1; i <= N; i++) {
			if(i % num == 0) {
				switches[i] = switches[i]==0 ? 1 : 0;
			}
		}
	}
	static void girl(int num) {
		switches[num] = switches[num]==0 ? 1 : 0;
		
		int left = num;
		int right = num;
		
		while(true) {
			if(num == 1 || num == N) break; //젤 끝이라면 break
			if(left <= 1 || right >= N) break; // break;

			left --;
			right ++;
			
			if(switches[left] == switches[right]) {
				switches[left] = switches[left]==0 ? 1 : 0;
				switches[right] = switches[right]==0 ? 1 : 0;
			}
			else break;
		}
	}
	static class Student{
		int s;
		int n;
		
		public Student(int s, int n) {
			this.s = s;
			this.n = n;
		}
	}

}
