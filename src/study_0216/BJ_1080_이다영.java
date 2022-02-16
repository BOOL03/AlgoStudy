package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_행렬_1080 {
	static int N, M, ans;
	
	static char[][] src;
	static char[][] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		
		src = new char[N][];
		tgt = new char[N][];
		
		for (int i = 0; i < N; i++) {
			src[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			tgt[i] = br.readLine().toCharArray();
		}
		
		// 3칸씩 바꾸기 때문에 인덱스는 N-2, M-2 까지!
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if(src[i][j] != tgt[i][j]) { // 다른 부분이 있다면 for문을 통해 바꿔줌
					ans++; // 바꾼 횟수 증가
					for (int y = 0; y < 3; y++) {
						for (int x = 0; x < 3; x++) {
							src[i+y][j+x] = src[i+y][j+x]=='0'? '1' : '0';
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) { // 최종적으로 두 배열이 같은지 확인, 다르다면 -1 출력
			for (int j = 0; j < M; j++) {
				if(src[i][j] != tgt[i][j]) {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);

	}
}
