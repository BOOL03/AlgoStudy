package study_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14890_손준혁 {
	static int [][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int load = 0;
		for (int i = 0; i < n; i++) {//세로
			int tmp = map[i][0];
			int count = 0;
			boolean check = true;
			for (int j = 0; j < n; j++) {
				if(map[i][j] == tmp) {
					count++;
				}
				else {
					if(count < l || Math.abs(tmp - map[i][j]) > 1) {
						j = n-1;
						check = false;
						continue;
					}
					tmp = map[i][j];
				}
			}
			if(check) load++;
		}
		System.out.println(load);
	}

}
