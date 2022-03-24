package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16113_시그널 {
	static int N;
	static char[][] signal;
	
	static String[] num = new String[10];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
	
		
		int idx = 0;
		int len = N/5;
		signal = new char[5][len];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <len ; j++) {
				signal[i][j] = str.charAt(idx++);
			}
		}
		
		num[0] = "####.##.##.####";
		num[1] = "#####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[4] = "#.##.####..#..#";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";
		
		for (int i = 0; i < len; i++) {
			if(signal[0][i] == '#') {
				boolean isOne = true;
				for (int j = 0; j < 5; j++) {
					if(signal[j][i] != num[1].charAt(j)) {
						isOne = false;
						break;
					}
				}
				if(isOne) {
					if(i+1 < len) {
						for (int j = 0; j < 5; j++) {
							if(signal[j][i+1] != '.') {
								isOne = false;
								break;
							}
						}
					}
				}
				if(isOne) sb.append(1);
				else {
					for (int k = 0; k < 10; k++) {
						if(k==1) continue;
						idx = 0;
						boolean isNum = true;
						outer : for (int y = 0; y < 5; y++) {
							for (int x = 0; x < 3; x++) {
								if(signal[y][i+x] != num[k].charAt(idx++)) {
									isNum = false;
									break outer; 
								}
							}
						}
						if(isNum) {
							sb.append(k);
							i+=3;
							break;
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
