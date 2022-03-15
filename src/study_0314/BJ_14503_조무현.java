package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_조무현 {
	static int cleaned_block = 0;
	static int N, M;
	static int R, C, D;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][]map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean valid = true;
		while(true) {
			// 1. 현재위치를 청소한다.
			map[R][C] = 2;
			cleaned_block++;
			int cnt = 0;
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
			while(true) {
				// 2-1 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
				int left = (D+3)%4;
				int ny = R + dy[left];
				int nx = C + dx[left];
				if(ny > 0 && nx > 0 && ny < N && nx < M && map[ny][nx] == 0) {
					D = left;
					R = ny;
					C = nx;
					break;
				}
				// 2-2 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
				if(cnt < 4) {
					cnt++;
					D = left;
					continue;
				}
				
				// 2-3 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
				if(cnt == 4) {
					int back = (D+2)%4;
					ny = R + dy[back];
					nx = C + dx[back];
					if(ny > 0 && nx > 0 && ny < N && nx < M && map[ny][nx] == 2) {
						R = ny;
						C = nx;
						cnt = 0;
					}else {
						valid = false;
						break;
					}
				}
			}
			
			if(!valid) break;
			
		}
		
		System.out.println(cleaned_block);
		
	}

}
