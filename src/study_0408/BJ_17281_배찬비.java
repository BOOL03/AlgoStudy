package study_0408;
import java.io.*;
import java.util.*;

public class BJ_17281_배찬비 {
	
	// 1번 선수는 4번째 고정
	// 나머지 8명의 선수를 순열로 정함
	// n이닝을 돌면서 점수를 더한다 
	static int[][] score;
	static int n, answer;
	static int[] seq, seqtmp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		score = new int[n][10];
		seq = new int[9];
		seqtmp = new int[8];
		for(int i=0; i<8; i++) seqtmp[i] = i+2;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<10; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(!np()) break; // 순열 만들기 
		}
		System.out.println(answer);
	}
	
	static boolean np() {
		int i = 7;
		while(i>0 && seqtmp[i-1]>=seqtmp[i]) i--;
		
		if(i==0) return false;
		
		int j = 7;
		while(seqtmp[i-1]>=seqtmp[j]) j--;
		
		swap(i-1, j);
		
		int k = 7;
		while(i<k) swap(i++, k--);
		
		game(); //순서를 정했으니 게임을 한다 
		
		return true;
	}
	
	static void swap(int i, int j) {
		int tmp = seqtmp[i];
		seqtmp[i] = seqtmp[j];
		seqtmp[j] = tmp;
	}
	
	static void game() {
		for(int i=0; i<3; i++) seq[i] = seqtmp[i];
		seq[3] = 1;
		for(int i=4; i<9; i++) seq[i] = seqtmp[i-1];
		
		int player = 0; // 타자 index 
		int ground = 0; // 홈, 1루, 2루, 3루 상황 
		int sum = 0; // 점수 
		for(int i=0; i<n; i++) {
			int out = 0;
			ground = 0;
			while(out<3) { // out 이 3번 될때까지 진행 
				ground |= 1;  // 타석에 타자가 선다 
				int num = score[i][seq[player]]; // 얼마나 칠 수 있는지 
				player = (player+1)%9; // 다음 선수 지목 
				if(num==0) {  // 안타치면 아웃 
					out++;
					continue;
				}
				for(int j=4; j>4-num; j--) { 
					if((ground & (1<<(j-1)))!=0) sum++;
				}
				ground = ground<<num;
				ground &= 15;
			}
		}
		
		answer = Math.max(answer, sum);
	}
	
}