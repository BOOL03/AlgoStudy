package study_0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5904_손준혁 {
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N < 16) {
			if(N == 1 || N == 4 || N == 8 || N == 11) System.out.println("m");
			else System.out.println("o");
			return;
		}
		else {
			int k = findK();
			if(k == -1) {
				System.out.println("m");
				return;
			}
			if(N < 3) {
				System.out.println("o");
				return;
			}
		}
	}
	static int findK() {
		int start_len = 7;
		int k = 2;
		while(true) {
			int compare = start_len*2 + k + 6;
			if(N < compare+1) {
				N -= start_len;
				return k;
			}
			else if(N == compare + 1) {
				return -1;
			}
			k++;
			start_len = compare;
		}
	}
	
	static void Moo(int num){ 
		int size=3; 
		int index=0; 
		char answer;
		if(num==1){ 
			answer='m'; 
		}
		else if(num<=3) answer='o'; 
		else{ 
			while(size<num){ 
			size=size*2+index+4; index++; 
			} 
			int front_back=(size-index-3)/2; 
			if(size-front_back+1<=num){ 
				Moo(num-size+front_back); 
			}
			else if(num==front_back+1) answer='m';
			else answer='o'; 
		} 
	}

}
