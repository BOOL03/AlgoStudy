package study_0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_손준혁 {
	static int N, MaxCost = 0;
	static int[] cards, selected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cards = new int[N+1];
		selected = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		dp();
		//System.out.println(MaxCost);
		System.out.println(selected[N]);
	}
	static void calc(int card, int cost) {
		if(card == N){
			MaxCost = Math.max(MaxCost, cost);
			return;
		}
		else if(card < N) {
			for (int i = N-1; i >= 0; i--) {
				if(card + i +1 > N) continue;
				calc(card+i+1, cost+cards[i]);
			}
		}
	}
	static void dp() {
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                selected[i] = Math.max(selected[i], selected[i - j] + cards[j]);
            }
        }
	}
}
