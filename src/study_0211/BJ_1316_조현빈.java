package study_0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1316_조현빈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br        = new BufferedReader(new InputStreamReader(System.in));
		int            N         = Integer.parseInt(br.readLine());
		String         str       = null;
		int[]          alphabet  = null;
		char           prevAlpha = 'A';
		char           curAlpha  = 'A';
		int            cnt       = 0;

		continuePoint: for (int i = 0; i < N; i++) {
			alphabet                 = new int[27];
			str                      = br.readLine();
			prevAlpha                = str.charAt(0);
			alphabet[prevAlpha - 96] = 1;

			for (int j = 1; j < str.length(); j++) {
				curAlpha = str.charAt(j);
				if (prevAlpha != curAlpha) {
					if (alphabet[curAlpha - 96] == 1) {
						continue continuePoint;
					} else {
						alphabet[curAlpha - 96] = 1;
						prevAlpha               = curAlpha;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
