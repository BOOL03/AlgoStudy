package study_0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17281_조무현 {
	static int N, max;
	static int[][] map;
	static int[] lineup = new int[10];
	static int[] base = new int[3]; // 1루, 2루, 3루
	static int[] src = new int[8];
	static boolean[] select = new boolean[8];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][10];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		System.out.println(max);
	}
	static void inning(int in, int score, int start) {
		if(in > N) {
			//System.out.println(Arrays.toString(lineup));
			max = Math.max(score, max);
			return;
		}
		// 이닝별로 타자가 치는 안타에 따라서 베이스 처리(아웃 처리)
		// 점수 기록
		// 다음 타자 지정
		int out_count = 0;
		int cur_score = 0;
		int cur_index = start;
		// 현재 이닝의 선수들 안타 
		int[] current = map[in];
		while(out_count < 3) {
			// 어떤 안타치는지 혹은 아웃인지
			int cur_player = lineup[cur_index];
			int hit = current[cur_player];
			switch(hit) {
			case 1:
				if(base[2] > 0) cur_score++;
				base[2] = base[1];
				base[1] = base[0];
				base[0] = cur_player;
				break;
			case 2:
				if(base[2] > 0) cur_score++;
				if(base[1] > 0) cur_score++;
				base[2] = base[0];
				base[1] = cur_player;
				base[0] = 0;
				break;
			case 3:
				if(base[2] > 0) cur_score++;
				if(base[1] > 0) cur_score++;
				if(base[0] > 0) cur_score++;
				base[2] = cur_player;
				base[1] = 0;
				base[0] = 0;
				break;
			case 4:
				for (int i = 0; i < 3; i++) {
					if(base[i] > 0) cur_score++;
				}
				Arrays.fill(base, 0);
				// 홈런친 타자까지
				cur_score++;
				break;
			case 0:
				out_count++;
				break;
			}
			cur_index = (cur_index - 8) > 0 ? 1 : cur_index + 1;
		}
		// 베이스를 비우고
		Arrays.fill(base, 0);
		// 다음 이닝으로
		inning(in + 1, score + cur_score, cur_index);
		
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == 8) {
			for (int i = 0; i <= 2; i++) {
				lineup[i+1] = src[i];
			}
			// 4번타자는 항상 1번
			lineup[4] = 1;
			for (int i = 3; i < 8; i++) {
				lineup[i+2] = src[i];
			}
			inning(1, 0, 1);
			return;
		}

		for (int i = 0; i < 8; i++) {
			if(select[i]) continue;
			select[i] = true;
			src[tgtIdx] = i+2;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

}
