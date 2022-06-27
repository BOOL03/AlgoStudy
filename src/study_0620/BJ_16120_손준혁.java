package study_0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16120_손준혁 {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean isPpap = false;
        String str = br.readLine();
        int strLen = str.length();
        int cnt = 0;

        if(str.charAt(strLen-1) == 'P'){
            isPpap = true;
            for (int i = 0; i < strLen; i++) {
                char curCh = str.charAt(i);
                if (curCh == 'P') {
                    cnt++;
                } else if (curCh == 'A') {
                    if (str.charAt(i + 1) != 'P' || cnt < 2) {
                        isPpap = false;
                        break;
                    }
                    cnt -= 2;
                }
            }
            if (cnt != 1) {
                isPpap = false;
            }
        }
        if (isPpap) {
            System.out.println("PPAP");
        } else {
            System.out.print("NP");
        }
    }
}
